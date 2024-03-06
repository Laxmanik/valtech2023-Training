package com.valtech.poc.mutualfundportfolio.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.valtech.poc.mutualfundportfolio.entities.User;
import com.valtech.poc.mutualfundportfolio.services.UserService;

@SpringBootTest
class UserServiceImplTest {

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	LocalDate date = LocalDate.now();

	@Test
	void testCreateUser() throws Exception {
		User user = new User("Anisha", "sharma", 25, 9876543201L, "anisha1@example.com", "Pas@2345");
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
	}

	@Test
	void testGeneratePortfolioNumber() {
		String name = "Anisha";

		String portfolioNumber = userService.generatePortfolioNumber(name);

		assertNotNull(portfolioNumber);
		assertEquals(8, portfolioNumber.length());
		assertTrue(portfolioNumber.startsWith(name.substring(0, 3)));
		assertTrue(portfolioNumber.substring(3).matches("\\d{5}"));
	}

	@Test
	void testUpdateUserProfile() throws Exception {
		User user = new User("Anisha", "sharma", 25, 9876054321L, "anisha2@example.com",
				passwordEncoder.encode("Pas@2345"));
		User createdUser = userService.createUser(user);

		createdUser.setFirstName("kartik");
		createdUser.setLastName("dandooti");
		createdUser.setAge(23);
		createdUser.setPhoneNumber(8950123665L);
		User updatedUser = userService.updateUser(createdUser);

		assertEquals("kartik", updatedUser.getFirstName());
		assertEquals("dandooti", updatedUser.getLastName());
		assertEquals(23, updatedUser.getAge());
		assertEquals(8950123665L, updatedUser.getPhoneNumber());
		assertEquals(updatedUser.getPortfolioNumber(), updatedUser.getPortfolioNumber());
		assertEquals(date, updatedUser.getModifiedDate());
	}

	@Test
	void testChangePassword() throws Exception {
		User user = new User("Anisha", "sharma", 25, 9876054321L, "anisha3@example.com",
				passwordEncoder.encode("Ksdan@143"));
		userService.createUser(user);
		String newPassword = "Ksdan@1434";

		boolean Unique = passwordEncoder.matches(newPassword, user.getPassword());
		boolean validOldPassword = passwordEncoder.matches("Ksdan@143", user.getPassword());
		boolean notValidOldPassword = passwordEncoder.matches("Ksdan@14356", user.getPassword());

		assertEquals(false, Unique);
		assertEquals(true, validOldPassword);
		assertEquals(false, notValidOldPassword);
	}

	@Test
	void testFindUserById() throws Exception {
		User user = new User("Anisha", "sharma", 25, 9876054321L, "anisha34@example.com",
				passwordEncoder.encode("Ksdan@143"));
		User expectedUser = userService.createUser(user);

		int expectedId = expectedUser.getId();
		User actualUser = userService.findUserById(expectedId);
		int actualId = actualUser.getId();

		assertEquals(expectedId, actualId);
	}

	@Test
	void testFindUserByUsername() throws Exception {
		User user = new User("Anisha", "sharma", 25, 9876054321L, "anisha10@example.com",
				passwordEncoder.encode("Ksdan@143"));
		User expectedUser = userService.createUser(user);

		String exceptedUserName = expectedUser.getPortfolioNumber();
		User actualUser = userService.findUserByUsername(exceptedUserName);
		String actualUserName = actualUser.getPortfolioNumber();

		assertEquals(exceptedUserName, actualUserName);
	}
}