package com.example.apicliente.service;

import com.example.apicliente.controller.request.ClientRequest;
import com.example.apicliente.controller.response.ClientResponse;
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

    private ClientRepository repository;
    private final ClientMapper mapper;

    public ClientResponse create(ClientRequest clientRequest){
        LoggerUtil.logInfo("Entrando na service", this.getClass());

        final ClientModel clientModel = mapper.fromModel(clientRequest);

        final ClientEntity clientEntity = mapper.fromEntity(clientRequest);
        ClientEntity clientSave = repository.save(clientEntity);

        LoggerUtil.logInfo("Retornando cadastro", this.getClass());
        return mapper.fromResponse(clientSave);
    }
}
