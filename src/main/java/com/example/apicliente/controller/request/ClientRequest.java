package com.example.apicliente.controller.request;


import java.time.LocalDate;

public record ClientRequest(
        String name,
        String cpf,
        LocalDate birthdate,
        AddressRequest address
) {

    public record AddressRequest(
            String zipCode,
            String complement,
            Integer houseNumber
    ){
    }

}
