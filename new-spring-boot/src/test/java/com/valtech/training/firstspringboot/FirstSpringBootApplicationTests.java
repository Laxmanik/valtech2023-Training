package com.valtech.training.firstspringboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.firstspringboot.Components.HelloWorld;

@SpringBootTest
class FirstSpringBootApplicationTests {
@Autowired
	private HelloWorld helloworld;
	

	@Test
	void contextLoads() {
		assertNotNull(helloworld);
		assertEquals("Hello Spring Boot", helloworld.hello());
	}

}
