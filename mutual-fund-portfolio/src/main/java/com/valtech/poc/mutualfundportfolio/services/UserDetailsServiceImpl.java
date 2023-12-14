package com.valtech.poc.mutualfundportfolio.services;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.valtech.poc.mutualfundportfolio.entities.User;
import com.valtech.poc.mutualfundportfolio.entities.UserDetailsImpl;
import com.valtech.poc.mutualfundportfolio.repositories.UserRepository;

import ch.qos.logback.classic.Logger;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByportfolioNumber(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new UserDetailsImpl(user);
	}

}
