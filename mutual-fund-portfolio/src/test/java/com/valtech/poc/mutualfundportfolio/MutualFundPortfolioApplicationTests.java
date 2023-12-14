package com.valtech.poc.mutualfundportfolio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.valtech.poc.mutualfundportfolio.entities.User;
import com.valtech.poc.mutualfundportfolio.repositories.UserRepository;
import com.valtech.poc.mutualfundportfolio.services.UserService;

@SpringBootTest
class MutualFundPortfolioApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	public void testCreateUser() throws Exception {

		User user = new User("Anisha","sharma", 25, 987654321,"anisha@example.com", "Pas@2345");

		String encodedPassword = passwordEncoder.encode(user.getPassword());
		String password = user.getPassword();

		user.setPassword(encodedPassword);
		User createdUser = userService.createUser(user);

		assertNotNull(createdUser);
		assertEquals("Anisha", createdUser.getFirstName());
		assertNotNull(createdUser.getRegisteredDate());
		assertEquals(encodedPassword, createdUser.getPassword());
		assertTrue(password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$"));
		 assertTrue(user.getAge() > 18);
		userRepository.delete(createdUser); // deletes the user created during the test
	}

	@Test
	public void testGeneratePortfolioNumber() {

		String name = "Anisha";

		String portfolioNumber = userService.generatePortfolioNumber(name);

		assertNotNull(portfolioNumber);
		assertEquals(8, portfolioNumber.length());
		assertTrue(portfolioNumber.startsWith(name.substring(0, 3))); // Checks first three string are characters
		assertTrue(portfolioNumber.substring(3).matches("\\d{5}")); // Checks whether next five characters are digits

	}

}
