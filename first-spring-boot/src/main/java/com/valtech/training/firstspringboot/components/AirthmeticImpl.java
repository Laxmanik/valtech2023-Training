package com.valtech.training.firstspringboot.components;

import org.springframework.stereotype.Component;

@Component
public class AirthmeticImpl implements Airthmetic {

	@Override
	public int add(int a, int b) {
		return a+b;
	}

	@Override
	public int sub(int a, int b) {
		return a-b;
	}

	@Override
	public int mul(int a, int b) {
		return a*b;
	}

	@Override
	public int div(int a, int b){
		return a/b;
	}

	public static void main(String[] args) /*throws DivideByZeroException*/ {
		Airthmetic a = new AirthmeticImpl();
		System.out.println(a.add(2, 3));
		System.out.println(a.mul(2, 3));
		System.out.println(a.sub(3, 2));
		try {
			System.out.println(a.div(2, 0));
		}
		catch(Exception e) {
			System.out.println("Willl this be seen");
		}
		//If the exception is handled the code after catch block will execute
//		System.out.println(a.mul(2, 4)); //this is executed
		finally {
			System.out.println(a.mul(4, 4));
		}
	}
	
}
