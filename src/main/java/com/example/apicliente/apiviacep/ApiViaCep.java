package com.example.apicliente.apiviacep;

import com.example.apicliente.apiviacep.dto.AddressApiViaCep;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "apiViaCep", url = "https://viacep.com.br/ws/")
public interface ApiViaCep {

    @GetMapping("/{zipCode}/json")
    AddressApiViaCep viaCepString(@PathVariable("zipCode") String zipCode);
}
