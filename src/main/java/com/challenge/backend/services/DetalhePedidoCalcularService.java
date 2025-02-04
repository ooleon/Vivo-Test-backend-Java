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
public class DetalhePedidoCalcularService {
	private final Logger log = LoggerFactory.getLogger(DetalhePedidoCalcularService.class);

	@Autowired
	Environment env;

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	ConsumerRestService consumidorRestService;

//	@Autowired
//	DetalhePedidoRepository detalhePedidoRepository;

	@Autowired
	DetalhePedidoService detalhePedidoService;


	public Pedido generarPedidoDesdeDTO(PedidoDTO pedidoDTO) {

		Pedido pedido = new Pedido();
		pedido.setUsuarioid(pedidoDTO.getUsuarioid());

//		pedido = this.save(pedido);

//		pedido = detalhePedidoService.agregarDetalhe(pedido);
		
		
//		pedido = this.save(pedido);

		// TODO pedidoService de PedidoDTO a Pedido (con detalle).
		return pedido;
	}

	public Pedido agregarDetalhe(Pedido pedido) {
		List<DetalhePedido> ldp = new ArrayList<>();
//		ldp = detalhePedidoService.findByPedido(pedido);		
//		ldp=detalhePedidoService.recalcularDetalhePedido(ldp);

		ldp = detalhePedidoService.findByPedido(pedido);		
		ldp=this.recalcularDetalhePedido(ldp);

		// TODO recalcular produto repetido
		if (pedido.getDetalhes() != null) {
			List<DetalhePedido> ldp1 = pedido.getDetalhes();
			ldp1.addAll(ldp);
		}

		pedido.setDetalhes(ldp);
		return pedido;
	}

	public List<DetalhePedido> recalcularDetalhePedido(List<DetalhePedido> listDetalhePedido) {
		// TODO Auto-generated method stub
		/*
		 1. validar lista no null
		 2. 
		 
		 */
		return null;
	}

	
}
