package com.example.apicliente.service;

import com.example.apicliente.apiviacep.ApiViaCep;
import com.example.apicliente.apiviacep.dto.AddressApiViaCep;
import com.example.apicliente.controller.request.ClientRequest;
import com.example.apicliente.controller.response.ClientResponse;
import com.example.apicliente.handler.Execpetion.ClientNotCreatedExeception;
import com.example.apicliente.handler.Execpetion.ClientNotFoundException;
import com.example.apicliente.mapper.ClientMapper;
import com.example.apicliente.model.ClientModel;
import com.example.apicliente.repository.ClientRepository;
import com.example.apicliente.repository.entity.ClientEntity;
import com.example.apicliente.util.LoggerUtil;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;
    private final ClientMapper mapper;
    private final ApiViaCep apiViaCep;


    public ClientResponse create(ClientRequest clientRequest) {
        LoggerUtil.logInfo("Entrando na service", this.getClass());

        final ClientModel clientModel = mapper.fromModel(clientRequest);
        if (repository.existsByCpf(clientModel.cpf())) {
            throw new ClientNotCreatedExeception("cpf: %s já foi cadastrado".formatted(clientModel.cpf()));
        }

        final AddressApiViaCep addressApiViaCep = apiViaCep.viaCepString(clientModel.address().zipCode());

        final ClientModel clientWithAddress = clientModel.clientWithAddress(addressApiViaCep);
        final ClientEntity clientEntity = mapper.fromEntity(clientWithAddress);
        final ClientEntity clientSave = repository.save(clientEntity);

        LoggerUtil.logInfo("Retornando cadastro", this.getClass());
        return mapper.fromResponse(clientSave);
    }

    public ClientResponse getClientById(UUID id) {

        final ClientEntity clientEntity = repository.findById(id).orElseThrow(
                () -> new ClientNotFoundException("Cliente com id: %s não foi encontrado".formatted(id))
        );

        return mapper.fromResponse(clientEntity);
    }

    public List<ClientResponse> getClientByCpf(String cpf) {
        ClientEntity clientEntity = repository.findByCpf(cpf).orElseThrow(
                () -> new ClientNotFoundException("Cliente com cpf: %s não foi encontrado".formatted(cpf))
        );
        return List.of(mapper.fromResponse(clientEntity));
    }

    public List<ClientResponse> getAllClients() {
        final List<ClientEntity> clients = repository.findAll();

        return clients.stream()
                .map(mapper::fromResponse)
                .toList();
    }
}
