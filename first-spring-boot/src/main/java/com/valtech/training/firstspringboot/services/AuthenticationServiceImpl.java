package com.valtech.training.firstspringboot.services;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.firstspringboot.entities.User;
import com.valtech.training.firstspringboot.models.ChangePasswordModel;
import com.valtech.training.firstspringboot.models.RegisterUserModel;
import com.valtech.training.firstspringboot.repositories.UserRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AuthenticationServiceImpl implements AuthenticationService, UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostConstruct
	public void populateUsers() {
		RegisterUserModel model = new RegisterUserModel();
		model.setUsername("root");
		model.setPassword("root");
		createUser(model);
		model.setUsername("admin");
		model.setPassword("admin");
		User user = createUser(model);
//		upgradeUserToAdmin(user.getId());
	}

	@Override
	public User createUser(RegisterUserModel regUserModel) {
		User user = new User(regUserModel.getUsername(), passwordEncoder.encode(regUserModel.getPassword()),
				Arrays.asList("ROLE_USER", "ROLE_ADMIN"));
		user.setEnabled(true);
		return userRepo.save(user);
	}

	@Override
	public boolean changePassword(ChangePasswordModel passwordModel) {
		User user = userRepo.findByUsername(passwordModel.getUsername());
		if(passwordEncoder.matches(passwordModel.getOldPassword(), user.getPassword())) {
			user.setPassword(passwordEncoder.encode(passwordModel.getNewPassword()));
			userRepo.save(user);
			return true;
		}
		return false;
	}
	
	@Override
	public void upgradeUserToAdmin(long id) {
		User user = userRepo.getReferenceById(id);
		user.addRole("ROLE_ADMIN");
		userRepo.save(user);
	}
	
	@Override
	public void enableUser(long id) {
		userRepo.getReferenceById(id).setEnabled(true);
	}
	
	@Override
	public void disableUser(long id) {
		userRepo.getReferenceById(id).setEnabled(false);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepo.findByUsername(username);
	}

}
