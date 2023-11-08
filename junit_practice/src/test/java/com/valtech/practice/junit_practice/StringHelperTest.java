package com.valtech.practice.junit_practice;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringHelperTest {
	
	StringHelper helper = new StringHelper();

	@Test
	public void testTruncateAInFirst2Positions() {
//		StringHelper helper = new StringHelper();
		// AAACD => CD
		String actual = helper.truncateAInFirst2Positions("AACD");
		String expected = "CD";
		//asserEquals(expected value, actual value)
		assertEquals(expected, actual);
		//or
		//assertEquals("CD", truncateAInFirst2Positions("AACD"));
	}
	
	@Test
	public void testTruncateAInFirst2PositionsRefactor() {
//		StringHelper helper = new StringHelper();
		assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame () {
		//ABCD => false, ABAB = true, AB => true
		assertEquals(false, helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
		assertTrue("Condition Failed",helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
	}

}
