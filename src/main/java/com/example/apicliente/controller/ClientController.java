package com.example.apicliente.controller;

import com.example.apicliente.controller.request.ClientRequest;
import com.example.apicliente.controller.response.ClientResponse;
import com.example.apicliente.service.ClientService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientResponse create(@Valid @RequestBody ClientRequest clientRequest){
        return clientService.create(clientRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClientResponse> getAll(){
        return clientService.getAllClients();
    }

    @GetMapping("/{idOrCpf}")
    @ResponseStatus(HttpStatus.OK)
    public ClientResponse getClient(@PathVariable String idOrCpf){
        return clientService.getClientByIdOrCpf(idOrCpf);
    }


}
