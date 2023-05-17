package com.example.apicliente.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record AddressModel(@NotBlank(message = "zipCode: deve estar no formato XXXXXXXX ou XXXXX-XXX") String zipCode,
                           @NotBlank(message = "street: não pode ser nulo") String street, String complement,
                           @NotBlank(message = "neighborhood: não pode ser nulo") String neighborhood,
                           @NotBlank(message = "city: não pode ser nulo") String city, @NotBlank(message = "state: não pode ser nulo") String state,
                           @NotBlank(message = "houseNumber: não pode ser nulo") Integer houseNumber) {

    @Builder
    public AddressModel(String zipCode, String street, String complement, String neighborhood, String city, String state, Integer houseNumber) {
        this.zipCode = zipCode;
        this.street = street;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.houseNumber = houseNumber;
    }

}
