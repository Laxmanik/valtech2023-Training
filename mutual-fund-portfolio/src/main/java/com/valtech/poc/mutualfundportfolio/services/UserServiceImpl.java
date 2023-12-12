package com.valtech.poc.mutualfundportfolio.services;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.valtech.poc.mutualfundportfolio.entities.User;
import com.valtech.poc.mutualfundportfolio.repositories.UserRepository;

import jakarta.annotation.PostConstruct;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	EmailService emailService;

	@Autowired
	PasswordEncoder passwordEncoder;

	LocalDate date = LocalDate.now();

	@PostConstruct
	public void populateAdmin() {
		User userAdmin = new User("ADMIN", 22, "admin22@gmail.com", passwordEncoder.encode("admin"));
		userAdmin.setPortfolioNumber("admin");
		userAdmin.setEnabled(true);
		userAdmin.setRole("ADMIN");
		userAdmin.setRegisteredDate(date);

		userRepository.save(userAdmin);
	}

	@Override
	public User createUser(User user) {
		String toMail = user.getEmail();
		String portfolioNumber = generatePortfolioNumber(user.getName());
		String subject = "Mutualfund-portfolio UserId";
		String body = "Hi " + user.getName() + ",\nYou have successfully created an account in MutualFund Portfolio"
				+ "\nYour mutualfund portfolio ID is:" + portfolioNumber + "."
				+ "\nPlease use this as your username while logging into our Mutualfund" + " Portfolio website"
				+ "\nPlease do not share your credentials." + "\n\n\nBest Regards," + "\nTeam MFP";
		emailService.sendSimpleMessage(toMail, subject, body);

		user.setPortfolioNumber(portfolioNumber);
		user.setEnabled(true);
		user.setRole("USER");
		user.setRegisteredDate(date);

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
