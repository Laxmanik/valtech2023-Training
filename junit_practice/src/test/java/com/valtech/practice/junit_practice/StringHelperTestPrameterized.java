package com.valtech.practice.junit_practice;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringHelperTestPrameterized {
	
	StringHelper helper = new StringHelper();
	
	private String input;
	private String expectedOutput;
	
	

	public StringHelperTestPrameterized(String input, String expectedOutput) {
		super();
		this.input = input;
		this.expectedOutput = expectedOutput;
	}

	@Parameters
	public static Collection<String[]> testConditions() {
		String expectedOutputs[][] = {{"AACD", "CD"},
		{"ACD","CD"} };
		return Arrays.asList(expectedOutputs);
	}
	
	@Test
	public void testParameters() {
		assertEquals(expectedOutput, helper.truncateAInFirst2Positions(input));
	}

}
