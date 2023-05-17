package com.example.apicliente.controller.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record ClientResponse(
        UUID id,
        String name,
        String cpf,
        LocalDate birthdate,
        AddressResponse address,
        LocalDateTime createdAt,
        LocalDateTime updatedAt

) {

    public record AddressResponse(
            UUID id,
            String zipCode,
            String street,
            String complement,
            String neighborhood,
            String city,
            String state,
            Integer houseNumber,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ){}
}
