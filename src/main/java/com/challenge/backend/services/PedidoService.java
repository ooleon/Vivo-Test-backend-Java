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

	@Autowired
	ConsumerRestService consumidorRestService;

	@Autowired
	DetalhePedidoRepository detalhePedidoRepository;

	public Pedido generarPedidoDesdeDTO(PedidoDTO pedidoDTO) {

		Pedido pedido = new Pedido();
		pedido.setUsuarioid(pedidoDTO.getUsuarioid());
		Integer idProduto = pedidoDTO.getProdutoid();
		Double preco = consumidorRestService.getProductsList().get(idProduto);
		ProductsPojo productsPojo = new ProductsPojo(idProduto, preco);

		pedido = this.save(pedido);

		pedido = this.agregarDetalhe(pedido);
		
		
		pedido = this.save(pedido);

		// TODO pedidoService de PedidoDTO a Pedido (con detalle).
		return pedido;
	}

	public List<Pedido> findByEstado(EstadoPedido estadoPedido) {
		return agregarDetalheList(pedidoRepository.findByEstado(estadoPedido.etiqueta));
	}

	public Optional<Pedido> findById(UUID uuid) {
		Optional<Pedido> op = agregarDetalheOptional(uuid);
		return op;
	}

	public Optional<Pedido> agregarDetalheOptional(UUID uuid) {
		Optional<Pedido> op = pedidoRepository.findByUuid(uuid);
		if (op.isPresent()) {
			op.of(this.agregarDetalhe(op.get()));
		}
		return op;
	}

	public void delete(Pedido pedido) {
		pedidoRepository.delete(pedido);
	}

	public Pedido save(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	public List<Pedido> findAll() {
		return pedidoRepository.findAll();
	}

	//
	public Pedido agregarDetalhe(Pedido pedido) {
		List<DetalhePedido> ldp = new ArrayList<>();
		ldp = detalhePedidoRepository.findByPedido(pedido);

		// TODO recalcular produto repetido
		if (pedido.getDetalhes() != null) {
			List<DetalhePedido> ldp1 = pedido.getDetalhes();
			ldp1.addAll(ldp);
		}

		pedido.setDetalhes(ldp);
		return pedido;
	}

	public List<Pedido> agregarDetalheList(List<Pedido> listPedido) {
		List<Pedido> lp = new ArrayList();

		for (Pedido pedido : listPedido) {
			lp.add(agregarDetalhe(pedido));
		}
		return lp;
	}

}
