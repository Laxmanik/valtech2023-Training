package com.valtech.poc.mutualfundportfolio.services;

import java.time.LocalDate;
import java.util.Random;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.valtech.poc.mutualfundportfolio.entities.User;
import com.valtech.poc.mutualfundportfolio.repositories.UserRepository;

import ch.qos.logback.classic.Logger;
import jakarta.annotation.PostConstruct;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepository userRepository;

	@Autowired
	EmailService emailService;

	@Autowired
	PasswordEncoder passwordEncoder;

	LocalDate date = LocalDate.now();

	@PostConstruct
	public void populateAdmin() {
		User userAdmin = new User("ADMIN", "ADMIN", 22, 0000000000, "admin22@gmail.com", passwordEncoder.encode("admin"));
		userAdmin.setPortfolioNumber("admin");
		userAdmin.setEnabled(true);
		userAdmin.setRole("ADMIN");
		userAdmin.setRegisteredDate(date);

		userRepository.save(userAdmin);
	}

	@Override
	public User createUser(User user) throws Exception {
		String portfolioNumber = generatePortfolioNumber(user.getFirstName());
		user.setPortfolioNumber(portfolioNumber);
		user.setEnabled(true);
		user.setRole("USER");
		user.setRegisteredDate(date);
		emailService.sendSimpleMessage(user);
		return userRepository.save(user);

	}

	@Override
	public String generatePortfolioNumber(String name) {
		String initials = name.substring(0, 3);
		StringBuilder randomNumbers = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			randomNumbers.append(random.nextInt(10));
		}
		return initials + randomNumbers.toString();

	}
}
