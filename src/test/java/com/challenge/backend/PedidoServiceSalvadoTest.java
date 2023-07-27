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
	PedidoRepository pedidoRepository;
	
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
		String s = "context ok";
		log.info(s);
		assertTrue(s.contains("ok"));
	}

	
	@Test
	void salvarDetalhePedido() throws Exception  {
		log.info("Numero de reguistros Pedidos: " + pedidoService.findAll().size());

		Pedido pedido = new Pedido();
		pedido.setUsuarioid(88l);
		UUID u0 = UUID.fromString("00000000-5555-7777-1dcd-300020002201");
//		pedido.setUUID(u);
		pedido.setEstado(EstadoPedido.PENDIENTE.etiqueta);
		
		DetalhePedido dp = new DetalhePedido();
		dp.setPrecounidade(109.4);
		dp.setProdutoid(109);
		dp.setQuantidade(10);
		Pedido p = pedidoService.save(pedido);
		
		log.info("Numero de reguistros Pedidos: " + pedidoService.findAll().size());
		

		System.out.println(" p.uu id: " + p.getUUID());
//		dp.setPedido(p);

		List<DetalhePedido> ldp = new ArrayList<>();
		ldp.add(dp);
		p.setDetalles(ldp);

		
		p.setEstado(EstadoPedido.CONCLUIDO.etiqueta);
		Optional<Pedido> op = pedidoRepository.findById(u0);
		p=op.get();
		System.out.println(" pedido u0: " + p.getUUID() + " "+  p.getEstado());
		dp.setPedido(p);
		DetalhePedido dpSaved = detalhePedidoService.save(dp);

//		p = pedidoRepository.save(p);
		
		System.out.println(" dpSaved "+dpSaved);
		
		System.out.println("   u0: " + u0);

		System.out.println(" pedido u0: " + p.getEstado());
		
		List<DetalhePedido> l = detalhePedidoService.findByPedido(p);
		System.out.println("nuevo p con Detalles: " +  l );
		assertTrue(l.size() > 0);
		List<Pedido> lp = pedidoRepository.findAll();
		System.out.println(" for lp ");
		for (Pedido pedido_t: lp) {
			pedido_t.setDetalles(detalhePedidoService.findByPedido(pedido_t));
//			System.out.println(pedido_t);
		}
		System.out.println(lp);
		System.out.println(" list pedido ");
//		assertTrue(pedidoService.getPedidos().size() > 0);
		
		//Garantindo que o uuid esta sendo gerado por banco de dados.
//		assertTrue(p.uuid != u);
		
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

		//Garantindo que o uuid esta sendo gerado por banco de dados.
		assertTrue(p.getUUID() != u);

	}


}
