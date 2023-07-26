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

@Repository
public interface PedidoRepository extends PedidoUUIDRepository<Pedido, UUID> {

//	List<Pedido> findAll();
//	Optional<Pedido> findByUuid(UUID uuid);
//
//	Optional<Pedido> findIdByUuid(UUID uuid);
	/*
	 * Optional<Pedido> findById(Long table1Id);
	 * 
	 * List<Pedido> findByPedidoId(Long table1Id);
	 */
}
