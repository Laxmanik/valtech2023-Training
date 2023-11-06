package com.valtech.practice.junit_practice;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

public class ArrayExceptionTest {

	@Test
	public void testArraySort() {
		int[] unsorted = {4, 3, 1, 2};
		int[] expected = {1, 2, 3, 4};
		Arrays.sort(unsorted);
		assertEquals(expected, unsorted);
	}
	
	//Test case for Exception
	@Test(expected = NullPointerException.class)
	public void testException() {
		int[] array = null;
		Arrays.sort(array);
	}

}
