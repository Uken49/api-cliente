package com.example.apicliente.repository;

import com.example.apicliente.repository.entity.ClientEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, UUID> {

    boolean existsByCpf(String cpf);
    Optional<ClientEntity> findByCpf(String cpf);
}
