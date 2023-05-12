package com.example.apicliente.mapper;

import com.example.apicliente.controller.request.ClientRequest;
import com.example.apicliente.controller.response.ClientResponse;
import com.example.apicliente.repository.entity.AddressEntity;
import com.example.apicliente.repository.entity.ClientEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressEntity fromEntity(ClientRequest.AddressRequest addressRequest);
    ClientResponse.AddressResponse fromResponse(ClientEntity clientEntity);
}
