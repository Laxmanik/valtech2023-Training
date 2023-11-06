package com.valtech.practice.junit_practice;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BeforeAfterTest {
	
	@BeforeClass
	public static void testBeforeClass() {
		System.out.println("Before Class...");
	}

	@Before
	public void testBefore() {
		System.out.println("Before this test...");
	}
	
	
	
	@Test
	public void test1() {
		System.out.println("test 1 executed...");
	}
	
	@Test
	public void test2() {
		System.out.println("test 2 executed...");
	}


	@After
	public void testAfter() {
		System.out.println("After this test...");
	}
	
	@AfterClass
	public static void testAfterClass() {
		System.out.println("After Class...");
	}
}
