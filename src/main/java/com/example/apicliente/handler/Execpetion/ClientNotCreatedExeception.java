package com.example.apicliente.handler.Execpetion;

import jakarta.validation.ValidationException;

public class ClientNotCreatedExeception extends ValidationException {

    public ClientNotCreatedExeception(String message) {
        super(message);
    }

}
