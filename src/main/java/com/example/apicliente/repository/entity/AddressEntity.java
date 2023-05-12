package com.example.apicliente.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Address")
public class AddressEntity {

    @Id
    UUID id;
    Integer zipCode;
    String street;
    String complement;
    String neighborhood;
    String city;
    String state;
    Integer houseNumber;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    @Builder
    public AddressEntity(Integer zipCode, String street, String complement, String neighborhood, String city, String state, Integer houseNumber) {
        this.id = UUID.randomUUID();
        this.zipCode = zipCode;
        this.street = street;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.houseNumber = houseNumber;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public String getStreet() {
        return street;
    }

    public String getComplement() {
        return complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

}
