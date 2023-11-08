package CoreJava.Day2.Test;


import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class NestedAirthmeticTest {

	@Nested
	class Add { //class should be mentioned with @Nested annotation to execute its test cases, if not mentioned it will consider the class as inner-class and it won't run test cases

		@Test
		void testAddForPositiveNos() {

		}

		@Test
		void testAddForNegativeNos() {

		}

		@Test
		void testAddWithZero() {

		}

	}
	
	@Nested
	class Sub {

		@Test
		void testSubForPositiveNos() {

		}

		@Test
		void testSubForNegativeNos() {

		}

		@Test
		void testSubWithZero() {

		}

	}

}

