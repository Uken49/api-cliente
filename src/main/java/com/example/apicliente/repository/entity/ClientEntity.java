package com.example.apicliente.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Client")
public class ClientEntity {
    @Id
    UUID id;
    String name;
    String cpf;
    LocalDate birthdate;
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    AddressEntity address;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public ClientEntity() {
        this.id = UUID.randomUUID();
    }

    @Builder
    public ClientEntity(String name, String cpf, LocalDate birthdate, AddressEntity address) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.cpf = cpf;
        this.birthdate = birthdate;
        this.address = address;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
