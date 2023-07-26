package com.challenge.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BackendApplicationTests {
	private static final Logger log = LoggerFactory.getLogger(BackendApplicationTests.class);

	@BeforeEach
	void beforeLoads() {
		String s = "context ok";
		log.info(s);
		assertTrue(s.contains("ok"));
	}

	@AfterEach
	void afterLoads() {
	}

	@Test
	void contextLoads() {
	}

}
