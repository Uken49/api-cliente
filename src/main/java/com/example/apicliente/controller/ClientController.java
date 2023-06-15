package com.example.apicliente.controller;

import com.example.apicliente.controller.request.ClientRequest;
import com.example.apicliente.controller.response.ClientResponse;
import com.example.apicliente.service.ClientService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
@Validated
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientResponse create(@Valid @RequestBody ClientRequest clientRequest){
        return clientService.create(clientRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientResponse getClientById(@PathVariable UUID id){
        return clientService.getClientById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClientResponse> getClientByCpf(
            @RequestParam(required = false) @CPF @Valid String cpf
    ){
        if (Objects.nonNull(cpf)) {
            return clientService.getClientByCpf(cpf);
        }

        return clientService.getAllClients();
    }
}
