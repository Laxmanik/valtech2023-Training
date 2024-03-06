package com.valtech.poc.mutualfundportfolio.services;

import org.springframework.security.core.userdetails.UserDetails;

import com.valtech.poc.mutualfundportfolio.entities.User;

public interface UserService {

	User createUser(User user) throws Exception;

	String generatePortfolioNumber(String name);

	User updateUser(User user);

	User findUserById(int id);

	User findUserByUsername(String username);
	
	String validatingChangePassword(UserDetails userDetails,String currentPassword,String password);

}