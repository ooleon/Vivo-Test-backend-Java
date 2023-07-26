package com.challenge.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.challenge.backend.controllers.PedidoController;
import com.challenge.backend.entities.DetalhePedido;
import com.challenge.backend.entities.Pedido;
import com.challenge.backend.repository.PedidoRepository;
import com.challenge.backend.services.ConsumerRestService;
import com.challenge.backend.services.PedidoService;
import com.challenge.backend.util.EstadoPedido;

@SpringBootTest
class PedidoServiceSalvadoTest {
	private static final Logger log = LoggerFactory.getLogger(PedidoServiceSalvadoTest.class);

	@Autowired
	PedidoService pedidoService;

	@Autowired
	PedidoRepository pedidoRepository;

	@BeforeEach
	void contextLoads() {
		String s = "context ok";
		log.info(s);
		assertTrue(s.contains("ok"));
	}

	@AfterEach
	void afterLoads() {
	}

//	@Test
	void salvarDetalhePedido() {
		log.info("Numero de reguistros Pedidos: " + pedidoService.getPedidos().size());

		Pedido pedido = new Pedido();
		pedido.usuarioid = BigInteger.valueOf(5);
		UUID u = UUID.fromString("00000000-a324-a123-a123-111111111111");
		pedido.uuid = u;
		pedido.estado = EstadoPedido.CONCLUIDO.etiqueta;
//		DetalhePedido dp = new DetalhePedido();
//		dp.setPrecounidade(109.4);
//		dp.setProdutoid(2);
		
		Pedido p = pedidoService.salvar(pedido);
		
		log.info("Numero de reguistros Pedidos: " + pedidoService.getPedidos().size());

		System.out.println(p.uuid != u);
		System.out.println(" pedido ");
		System.out.println(pedidoService.getPedidos());
		System.out.println(" pedido ");

		assertTrue(pedidoService.getPedidos().size() > 0);
		//Garantindo que o uuid esta sendo gerado por banco de dados.
		assertTrue(p.uuid != u);
		
	}

	@Test
	void salvarPedido() throws Exception {
		log.info("Numero de reguistros Pedidos: " + pedidoService.getPedidos().size());

		Pedido pedido = new Pedido();
		pedido.usuarioid = BigInteger.valueOf(5);
		UUID u = UUID.fromString("00000000-a324-a123-a123-111111111111");
		pedido.uuid = u;
		pedido.estado = EstadoPedido.CONCLUIDO.etiqueta;
		Pedido p = pedidoService.salvar(pedido);
		
		log.info("Numero de reguistros Pedidos: " + pedidoService.getPedidos().size());

		System.out.println(p.uuid != u);
		System.out.println(" pedido ");
		System.out.println(pedidoService.getPedidos());
		System.out.println(" pedido ");

		assertTrue(pedidoService.getPedidos().size() > 0);
		//Garantindo que o uuid esta sendo gerado por banco de dados.
		assertTrue(p.uuid != u);

	}


}
