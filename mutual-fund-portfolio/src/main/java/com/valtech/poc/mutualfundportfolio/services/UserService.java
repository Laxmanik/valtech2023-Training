package com.valtech.poc.mutualfundportfolio.services;

import com.valtech.poc.mutualfundportfolio.entities.User;

public interface UserService {

	User createUser(User user) throws Exception;

	String generatePortfolioNumber(String name);

	User getCurrentUser();

}