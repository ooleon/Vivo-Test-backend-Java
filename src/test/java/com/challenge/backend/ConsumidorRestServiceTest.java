package com.challenge.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.challenge.backend.services.ConsumerRestService;
import com.challenge.backend.services.PedidoService;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Dynamic;

@SpringBootTest
class ConsumidorRestServiceTest {
	private static final Logger log = LoggerFactory.getLogger(ConsumidorRestServiceTest.class);

	@Autowired
	PedidoService pedidoService;

	@Autowired
	ConsumerRestService consumidorRestService;

	@BeforeEach
	void contextLoads() {
	}

	@AfterEach
	void afterLoads() {
	}
		
		
	@Test
	void usuariosConsumidor() {
	assertTrue(consumidorRestService.getUsersList().size()>0); 	
	log.info("Numero de usuarios carregados da fonte: " + consumidorRestService.getUsersList().size());
	}
	
	@Test
	void productosConsumidor() {
		assertTrue(consumidorRestService.getProductsList().size()>0);
		log.info("Numero de usuarios carregados da fonte: " + consumidorRestService.getProductsList().size());		
	}

}
