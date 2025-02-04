package com.challenge.backend.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
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
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class PedidoControllerTest {
	private static final Logger log = LoggerFactory.getLogger(PedidoControllerTest.class);

	@InjectMocks
	PedidoController pedidoController;

	@Mock
	PedidoService pedidoService;

	@Mock
	PedidoRepository pedidoRepository;

	@BeforeEach
	void contextLoads() {
	}

	@AfterEach
	void afterLoads() {
	}

	
	
	@Test
	void pedido() {
		List<Pedido> listaMock = new ArrayList<Pedido>();
		
		Pedido pMock = new Pedido();
		pMock.setUsuarioid(2l);
		pMock.setEstado(EstadoPedido.PENDIENTE.etiqueta); 
		
		
		listaMock.add(pMock);
		
		when(pedidoRepository.save(any())).thenReturn(pMock);
		when(pedidoRepository.findAll()).thenReturn(listaMock);
		when(pedidoService.findAll()).thenReturn(listaMock);
		
		log.info("Numero de reguistros Pedidos: " + pedidoController.pedidos().size());
		String json=asJsonString(pedidoController.pedidos());
		System.out.println(json);
		
		assertTrue(json.contains("PENDIENTE"));
		assertTrue(pedidoController.pedidos().size()==1);
	}

	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
