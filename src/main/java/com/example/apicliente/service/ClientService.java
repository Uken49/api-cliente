package com.example.apicliente.service;

import com.example.apicliente.apiviacep.ApiViaCep;
import com.example.apicliente.apiviacep.dto.AddressApiViaCep;
import com.example.apicliente.controller.request.ClientRequest;
import com.example.apicliente.controller.response.ClientResponse;
import com.example.apicliente.handler.Execpetion.ClientNotCreatedExeception;
import com.example.apicliente.mapper.ClientMapper;
import com.example.apicliente.model.ClientModel;
import com.example.apicliente.repository.ClientRepository;
import com.example.apicliente.repository.entity.ClientEntity;
import com.example.apicliente.util.LoggerUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;
    private final ClientMapper mapper;
    private final ApiViaCep apiViaCep;


    public ClientResponse create(ClientRequest clientRequest){
        LoggerUtil.logInfo("Entrando na service", this.getClass());

        final ClientModel clientModel = mapper.fromModel(clientRequest);
        clientExist(clientModel.cpf());

        final AddressApiViaCep addressApiViaCep = apiViaCep.viaCepString(clientModel.address().zipCode());
        final ClientModel clientWithAddress = clientModel.clientWithAddress(addressApiViaCep);

        final ClientEntity clientEntity = mapper.fromEntity(clientWithAddress);
        final ClientEntity clientSave = repository.save(clientEntity);

        LoggerUtil.logInfo("Retornando cadastro", this.getClass());
        return mapper.fromResponse(clientSave);
    }

    private void clientExist(String cpf){
        if (repository.existsByCpf(cpf))
           throw new ClientNotCreatedExeception("cpf: %s já foi cadastrado".formatted(cpf));
    }
}
