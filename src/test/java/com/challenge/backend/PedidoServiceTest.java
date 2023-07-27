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
import com.challenge.backend.entities.Pedido;
import com.challenge.backend.repository.PedidoRepository;
import com.challenge.backend.services.ConsumerRestService;
import com.challenge.backend.services.PedidoService;
import com.challenge.backend.util.EstadoPedido;

@SpringBootTest
class PedidoServiceTest {
	private static final Logger log = LoggerFactory.getLogger(PedidoServiceTest.class);

	@InjectMocks
	PedidoService pedidoService;

	@Mock
	PedidoRepository pedidoRepository;
	
	@Mock
	Pedido pedidoMock;

	@BeforeEach
	void contextLoads() {
		String s = "context ok";
		log.info(s);
		System.out.println(s);
		assertTrue(s.contains("ok"));
	}

	@AfterEach
	void afterLoads() {
	}


		@Test
	void listarPedido() { 
		List<Pedido> listaMock = new ArrayList<Pedido>();
		Pedido pMock = new Pedido();
		pMock.setUsuarioid(5l);

		pMock.setEstado(EstadoPedido.PENDIENTE.etiqueta); ;
		
		listaMock.add(pMock);
		
		when(pedidoRepository.save(any())).thenReturn(pMock);
		when(pedidoRepository.findAll()).thenReturn(listaMock);
		log.info("Numero de reguistros Pedidos: " + pedidoService.findAll().size());
		assertTrue(pedidoService.findAll().size()>0);
	}

	
}
