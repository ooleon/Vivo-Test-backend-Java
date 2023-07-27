package com.challenge.backend.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.challenge.backend.entities.Pedido;
import com.challenge.backend.entities.DetalhePedido;
import com.challenge.backend.entities.ProductsPojo;
import com.challenge.backend.entities.UserPojo;
import com.challenge.backend.services.ConsumerRestService;
import com.challenge.backend.services.PedidoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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


	
	
	@GetMapping("/pedidos")
	@ResponseStatus(HttpStatus.OK)
	public List<Pedido> pedidos() {
		return this.pedidoService.findAll();
	}

	@GetMapping("/produtos")
	public HashMap<String, Double> products() {
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
