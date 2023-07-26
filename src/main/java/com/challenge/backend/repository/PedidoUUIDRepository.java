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
public interface PedidoUUIDRepository<Pedido, UUID> extends JpaRepository<Pedido, UUID> {

	List<Pedido> findAll();
//	Optional<Pedido> findByUuid(UUID uuid);
//
//	Optional<Pedido> findIdByUuid(UUID uuid);
	
//    Optional<E> findByUuid(UUID uuid);

//    Optional<ProjectId> findIdByUuid(UUID uuid);
/*
    default E findRequiredByUuid(String uuid) {
        return findByUuid(UUID.fromString(uuid)).orElseThrow(() ->
                new NoSuchElementException("No Element with UUID: <"+uuid+"> was found in Database"));
    }

    default long findIdRequiredByUuid(String uuid) {
        return findIdByUuid(UUID.fromString(uuid)).orElseThrow(() ->
                new NoSuchElementException("No Element with UUID: <"+uuid+"> was found in Database"))
                .getId();
    }
}
interface ProjectId {
    long getId();
}
*/

}
