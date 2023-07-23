package com.challenge.backend.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class backendController {

	@Autowired
	Environment env;

	@GetMapping("/")
	public String PricelineInicial() {
		StringBuilder sb = new StringBuilder(
				"la religion es para los que tienen miedo de ir al infierno, <br> la espiritualidad es para quienes ya estuvieron allí <br>");
		sb.append(getUrl_Users());
		sb.append(userGetAsListHashMap());

		return sb.toString();
	}

	public String getUrl_Users() {
		String eUrl = env.getProperty("users");
		System.out.println(eUrl);
		return eUrl;
	}

	public String getUrl_Products() {
		String eUrl = env.getProperty("products");
		System.out.println(eUrl);
		return eUrl;
	}


	public List<HashMap<String, String>> userGetAsListHashMap() {
		RestTemplate restTemplate = new RestTemplate();
		String resourceUrl = this.getUrl_Users();
		ResponseEntity<List> response = restTemplate.getForEntity(resourceUrl, List.class);
		List<HashMap<String, String>> u1 = (List<HashMap<String, String>>) response.getBody();
		return u1;

	}

}
