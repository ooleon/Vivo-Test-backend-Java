package com.challenge.backend.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//import aws.model.Table1;
import com.challenge.backend.entities.*;


@Repository
public interface DetalhePedidoRepository extends CrudRepository<DetalhePedido, Long> {

	List<DetalhePedido> findAll();

    Optional<DetalhePedido> findById(Long id);

    List<DetalhePedido> findByPedido(Pedido pedido);
}
