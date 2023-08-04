package com.challenge.backend.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.swing.text.html.Option;

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
import com.challenge.backend.entities.PedidoDTO;
import com.challenge.backend.entities.ProductsPojo;
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
	DetalhePedidoService detalhePedidoService;

	@Mock
	ConsumerRestService consumidorRestService;

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

	class MyMockPedido extends Pedido{
		UUID UUID;

		public MyMockPedido() {
			
		this.UUID=UUID.fromString("00000000-5555-7777-1dcd-300020001001");
		}
	}
	
	@Test
	void procesarPedidodeDTO() {
//		PedidoDTO pedidoDTOMock = new PedidoDTO(11l,  new ProductsPojo(1, 10.0),new ProductsPojo(2, 20.0) );
		PedidoDTO pedidoDTOMock = new PedidoDTO(11l,  (List) new ProductsPojo(1, 10.0) );
		Pedido pedidoMock = new Pedido();
		pedidoMock = new MyMockPedido(); pedidoMock.setUsuarioid(5l);
		DetalhePedido dp1 = new DetalhePedido();	dp1.setProdutoid(1);	dp1.setPrecounidade(10l);	dp1.setQuantidade(10); 
		DetalhePedido dp2 = new DetalhePedido();	dp2.setProdutoid(2);	dp2.setPrecounidade(20l);	dp2.setQuantidade(20); 		
		DetalhePedido dp3 = new DetalhePedido();	dp3.setProdutoid(2);	dp3.setPrecounidade(20l);	dp3.setQuantidade(20); 		
		
		List<DetalhePedido> listaDetalhePedidoMock = Arrays.asList(dp1,dp2);
		
		pedidoMock.setDetalhes(listaDetalhePedidoMock);
		Optional<Pedido> oPedidoMock= Optional.of(pedidoMock);
		
		when(pedidoRepository.save(any())).thenReturn(pedidoMock);
		when(pedidoRepository.findById(any())).thenReturn(oPedidoMock);
		when(detalhePedidoService.findByPedido(any())).thenReturn(listaDetalhePedidoMock);
		when(detalhePedidoService.recalcularDetalhePedido(any())).thenReturn(listaDetalhePedidoMock);
		when(detalhePedidoService.agregarDetalhe(any())).thenReturn(pedidoMock);

		pedidoMock.setDetalhes(listaDetalhePedidoMock);

		
		Pedido pedido = pedidoService.generarPedidoDesdeDTO(pedidoDTOMock);
		System.out.println(pedido);
		
		Double dPrecoTotal = pedido.getPrecoTotal();
		System.out.println(dPrecoTotal);

	}

//	@Test
	void listarPedido() {
		List<Pedido> listaMock = new ArrayList<Pedido>();
		Pedido pMock = new Pedido();
		pMock.setUsuarioid(5l);

		pMock.setEstado(EstadoPedido.PENDIENTE.etiqueta);
		;

		listaMock.add(pMock);

		when(pedidoRepository.save(any())).thenReturn(pMock);
		when(pedidoRepository.findAll()).thenReturn(listaMock);
		log.info("Numero de reguistros Pedidos: " + pedidoService.findAll().size());
		assertTrue(pedidoService.findAll().size() > 0);
	}

}
