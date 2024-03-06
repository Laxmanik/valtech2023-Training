package com.valtech.poc.mutualfundportfolio.services.impl;

import java.time.LocalDate;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.poc.mutualfundportfolio.entities.User;
import com.valtech.poc.mutualfundportfolio.repositories.UserRepository;
import com.valtech.poc.mutualfundportfolio.services.EmailService;
import com.valtech.poc.mutualfundportfolio.services.UserService;

import jakarta.annotation.PostConstruct;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	private UserRepository userRepository;
	private EmailService emailService;
	private PasswordEncoder passwordEncoder;

	Random random = new Random();
	LocalDate date = LocalDate.now();

	@Autowired
	public UserServiceImpl(UserRepository userRepository, EmailService emailService, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.emailService = emailService;
		this.passwordEncoder = passwordEncoder;
	}

	@PostConstruct
	public void populateAdmin() {
		LOGGER.info("Populating Admin and User details to Datadase");
		User userAdmin = new User("ADMIN", "ADMIN", 22, 9999999999L, "admin22@gmail.com",
				passwordEncoder.encode("admin"));
		userAdmin.setPortfolioNumber("admin");
		userAdmin.setEnabled(true);
		userAdmin.setRole("ADMIN");
		userAdmin.setRegisteredDate(date);
		userRepository.save(userAdmin);
		User user = new User("User", "User", 23, 9843456789L, "user@gmail.com", passwordEncoder.encode("user"));
		user.setPortfolioNumber("user");
		user.setEnabled(true);
		user.setRole("USER");
		user.setRegisteredDate(date);

		userRepository.save(user);
	}

	@Override
	public User createUser(User newUser) throws Exception {
		User user = userRepository.findByemail(newUser.getEmail());
		if (user == null) {
			String portfolioNumber = generatePortfolioNumber(newUser.getFirstName());
			if (userRepository.existsByportfolioNumber(portfolioNumber)) {
				String newPortfolioNumber = generatePortfolioNumber(newUser.getFirstName());
				newUser.setPortfolioNumber(newPortfolioNumber);
			} else {
				newUser.setPortfolioNumber(portfolioNumber);
			}
			newUser.setEnabled(true);
			newUser.setRole("USER");
			newUser.setRegisteredDate(date);
			emailService.sendUserRegistrationMail(newUser);
			LOGGER.info("Creating A new User with UserName: {},Role: {} and Portfolio number: {}",
					newUser.getFirstName() + newUser.getLastName(), newUser.getRole(), newUser.getPortfolioNumber());

			return userRepository.save(newUser);
		}

		return null;
	}

	@Override
	public String generatePortfolioNumber(String name) {
		String initials = name.substring(0, 3);
		StringBuilder randomNumbers = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			randomNumbers.append(this.random.nextInt(10));
		}
		LOGGER.info("Generating a new Random PortFolio Number");

		return initials + randomNumbers.toString();
	}

	@Override
	public User updateUser(User user) {
		user.setModifiedDate(date);
		LOGGER.info("Updating Modified date: {} of User with UserId: {}, UserName: {}", date, user.getId(),
				user.getFirstName() + user.getLastName());

		return userRepository.save(user);
	}

	@Override
	public User findUserById(int id) {
		LOGGER.info("Finding used by Id: {}", id);

		return userRepository.getReferenceById(id);
	}

	@Override
	public User findUserByUsername(String username) {
		LOGGER.info("Finding user with name: {}", username);

		return userRepository.findByportfolioNumber(username);
	}

	@Override
	public String validatingChangePassword(@AuthenticationPrincipal UserDetails userDetails, String currentPassword,
			String password) {
		User user = findUserByUsername(userDetails.getUsername());
		if (passwordEncoder.matches(currentPassword, user.getPassword())) {
			if (currentPassword.equals(password)) {
				LOGGER.info("Current Password is same as that of Previous Password");

				return "Unique";
			} else {
				user.setPassword(passwordEncoder.encode(password));
				userRepository.save(user);
				LOGGER.info("Password Changed Successfully");

				return "Success";
			}
		} else {
			LOGGER.error("Not a valid Password");

			return "NotValidPassword";
		}
	}
}
