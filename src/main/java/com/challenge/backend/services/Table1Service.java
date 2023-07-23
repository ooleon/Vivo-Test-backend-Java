package com.challenge.backend.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.challenge.backend.entities.*;

//@Configuration
@PropertySource("classpath:/application.properties")
@Service
public class Table1Service {
	    private final Logger log = LoggerFactory.getLogger(Table1Service.class);

	@Autowired
	Environment env;
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
