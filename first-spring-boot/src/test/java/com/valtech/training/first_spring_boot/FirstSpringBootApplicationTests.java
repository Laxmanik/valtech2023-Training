package com.valtech.training.first_spring_boot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.first_spring_boot.components.HelloWorld;

@SpringBootTest
class FirstSpringBootApplicationTests {

	@Autowired
	private HelloWorld helloWorld;
	
	@Test
	void contextLoads() {
		assertNotNull(helloWorld);
		assertEquals("Hello Spring Boot", helloWorld.hello());
	}

}
