package com.valtech.poc.practice.mutualfundsportfoliosnapshotpracticespring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.poc.practice.mutualfundsportfoliosnapshotpracticespring.entities.User;
import com.valtech.poc.practice.mutualfundsportfoliosnapshotpracticespring.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
}
