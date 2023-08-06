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

	public Pedido agregarDetalhe(Pedido pedido) {
		List<DetalhePedido> ldp = new ArrayList<>();
//		ldp = detalhePedidoService.findByPedido(pedido);		
//		ldp=detalhePedidoService.recalcularDetalhePedido(ldp);

		ldp = this.findByPedido(pedido);
		ldp = this.recalcularDetalhePedido(ldp);

		// TODO recalcular produto repetido
		if (pedido.getDetalhes() != null) {
			List<DetalhePedido> ldp1 = pedido.getDetalhes();
			ldp1.addAll(ldp);
		}

		pedido.setDetalhes(ldp);
		return pedido;
	}

	public List<DetalhePedido> agregarDetalhe_1(Pedido pedido) {
		List<DetalhePedido> ldp = new ArrayList<>();
//		ldp = detalhePedidoService.findByPedido(pedido);		
//		ldp=detalhePedidoService.recalcularDetalhePedido(ldp);

		ldp = this.findByPedido(pedido);
		ldp = this.recalcularDetalhePedido(ldp);

		// TODO recalcular produto repetido
		if (pedido.getDetalhes() != null) {
			List<DetalhePedido> ldp1 = pedido.getDetalhes();
			ldp1.addAll(ldp);
		}

//		pedido.setDetalhes(ldp);
		return ldp;
	}

	public List<DetalhePedido> recalcularDetalhePedido(List<DetalhePedido> listDetalhePedido) {
		// TODO Auto-generated method stub
		/*
		 * 1. validar lista no null 2.
		 * 
		 */
		return listDetalhePedido;
	}

	public Pedido agregarDetalhe(Pedido pedido, PedidoDTO pedidoDTO, HashMap<Integer, Double> hashMapIdPreco) {
		// pedido esta salvado.
		// buscar lista de produtos por pedidoDTO

		HashMap<Integer, Integer> hmIdCantidad;
		if (pedidoDTO.getProdutos() != null) {
			hmIdCantidad = contarCantidadProdutos(pedidoDTO);
			System.out.println("\nhmIdCantidad " + hmIdCantidad + "\n");
			// generar DetallesPedido por productos bucle por pedidoDTO
			List<DetalhePedido> ldp  = 
			 generarDetalhePedido(pedido, hmIdCantidad, hashMapIdPreco);
			
			// agregar DetallesPedido al pedido
			pedido.setDetalhes(ldp);
		}
		return pedido;
	}
	private List<DetalhePedido> generarDetalhePedido(Pedido pedido, HashMap<Integer, Integer> hmIdCantidad,
			HashMap<Integer, Double> hashMapIdPreco) {
		// generar DetallesPedido por productos bucle por pedidoDTO
		
		List<DetalhePedido> listDetalhePedido = new ArrayList<DetalhePedido>(); 
		hmIdCantidad.forEach((key, cantidad) ->
		{
			DetalhePedido detalhesPedido = new DetalhePedido();
			detalhesPedido.setPedido(pedido);
			detalhesPedido.setProdutoid(key);
			detalhesPedido.setQuantidade(cantidad);
			detalhesPedido.setPrecounidade(hashMapIdPreco.get(key));
			detalhePedidoRepository.save(detalhesPedido);
			listDetalhePedido.add(detalhesPedido );
		}
		 );
		
		
		return listDetalhePedido;
	}

	private HashMap<Integer, Integer> contarCantidadProdutos(PedidoDTO pedidoDTO) {
		// contar produtos na lista
		List<ProductsPojo> listProdutoId = pedidoDTO.getProdutos();
		HashMap<Integer, Integer> hmIdCantidad = new HashMap<Integer, Integer>();
		Integer i = 1;

		for (ProductsPojo o : listProdutoId) {
			Integer key = ((ProductsPojo) o).getId();
			if (hmIdCantidad.get(key) == null) {
				i = 1;

			} else {
				i = hmIdCantidad.get(key);
				i++;

			}
			hmIdCantidad.put(key, i);
		}

		return hmIdCantidad;

	}

}
