package com.example.apicliente.controller.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record ClientResponse(
        UUID id,
        String name,
        Integer cpf,
        LocalDate birthDate,
        AddressResponse address,
        LocalDateTime createdAt,
        LocalDateTime updatedAt

) {

    public record AddressResponse(
            UUID id,
            Integer zipCode,
            String street,
            String complement,
            String neighborhood,
            String city,
            String state,
            Integer house_number,
            LocalDateTime created
    ){}
}
