package com.example.apicliente.model;

public record AddressModel(
        String zipCode,
        String street,
        String complement,
        String neighborhood,
        String city,
        String  state,
        Integer house_number
) {
}
