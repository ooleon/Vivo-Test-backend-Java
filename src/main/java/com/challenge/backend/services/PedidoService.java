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
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;
import com.challenge.backend.entities.*;
import com.challenge.backend.repository.PedidoProdutosRepository;
import com.challenge.backend.repository.PedidoRepository;
import com.challenge.backend.repository.PedidoUUIDRepository;
import com.challenge.backend.util.EstadoPedido;

//@Configuration
@PropertySource("classpath:/application.properties")
@Service
public class PedidoService {
	    private final Logger log = LoggerFactory.getLogger(PedidoService.class);

	@Autowired
	Environment env;

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	PedidoProdutosRepository pedidoProdutosRepository;

	public List<DetalhePedido> getPedidoProdutos() {
		
		return pedidoProdutosRepository.findAll();
	}

	public List<Pedido> getPedidos() {
		
		return pedidoRepository.findAll();
	}

	public Pedido salvar(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}


/*
	public List<UserAws> userAwsGetAsEntityList() {
		RestTemplate restTemplate = new RestTemplate();
		String resourceUrl = this.getUrl_UsersAws();
		ResponseEntity<List> response = restTemplate.getForEntity(resourceUrl, List.class);
		List<HashMap<String, String>> l1 = (List<HashMap<String, String>>) response.getBody();
		List<UserAws> listUserAws = new ArrayList<UserAws>();
		l1.forEach(u->{
			listUserAws.add(new UserAws(u.get("id"),u.get("displayName")));
		});
		return listUserAws;

	}

	public List<HashMap<String, String>> userAwsGetAsListHashMap() {
		RestTemplate restTemplate = new RestTemplate();
		String resourceUrl = this.getUrl_UsersAws();
		ResponseEntity<List> response = restTemplate.getForEntity(resourceUrl, List.class);
		List<HashMap<String, String>> u1 = (List<HashMap<String, String>>) response.getBody();
		return u1;

	}

	public ResponseEntity<List> usersAwsGetAsList() {
		RestTemplate restTemplate = new RestTemplate();
		String resourceUrl = this.getUrl_UsersAws();
		ResponseEntity<List> response = restTemplate.getForEntity(resourceUrl, List.class);
		return response;
	}

	public ResponseEntity<String> usersAwsGetAsBody() {
		RestTemplate restTemplate = new RestTemplate();
		String resourceUrl = this.getUrl_UsersAws();
		ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);
		return response;
	}

	public String getUrl_UsersAws() {
		String eUrl = env.getProperty("urlcgjresszgg_Users");
		System.out.println(eUrl);
		return eUrl;
	}

	public String userAwsFromUDDID() {
		RestTemplate restTemplate = new RestTemplate();
		String resourceUrl = this.getUrl_UsersAws();
		ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);
		return response.getBody();
	}
*/

	
	
}
