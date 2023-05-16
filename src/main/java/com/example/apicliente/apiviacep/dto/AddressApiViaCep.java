package com.example.apicliente.apiviacep.dto;

public record AddressApiViaCep(
        String cep,
        String logradouro,
        String bairro,
        String localidade,
        String uf
) {
}
