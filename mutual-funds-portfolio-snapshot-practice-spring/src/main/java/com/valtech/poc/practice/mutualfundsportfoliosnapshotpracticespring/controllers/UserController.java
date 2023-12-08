package com.valtech.poc.practice.mutualfundsportfoliosnapshotpracticespring.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.poc.practice.mutualfundsportfoliosnapshotpracticespring.UserService;
import com.valtech.poc.practice.mutualfundsportfoliosnapshotpracticespring.entities.User;

//@CrossOrigin(origins = "http://localhost:3000")
//@RestController
//@RequestMapping("/user")
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public User registerUser(@Validated @RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@GetMapping("/list")
	@ResponseBody
	public List<User> getAllUsers() {
		return userService.getAllUser().stream().collect(Collectors.toList());
	}
	
	@RequestMapping("/")
	public String helloWorld(Model model) {
		model.addAttribute("theDate", new java.util.Date());
		return "helloWorld";
	}
	
}
