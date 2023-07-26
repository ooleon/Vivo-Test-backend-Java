package com.challenge.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//import aws.model.Table1;
import com.challenge.backend.entities.*;

@Repository
public interface PedidoProdutosRepository extends CrudRepository<DetalhePedido, Long> {

	List<DetalhePedido> findAll();

/*
    Optional<Pedido> findById(Long table1Id);

    List<Pedido> findByPedidoId(Long table1Id);
*/
}
