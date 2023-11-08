package com.valtech.training.firstspringboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.firstspringboot.Components.EmployeeDAO;
import com.valtech.training.firstspringboot.Components.HelloWorld;

@SpringBootTest
class FirstSpringBootApplicationTests {
	
	@Autowired
	private HelloWorld helloworld;
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Test
	void testEmployeeDAO() {
		assertEquals(6, employeeDAO.count());
		assertEquals(6, employeeDAO.getAllEmployees().size());
	}

	@Test
	void contextLoads() {
		assertNotNull(helloworld);
		assertEquals("Hello Spring Boot", helloworld.hello());
		System.out.println(helloworld.hello());
	}

}
