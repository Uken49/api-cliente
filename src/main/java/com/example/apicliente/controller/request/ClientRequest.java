package com.example.apicliente.controller.request;


import java.time.LocalDate;

public record ClientRequest(
        String name,
        Integer cpf,
        LocalDate birthDate,
        AddressRequest address
) {

    public record AddressRequest(
            String zipCode,
            String complement,
            Integer house_number
    ){
    }

}
