package com.challenge.backend.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.challenge.backend.entities.Pedido;
import com.challenge.backend.entities.PedidoDTO;
import com.challenge.backend.entities.DetalhePedido;
import com.challenge.backend.entities.ProductsPojo;
import com.challenge.backend.entities.UserPojo;
import com.challenge.backend.services.ConsumerRestService;
import com.challenge.backend.services.PedidoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("orders")
public class PedidoController {

	@Autowired
	Environment env;

	@Autowired
	PedidoService pedidoService;

	@Autowired
	ConsumerRestService consumidorRestService;

	@RequestMapping(value = "/", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Pedido adicionarPedido(@RequestBody PedidoDTO pedidoDTO) {

		Pedido pedido=new Pedido();
		
		try {
			pedido = pedidoService.generarPedidoDesdeDTO(pedidoDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//TODO pedidoService de PedidoDTO a Pedido (con detalle).
		
//		Pedido p2= pedidoService.agregarDetalhe(p);
		return pedido;
	}
	
	@GetMapping("/{uuid}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Pedido> pedidoPorId(@PathVariable(name = "uuid")  String uuid) {
		UUID u = UUID.fromString(uuid);
		return this.pedidoService.findById(u);
	}
	

	@GetMapping("/pedidos")
	@ResponseStatus(HttpStatus.OK)
	public List<Pedido> pedidos() {
		return this.pedidoService.findAll();
	}
	
	@GetMapping("/produtos")
	public HashMap<Integer, Double> products() {
		return this.consumidorRestService.getProductsList();
		/*
		 * StringBuilder sb = new StringBuilder(); sb.append("cantidad " + hm.size() +
		 * " </br>"); sb.append(hm.get("1") + " </br>"); sb.append(hm.get("2") +
		 * " </br>"); sb.append(hm.get("3") + " </br>"); sb.append(hm.get("4") +
		 * " </br>"); return sb.toString();
		 */
	}

	@GetMapping("/listadeusuarios")
	public List<UserPojo> pedidoInicial() {

		return this.consumidorRestService.getUsersList();
		/*
		 * StringBuilder sb = new StringBuilder();
		 * sb.append(consumidorRestService.getUrl_Users()); sb.append(" ");
		 * sb.append(pedidoService.getPedidos());
		 * 
		 * return sb.toString();
		 */
	}

}
