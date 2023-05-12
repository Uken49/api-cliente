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
    String zipCode;
    String street;
    String complement;
    String neighborhood;
    String city;
    String state;
    Integer house_number;
    LocalDateTime created_at;
    LocalDateTime updated_at;

    @Builder
    public AddressEntity(String zipCode, String street, String complement, String neighborhood, String city, String state, Integer house_number) {
        this.id = UUID.randomUUID();
        this.zipCode = zipCode;
        this.street = street;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.house_number = house_number;
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public String getZipCode() {
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

    public Integer getHouse_number() {
        return house_number;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

}
