package com.challenge.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
import org.springframework.transaction.annotation.Transactional;

import com.challenge.backend.controllers.PedidoController;
import com.challenge.backend.entities.DetalhePedido;
import com.challenge.backend.entities.Pedido;
import com.challenge.backend.repository.DetalhePedidoRepository;
import com.challenge.backend.repository.PedidoRepository;
import com.challenge.backend.services.ConsumerRestService;
import com.challenge.backend.services.DetalhePedidoService;
import com.challenge.backend.services.PedidoService;
import com.challenge.backend.util.EstadoPedido;

@SpringBootTest
class PedidoServiceSalvadoTest {
	private static final Logger log = LoggerFactory.getLogger(PedidoServiceSalvadoTest.class);

	@Autowired
	PedidoService pedidoService;

	@Autowired
	DetalhePedidoService detalhePedidoService;

	@Autowired
	DetalhePedidoRepository detalhePedidoRepository;

	@BeforeEach
	void BeforeLoads() {
	}

	@AfterEach
	void afterLoads() {
	}

	@Test
	void contextLoads() {
	}

//	@Test
	void testtest() throws Exception {
		System.out.println("Salvar: ");
		System.out.println("Numero de registros Detalhe Pedidos: " + pedidoService.findAll().size());

		Pedido pedido = pedidoService.findAll().get(0);
		System.out.println(pedido);
		System.out.println("	pedido: ");
		

		
	}

	@Test
	void salvarDetalhePedido() throws Exception {

		DetalhePedido dp = new DetalhePedido();
		dp.setPrecounidade(109.4);
		dp.setProdutoid(109);
		dp.setQuantidade(10);

		List<DetalhePedido> ldp = new ArrayList<>();
		ldp.add(dp);

		UUID u0 = UUID.fromString("00000000-5555-7777-1dcd-300020001001");
		Optional<Pedido> op = pedidoService.findById(u0);
		Pedido p = op.orElseThrow();
		if (p.getDetalles() != null) {
			List<DetalhePedido> ldp0 = new ArrayList<>();
			ldp0=p.getDetalles();
			ldp.addAll(ldp0);
		}
		p.setDetalles(ldp);
		dp.setPedido(p);

		DetalhePedido dpSaved = detalhePedidoService.save(dp);
		log.info("\n	DetalhePedido Agregar " + dp);
		log.info("\n	DetalhePedido Salvo " + dpSaved);

		log.info(" pedido : " + p.getUUID());

		List<DetalhePedido> l = detalhePedidoService.findByPedido(p);
		log.info("\n	Novo Detalhes de Pedido: " + l);
		assertTrue(l.size() > 0);
		boolean inList=false; 
		for (DetalhePedido detalhePedido : l) {
			if (detalhePedido.getId().equals(dpSaved.getId()) ) {
				inList = true;
			}
		}
		assertTrue(inList);
	}
	
	@Test
	void calcularValorParcial() throws Exception {

	List<Pedido> lp = pedidoService.findAll();
	System.out.println(" for lp ");
	for (Pedido pedido_t : lp) {
		pedido_t.setDetalles(detalhePedidoService.findByPedido(pedido_t));
//		System.out.println(pedido_t);
	}
	System.out.println(lp);
	}

//	@Test
	void salvarPedido() throws Exception {
		log.info("Numero de reguistros Pedidos: " + pedidoService.findAll().size());

		Pedido pedido = new Pedido();
		pedido.setUsuarioid(5l);
		UUID u = UUID.fromString("00000000-a324-a123-a123-111111111111");
//		pedido.setUUID(u);
		pedido.setEstado(EstadoPedido.CONCLUIDO.etiqueta);
		Pedido p = pedidoService.save(pedido);

		log.info("Numero de reguistros Pedidos: " + pedidoService.findAll().size());

		System.out.println(p.getUUID() != u);
		System.out.println(" pedido " + p.getUUID());
		assertTrue(pedidoService.findAll().size() > 0);
		System.out.println(" pedido " + p);
//		System.out.println("" + pedidoService.getPedidos());

		// Garantindo que o uuid esta sendo gerado por banco de dados.
		assertTrue(p.getUUID() != u);

	}

}
