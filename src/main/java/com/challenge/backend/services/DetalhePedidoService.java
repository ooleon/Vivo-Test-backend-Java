package com.challenge.backend.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
public class DetalhePedidoService {
	    private final Logger log = LoggerFactory.getLogger(DetalhePedidoService.class);

	@Autowired
	Environment env;

	@Autowired
	DetalhePedidoRepository detalhePedidoRepository;



	public List<DetalhePedido> findByPedido(Pedido pedido) {
		
		return detalhePedidoRepository.findByPedido(pedido);
	}


	public void delete(DetalhePedido detalhePedido) {
		detalhePedidoRepository.delete(detalhePedido);
	}

	public DetalhePedido save(DetalhePedido detalhePedido) {
		return detalhePedidoRepository.save(detalhePedido);
	}

	public List<DetalhePedido> getAll() {
		
		return detalhePedidoRepository.findAll();
	}


	
	
}
