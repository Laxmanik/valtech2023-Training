package com.valtech.poc.practice.mutualfundsportfoliosnapshotpracticespring.controllers;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.poc.practice.mutualfundsportfoliosnapshotpracticespring.entities.User;
import com.valtech.poc.practice.mutualfundsportfoliosnapshotpracticespring.repositories.UserRepository;
import com.valtech.poc.practice.mutualfundsportfoliosnapshotpracticespring.services.UserService;

@CrossOrigin(origins = "http://10.191.81.175:3000")
@RestController
//@RequestMapping("/user")
@RequestMapping("api")
//@Controller
public class UserController {
	
	private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/register")
	public User registerUser(@Validated @RequestBody User user) {
		LOGGER.info("Received request to register user: " + user.getFirstName());
//		return userService.saveUser(user);
		return this.userRepository.save(user);
	}
	
//	@GetMapping("/list")
//	@ResponseBody
//	public List<User> getAllUsers() {
//		return userService.getAllUser().stream().collect(Collectors.toList());
//	}
	
	@GetMapping("users")
	public List<User> getUsers(){
		return this.userRepository.findAll();
	}
	
	@RequestMapping("/")
	public String helloWorld(Model model) {
		LOGGER.info("Hello World!");
		model.addAttribute("theDate", new java.util.Date());
		return "helloWorld";
	}
	
}
