package com.example.apicliente.model;

import java.time.LocalDate;

public record ClientModel(
        String name,
        Integer cpf,
        LocalDate birthDate,
        AddressModel address
) {
}
