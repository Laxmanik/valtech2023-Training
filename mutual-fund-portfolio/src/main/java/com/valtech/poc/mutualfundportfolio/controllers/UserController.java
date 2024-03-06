package com.valtech.poc.mutualfundportfolio.controllers;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.valtech.poc.mutualfundportfolio.entities.User;
import com.valtech.poc.mutualfundportfolio.models.UserRegisterModel;
import com.valtech.poc.mutualfundportfolio.repositories.UserRepository;
import com.valtech.poc.mutualfundportfolio.services.UserService;

import ch.qos.logback.classic.Logger;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {

	private static final Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping("/mutualfund/invest")
	public String invest() {
		return "invest";
	}

	@GetMapping("/mutualfund/redeem")
	public String redeem() {
		return "redeem";
	}

	@GetMapping("/mutualfund/dashboard")
	public String snapshot() {
		return "dashboard";
	}

	@GetMapping("/mutualfund/home")
	public String userPage(Model model) {
		User user = userService.getCurrentUser();
		model.addAttribute("firstname", user.getFirstName());
		model.addAttribute("lastname", user.getLastName());
		return "homePage";
	}

	@PostMapping("/mutualfund/register")
	public String processRegsiter(@ModelAttribute("userRegisterModel") UserRegisterModel userModel, Model model,
			HttpServletRequest request) throws Exception {
		User user = userRepository.findByemail(userModel.getEmail());
		if (user == null) {
			if (userModel.getPassword().equals(userModel.getConfirmPassword())) {
				userService.createUser(new User(StringUtils.capitalize(userModel.getFirstName()),
						userModel.getLastName(), userModel.getAge(), userModel.getPhoneNumber(), userModel.getEmail(),
						passwordEncoder.encode(userModel.getPassword())));
				model.addAttribute("message", "User registration is successful, please check your Email for your Username ");
				return "register";
			} else {
				model.addAttribute("message", "Password did not match, Please try again!");
				return "register";
			}
		} else {
			model.addAttribute("message", "User with this Email already exists");
			return "register";
		}
	}

	@GetMapping("/mutualfund/register")
	public String registerForm() {
		return "register";
	}

	@GetMapping("/mutualfund/login")
	public String login() {
		return "login";
	}

	@GetMapping("/mutualfund")
	public String landingPage() {
		return "landingPage";
	}

}
