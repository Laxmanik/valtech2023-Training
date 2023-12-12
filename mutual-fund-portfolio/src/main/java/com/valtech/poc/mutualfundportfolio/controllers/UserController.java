package com.valtech.poc.mutualfundportfolio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.valtech.poc.mutualfundportfolio.entities.User;
import com.valtech.poc.mutualfundportfolio.models.UserRegisterModel;
import com.valtech.poc.mutualfundportfolio.repositories.UserRepository;
import com.valtech.poc.mutualfundportfolio.services.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping("/invest")
	public String invest() {
		return "invest";
	}

	@GetMapping("/redeem")
	public String redeem() {
		return "redeem";
	}

	@GetMapping("/dashboard")
	public String snapshot() {
		return "dashboard";
	}

	@GetMapping("/home")
	public String userPage() {
		return "homePage";
	}

	@GetMapping("/admin")
	public String adminPage() {
		return "adminPage";
	}

	@PostMapping("/register")
	public String processRegsiter(@ModelAttribute("userRegisterModel") UserRegisterModel userModel, Model model) {
		User user = userRepository.findByemail(userModel.getEmail());
		if (user == null) {
			if (userModel.getPassword().equals(userModel.getConfirmPassword())) {
				userService.createUser(new User(userModel.getName(), userModel.getAge(), userModel.getEmail(),
						passwordEncoder.encode(userModel.getPassword())));
				return "login";
			} else {
				model.addAttribute("message", "Password did not match, Please try again!");
				return "register";
			}
		} else {
			model.addAttribute("message", "User with this Email already exists");
			return "register";
		}
	}

	@GetMapping("/register")
	public String registerForm() {
		return "register";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/")
	public String landingPage() {
		return "landingPage";
	}

}
