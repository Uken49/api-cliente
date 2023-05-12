package com.example.apicliente.mapper;

import com.example.apicliente.controller.response.ClientResponse;
import com.example.apicliente.repository.entity.ClientEntity;
import com.example.apicliente.controller.request.ClientRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientEntity fromEntity(ClientRequest clientRequest);
    ClientResponse fromResponse(ClientEntity clientEntity);
}
