package CoreJava.Day2.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*; //importing static methods from assertions

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import CoreJava.Day2.Arithmetic;
import CoreJava.Day2.ArithmeticImpl;
import CoreJava.Day2.DivideByZeroException;

class ArithmeticTest {

	private Arithmetic arithmetic; // = new AirthmeticImpl();

	@BeforeAll // Initializes only once
	static void beforeAll() { // it should have only the static method
		System.out.println("Before All...");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("After All...");
	}

	@BeforeEach
	void anything() {
		System.out.println("Init...");
		arithmetic = new ArithmeticImpl();
	}

	@AfterEach
	void anything1() {
		System.out.println("Destroy...");
	}

	@Test
	@DisplayName("To Check if the +ve Nos, -ve Nos are added Correctly...")
	void testAdd() {
		assertEquals(5, arithmetic.add(2, 3));
		assertEquals(5, arithmetic.add(3, 2));
		assertEquals(5, arithmetic.add(5, 0));
		assertEquals(5, arithmetic.add(5, -0));
		assertEquals(-5, arithmetic.add(-2, -3));
		assertEquals(-5, arithmetic.add(-8, 3));
	}

	@Test
	void testSub() {
	}

	@Test
	void testMul() {
	}
	
	static Stream<Arguments> addArgsGenerator() {
		return Stream.of(
				Arguments.of(1,2,3),
				Arguments.of(-1,-2,-3),
				Arguments.of(1,-2,-1),
				Arguments.of(-1,2,1)
				);
	}
	
	@ParameterizedTest(name = "Add with Me {0} + {1} = {2}")
	@MethodSource(value = {"addArgsGenerator"})  //mentioned method should be static and parameter less
	void testWithMethod(int a, int b, int c) {
		assertEquals(c, arithmetic.add(a, b));
	}
	
	@ParameterizedTest(name = "Add with CSV {0} + {1} = {2}")
	@CsvFileSource(files = {"add.csv"})
	void addWitnCSVFile(int a, int b, int c) {
		assertEquals(c, arithmetic.add(a, b));
	}
	
	@ParameterizedTest(name = "Add with CSV {0} + {1} = {2}")
	@CsvSource(value = {"2,3,5","-2,3,1","5,-2,3","-1,-1,-2"})
	void addWitnCSVParams(int a, int b, int c) {
		assertEquals(c, arithmetic.add(a, b));
	}
	
	@ParameterizedTest(name = "Add with {0}")       //allows to pass arguments
	@ValueSource(strings = {"2,3,5","-2,3,1","5,-2,3","-1,-1,-2"})
	void testAddWithPrams(String value) {
		String [] parts = value.split(",");
		List<Integer> values = Arrays.asList(parts).stream().map(it -> Integer.parseInt(it)).collect(Collectors.toList());
		assertEquals(values.get(2),arithmetic.add(values.get(0),values.get(1)));
	}

	@Test
	void testDivByZero() {
		assertThrows(DivideByZeroException.class, () -> arithmetic.div(5, 0));
	}

	@Test
	void testDiv() {
		assertEquals(1.666, 5.0/3,0.001,"Value not in range");        //mention range for double (float) value as 3rd argument -> allows to provide range for the expected value, even custom message can be passed as fourth argument
		assertEquals(2, arithmetic.div(4, 2));
		assertEquals(2, arithmetic.div(-6, -3));
		try {
			assertEquals(2, arithmetic.div(4, 0));
			fail("Should have thrown DivideByZeroException");
		} catch (DivideByZeroException ex) {

		}
	}

}
