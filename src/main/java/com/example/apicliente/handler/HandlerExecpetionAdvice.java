package com.example.apicliente.handler;

import com.example.apicliente.handler.Execpetion.ClientNotFoundException;
import jakarta.validation.ValidationException;
import java.net.URI;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerExecpetionAdvice {

    private ProblemDetail builderProblemDetail(String title, HttpStatus status, String detail) {
        final ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(status, detail);

        problemDetail.setTitle(title);
        problemDetail.setType(URI.create(""));
        problemDetail.setProperty("timestamp", LocalDateTime.now());

        return problemDetail;
    }

    @ExceptionHandler(ValidationException.class)
    public ProblemDetail clientNotCreated(ValidationException ve) {

        return builderProblemDetail("Usuário não pôde ser criado", HttpStatus.BAD_REQUEST, ve.getMessage());
    }

    @ExceptionHandler(ClientNotFoundException.class)
    public ProblemDetail clientNotFound(ClientNotFoundException cnfe) {

        return builderProblemDetail("Usuário não encontrado", HttpStatus.NOT_FOUND, cnfe.getMessage());
    }

}
