package com.valtech.training.firstspringboot.controllers;

import java.util.Objects;

import javax.annotation.PostConstruct;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valtech.training.firstspringboot.models.ChangePasswordModel;
import com.valtech.training.firstspringboot.models.RegisterUserModel;
import com.valtech.training.firstspringboot.services.AuthenticationService;

import ch.qos.logback.classic.Logger;

@Controller
public class AuthenticationController {
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(AuthenticationController.class);

	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping("/changePassword")
	public String handleChangePassword(@AuthenticationPrincipal UserDetails userDetails,
			@ModelAttribute ChangePasswordModel passwordModel, Model model) {
		passwordModel.setUsername(userDetails.getUsername());
		if (Objects.equals(passwordModel.getNewPassword(), passwordModel.getConfirmPassword())) {
			if (authenticationService.changePassword(passwordModel)) {
				model.addAttribute("message", "Password Changed Successfully");
			} else {
				model.addAttribute("message", "Old Password doesn,t match!");
				return "changePassword";
			}
		} else {
			model.addAttribute("message", "New Password and Confirm Password doesn't match..!");
			return "changePassword";
		}
		logger.debug("Password changed Successfully");
		return "redirect:logout";
	}

	@GetMapping("/changePassword")
	public String changePasswordForm() {
		logger.debug("requested to change password");
		return "changePassword";
	}

	@PostMapping("/register")
	public String handleRegistration(@ModelAttribute RegisterUserModel regUserModel, Model model) {
		if (Objects.equals(regUserModel.getPassword(), regUserModel.getConfirmPassword())) {
			authenticationService.createUser(regUserModel);
			model.addAttribute("message", "User Registration Successful.. Pls Login to Proceed!");
		} else {
			model.addAttribute("message", "Password and Confirm Password doesn't mact..!");
			return "register";
		}
		return "login";
	}

	@GetMapping("/register")
	public String registerForm() {
		return "register";
	}

	@GetMapping("/login")
	public String login() {
		logger.debug("reguest to login page");
		return "login";
	}

	@GetMapping("/anon")
	@ResponseBody
	public String anonPage() {
		return "Anonymous Page";
	}

	@GetMapping("/user")
	@ResponseBody
	public String userPage() {
		return "User Page";
	}

	@GetMapping("/admin")
	@ResponseBody
	public String adminPage() {
		return "Admin Page";
	}

}
