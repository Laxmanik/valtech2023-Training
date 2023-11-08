package com.valtech.training.firstspringboot.Components;

import org.springframework.stereotype.Component;

@Component
public class HelloWorld {
	
	public String hello(){
		return "Hello Spring Boot";
	}

}
