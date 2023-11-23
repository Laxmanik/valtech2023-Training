package com.valtech.udemy.course.practice.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.valtech.udemy.course.practice.HelloWorld;

class HelloWorldTest {

	private HelloWorld helloWorld = new HelloWorld();

	@Test
	void test() {
		System.out.println(helloWorld.hello());
		assertEquals("Hello World", helloWorld.hello());
	}

}
