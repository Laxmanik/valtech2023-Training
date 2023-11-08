package com.valtech.training.spring.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.valtech.training.spring.Airthmetic;

class AOPTest {

	private ClassPathXmlApplicationContext appCtx;
	
	@BeforeEach
	void initialize() {
		appCtx = new ClassPathXmlApplicationContext("aop.xml");
	}
	
	@AfterEach
	void closeall() {
		appCtx.close();
	}
	
	@Test
	void test() {
		Airthmetic airth = (Airthmetic) appCtx.getBean(Airthmetic.class);
	System.out.println(airth.getClass().getName());	
//	System.out.println(airth);
	assertEquals(5,  airth.add(2,3));
	assertEquals(6, airth.sub(8, 2));
	assertEquals(6,  airth.add(3,3));
	assertEquals(4, airth.mul(2, 2));
	assertEquals(2, airth.div(4, 2));
	try {
		airth.div(5, 0);
		fail("No Exception Occured...");
	} catch (Exception e) {
	}
	}

}
