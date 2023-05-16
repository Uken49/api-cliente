package com.example.apicliente.model;

import com.example.apicliente.apiviacep.dto.AddressApiViaCep;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Builder;

import java.time.LocalDate;
import org.hibernate.validator.constraints.br.CPF;

public record ClientModel(
        @NotBlank
        String name,
        @CPF
        String cpf,
        @PastOrPresent(message = "A data não pode ser futura")
        LocalDate birthdate,
        @Valid
        AddressModel address
) {

    @Builder(toBuilder = true)
    public ClientModel (String name, String cpf, LocalDate birthdate, AddressModel address){
        this.name = name;
        this.cpf = cpf;
        this.birthdate = birthdate;
        this.address = address;
    }

    public ClientModel clientWithAddress(AddressApiViaCep addressViaCep) {
        return this.toBuilder()
                .address(AddressModel.builder()
                        .zipCode(addressViaCep.cep())
                        .street(addressViaCep.logradouro())
                        .city(addressViaCep.localidade())
                        .state(addressViaCep.uf())
                        .neighborhood(addressViaCep.bairro()).build()
                ).build();
    }
}
