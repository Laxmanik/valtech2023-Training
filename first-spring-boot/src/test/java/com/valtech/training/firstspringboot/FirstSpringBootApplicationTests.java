package com.valtech.training.firstspringboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.firstspringboot.components.EmployeeDAO;
import com.valtech.training.firstspringboot.components.HelloWorld;
import com.valtech.training.firstspringboot.components.SimpleInterest;
import com.valtech.training.firstspringboot.entities.Order;
import com.valtech.training.firstspringboot.services.OrderService;

@SpringBootTest
class FirstSpringBootApplicationTests {
	
	@Autowired
	private HelloWorld helloWorld;
	@Autowired
	private EmployeeDAO employeeDAO;
	@Autowired
	private OrderService orderService;
	@Autowired
	private SimpleInterest simpleInterest;

	@Test
	void contextLoads() {
		assertNotNull(helloWorld);
		assertEquals("Hello Spring Boot",helloWorld.hello() );
	}
	
	@Test
	void testEmployeeDAO() {
		assertEquals(6, employeeDAO.count());
	}
	
	@Test
	void testOrders() {
		Order order = new Order("Iphone 15 Pro Max", 25, "Apple Iphone", LocalDate.of(2023,  11, 8));
		orderService.createOrder(order);
		assertEquals(5, order.getId());
		assertTrue(orderService.getAllOrders().size()>0);
	}
	
	@Test
	void testSimpleInterest() {
		simpleInterest.computeSimpleInterest(2000, 3, 3);
	}

}
