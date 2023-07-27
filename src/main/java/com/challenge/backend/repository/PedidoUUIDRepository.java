package com.challenge.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//import aws.model.Table1;
import com.challenge.backend.entities.*;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.NoSuchElementException;
import java.util.Optional;

//@Repository
@NoRepositoryBean
public interface PedidoUUIDRepository<Pedido, UUID> extends CrudRepository<Pedido, UUID> {


	Optional<Pedido> findByUuid(UUID uuid);

    default Optional<Pedido>  findRequiredByUuid(UUID uuid) {
        return findByUuid( uuid );
    }
    

}
