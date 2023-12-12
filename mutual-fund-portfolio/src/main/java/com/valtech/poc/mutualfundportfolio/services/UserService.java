package com.valtech.poc.mutualfundportfolio.services;

import com.valtech.poc.mutualfundportfolio.entities.User;

public interface UserService {

	User createUser(User user);
	String generatePortfolioNumber(String name);

}