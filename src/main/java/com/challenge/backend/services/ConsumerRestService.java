package com.challenge.backend.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.client.RestTemplateBuilderConfigurer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.challenge.backend.entities.*;
import com.challenge.backend.repository.PedidoUUIDRepository;

@PropertySource("classpath:/application.properties")
@Service
public class ConsumerRestService {
	private final Logger log = LoggerFactory.getLogger(ConsumerRestService.class);

	@Autowired
	Environment env;

	

	public List<UserPojo> getUsersList() {

		return this.userAwsGetAsEntityList();
	}

	public HashMap<Integer, Double> getProductsList() {
		HashMap<Integer, Double> hm = new HashMap<Integer, Double>();
		
		for (ProductsPojo p : this.productsAwsGetAsEntityList()) {
			hm.put(p.getId(), p.getPreco());
		}
		return hm;
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

//	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

//	@Bean
	public ProductsPojo getProductsRest(RestTemplate restTemplate) throws Exception {
		ProductsPojo p;
		ProductsPojo productsTemp = restTemplate.getForObject(getUrl_Users(), ProductsPojo.class);
		System.out.println("productsTemp.id " + productsTemp.getId());
		log.info(productsTemp.toString());
		return productsTemp;

	}

	public List<ProductsPojo> productsAwsGetAsEntityList() {
		RestTemplate restTemplate = new RestTemplate();
		String resourceUrl = this.getUrl_Products();
		ResponseEntity<List> response = restTemplate.getForEntity(resourceUrl, List.class);
		List<HashMap<String, Object>> l1 = (List<HashMap<String, Object>>) response.getBody();
		List<ProductsPojo> listAws = new ArrayList<ProductsPojo>();
		l1.forEach(u -> {

			double price = Double.parseDouble(u.get("price") == null ? "0" : u.get("price").toString());

			listAws.add(new ProductsPojo(Integer.valueOf(u.get("id").toString()) , price));

		});
		return listAws;

	}

	public List<UserPojo> userAwsGetAsEntityList() {
		RestTemplate restTemplate = new RestTemplate();
		String resourceUrl = this.getUrl_UsersAws();
		ResponseEntity<List> response = restTemplate.getForEntity(resourceUrl, List.class);
		List<HashMap<String, Object>> l1 = (List<HashMap<String, Object>>) response.getBody();
		List<UserPojo> listUserAws = new ArrayList<UserPojo>();
		l1.forEach(u -> {

			listUserAws.add(new UserPojo(u.get("id").toString(), u.get("username").toString()));

		});
		return listUserAws;
	}

	// / *

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
		String eUrl = env.getProperty("users");
		System.out.println(eUrl);
		return eUrl;
	}

	public String userAwsFromUDDID() {
		RestTemplate restTemplate = new RestTemplate();
		String resourceUrl = this.getUrl_UsersAws();
		ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);
		return response.getBody();
	}
//* /

}
