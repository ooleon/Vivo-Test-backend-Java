package com.challenge.backend.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.hibernate.type.descriptor.java.UUIDJavaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;
import com.challenge.backend.entities.*;
import com.challenge.backend.repository.DetalhePedidoRepository;
import com.challenge.backend.repository.PedidoRepository;
import com.challenge.backend.repository.PedidoUUIDRepository;
import com.challenge.backend.util.EstadoPedido;

@PropertySource("classpath:/application.properties")
@Service
@Transactional
public class PedidoService {
	    private final Logger log = LoggerFactory.getLogger(PedidoService.class);

	@Autowired
	Environment env;

	@Autowired
	PedidoRepository pedidoRepository;

	public List<Pedido> findByEstado(EstadoPedido estadoPedido) {		
		return pedidoRepository.findByEstado(estadoPedido.etiqueta);
	}

	public Optional<Pedido> findById(UUID uuid) {
		
		return pedidoRepository.findById(uuid);
	}

	public Optional<Pedido> findByUuid(UUID uuid) {
		return pedidoRepository.findByUuid(uuid);
	}

	public Pedido save(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	public List<Pedido> findAll() {		
		return pedidoRepository.findAll();
	}

}
