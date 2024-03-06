package com.valtech.poc.mutualfundportfolio.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.valtech.poc.mutualfundportfolio.entities.MutualFundScheme;
import com.valtech.poc.mutualfundportfolio.entities.Transaction;
import com.valtech.poc.mutualfundportfolio.entities.User;
import com.valtech.poc.mutualfundportfolio.entities.UserScheme;
import com.valtech.poc.mutualfundportfolio.models.UserRegisterModel;
import com.valtech.poc.mutualfundportfolio.services.MutualFundService;
import com.valtech.poc.mutualfundportfolio.services.TransactionService;
import com.valtech.poc.mutualfundportfolio.services.UserSchemeService;
import com.valtech.poc.mutualfundportfolio.services.UserService;

@Controller
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	private static final String CHANGE_PASSWORD_VIEW = "changePassword";
	private static final String USER_PROFILE_VIEW = "userProfileView";
	private static final String USER_PROFILE_EDIT_VIEW = "userProfileEdit";
	private static final String HOME_PAGE_VIEW = "homePage";
	private static final String REGISTER_VIEW = "register";
	private static final String LOGIN_VIEW = "login";
	private static final String LANDING_PAGE_VIEW = "landingPage";
	private static final String INVESTMENT_TRANSACTIONS_VIEW = "userInvestmentTransaction";
	private static final String REDEEM_TRANSACTION_VIEW = "userRedeemTransaction";
	private static final String EXPLORE_MUTUALFUND_SCHEMES_VIEW = "exploreMutualFunds";

	private UserService userService;
	private UserSchemeService userSchemeService;
	private TransactionService transactionService;
	private PasswordEncoder passwordEncoder;
	private MutualFundService mutualFundService;

	@Autowired
	public UserController(UserService userService, UserSchemeService userSchemeService,
			TransactionService transactionService, PasswordEncoder passwordEncoder,
			MutualFundService mutualFundService) {
		this.userService = userService;
		this.userSchemeService = userSchemeService;
		this.transactionService = transactionService;
		this.passwordEncoder = passwordEncoder;
		this.mutualFundService = mutualFundService;
	}

	private void userIconAttributes(Model model, UserDetails userDetails) {
		User user = userService.findUserByUsername(userDetails.getUsername());
		model.addAttribute("firstName", user.getFirstName());
		model.addAttribute("lastName", user.getLastName());
		model.addAttribute("userId", user.getId());
		LOGGER.info("Passing attributes to user icon to user: {} with ID: {}", user.getFirstName() + user.getLastName(),
				user.getId());
	}

	@GetMapping("/mutualfund/userprofile-view")
	public String userProfileView(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		LOGGER.info("Handling request to view user profile for user");

		userIconAttributes(model, userDetails);
		User user = userService.findUserByUsername(userDetails.getUsername());
		model.addAttribute("user", user);

		LOGGER.info("User profile details retrieved successfully for user: {}",
				user.getFirstName() + user.getLastName());

		return USER_PROFILE_VIEW;
	}

	@GetMapping("/mutualfund/userprofile-edit")
	public String userProfileEditView(Model model, @AuthenticationPrincipal UserDetails userDetails,
			@ModelAttribute("successMessage") String successMessage) {
		LOGGER.info("Handling request to edit user profile of user");

		User user = userService.findUserByUsername(userDetails.getUsername());
		model.addAttribute("user", user);
		model.addAttribute("successMessage", successMessage);
		userIconAttributes(model, userDetails);

		LOGGER.info("User profile edit view loaded successfully for user: {}",
				user.getFirstName() + user.getLastName());

		return USER_PROFILE_EDIT_VIEW;
	}

	@PostMapping("/mutualfund/userprofile-edit")
	public String processUserProfileEditViewDetails(@AuthenticationPrincipal UserDetails userDetails,
			@ModelAttribute("userRegisterModel") UserRegisterModel userModel, RedirectAttributes redirectAttributes) {
		LOGGER.info("Processing user profile update for user");

		User user = userService.findUserByUsername(userDetails.getUsername());
		user.setFirstName(StringUtils.capitalize(userModel.getFirstName()));
		user.setLastName(StringUtils.capitalize(userModel.getLastName()));  
		user.setAge(userModel.getAge());
		user.setPhoneNumber(userModel.getPhoneNumber());
		userService.updateUser(user);
		redirectAttributes.addFlashAttribute("successMessage", "Profile Updated Successfully");

		LOGGER.info("User profile updated successfully for user: {}", user.getFirstName() + user.getLastName());

		return "redirect:/mutualfund/userprofile-view";
	}

	@GetMapping("/mutualfund/userprofile-change-password")
	public String userChangePassword(@AuthenticationPrincipal UserDetails userDetails, Model model,
			@ModelAttribute("errorMessage") String errorMessage) {
		LOGGER.info("Handling request to change password for user");
		userIconAttributes(model, userDetails);

		return CHANGE_PASSWORD_VIEW;
	}

	@PostMapping("/mutualfund/userprofile-change-password")
	public String processUserChangePassword(@AuthenticationPrincipal UserDetails userDetails,
			@RequestParam String currentPassword, @RequestParam String password, Model model,
			RedirectAttributes redirectAttributes) {
		LOGGER.info("Processing change password request for user: {}", userDetails.getUsername());

		String result = userService.validatingChangePassword(userDetails, currentPassword, password);
		userIconAttributes(model, userDetails);
		if (result.equals("Unique")) {
			LOGGER.warn("Change password failed: Old and new password must not be the same!");
			redirectAttributes.addFlashAttribute("errorMessage", "Old and new password must not be the same!");

			return "redirect:/mutualfund/userprofile-change-password";
		}
		if (result.equals("NotValidPassword")) {
			LOGGER.warn("Change password failed: Enter a valid old password!");
			redirectAttributes.addFlashAttribute("errorMessage", "Enter a valid old password!");

			return "redirect:/mutualfund/userprofile-change-password";
		}
		if (result.equals("Success")) {
			LOGGER.info("Password changed successfully!");
			redirectAttributes.addFlashAttribute("successMessage", "Password changed successfully!");
		}

		return "redirect:/mutualfund/login";
	}

	@GetMapping("/mutualfund/invest-transactions")
	public String showUserInvestTransactions(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		LOGGER.info("Handling request to display User: {} Invest Transactions.", userDetails.getUsername());

		return listByInvestPage(model, userDetails, 1);
	}

	@RequestMapping("/mutualfund/pageI/{pageNumberI}")
	public String listByInvestPage(Model model, @AuthenticationPrincipal UserDetails userDetails,
			@PathVariable("pageNumberI") int currentPage) {
		LOGGER.info("Handling request to list User Invest Transaction on page: {}", currentPage);

		User user = userService.findUserByUsername(userDetails.getUsername());
		Page<Transaction> page = transactionService.listAllInvestments(currentPage, user.getId());
		long totalitems = page.getTotalElements();
		int totalpages = page.getTotalPages();
		userIconAttributes(model, userDetails);
		List<Transaction> listTransaction = page.getContent();

		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalitems", totalitems);
		model.addAttribute("totalpages", totalpages);
		model.addAttribute("investTransactions", listTransaction);

		LOGGER.info("User Invest Transactions listed successfully for page: {}", currentPage);

		return INVESTMENT_TRANSACTIONS_VIEW;
	}

	@GetMapping("/mutualfund/redeem-transactions")
	public String showUserRedeemTransactions(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		LOGGER.info("Handling request to display User: {} Redeem Transactions.", userDetails.getUsername());

		return listByRedeemPage(model, userDetails, 1);
	}

	@RequestMapping("/mutualfund/pageR/{pageNumberR}")
	public String listByRedeemPage(Model model, @AuthenticationPrincipal UserDetails userDetails,
			@PathVariable("pageNumberR") int currentPage) {
		LOGGER.info("Handling request to list User Redeem Transaction on page: {}", currentPage);

		User user = userService.findUserByUsername(userDetails.getUsername());
		Page<Transaction> page = transactionService.listAllRedeems(currentPage, user.getId());
		long totalitems = page.getTotalElements();
		int totalpages = page.getTotalPages();
		userIconAttributes(model, userDetails);
		List<Transaction> listTransaction = page.getContent();

		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalitems", totalitems);
		model.addAttribute("totalpages", totalpages);
		model.addAttribute("redeemTransactions", listTransaction);

		LOGGER.info("User Redeem Transactions listed successfully for page: {}", currentPage);

		return REDEEM_TRANSACTION_VIEW;
	}

	@GetMapping("/mutualfund/explore-mutualfunds")
	public String exploreMutualFunds(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		LOGGER.info("Handling request to explore mutual funds");

		userIconAttributes(model, userDetails);
		List<MutualFundScheme> mutualFundSchemes = mutualFundService.getAllMutualFundSchemes();
		model.addAttribute("mutualFundSchemes", mutualFundSchemes);

		LOGGER.info("Mutual funds exploration completed successfully");

		return listByPage(model, userDetails, 1);
	}

	@RequestMapping("/mutualfund/page/{pageNumber}")
	public String listByPage(Model model, @AuthenticationPrincipal UserDetails userDetails,
			@PathVariable("pageNumber") int currentPage) {
		LOGGER.info("Handling request to list mutual funds on page: {}", currentPage);

		Page<MutualFundScheme> page = mutualFundService.listAll(currentPage);
		long totalitems = page.getTotalElements();
		int totalpages = page.getTotalPages();
		userIconAttributes(model, userDetails);
		List<MutualFundScheme> listMutualFundSchemes = page.getContent();

		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalitems", totalitems);
		model.addAttribute("totalpages", totalpages);
		model.addAttribute("mutualFundSchemes", listMutualFundSchemes);
		
		LOGGER.info("Mutual funds listed successfully for page: {}", currentPage);
		
		return EXPLORE_MUTUALFUND_SCHEMES_VIEW;
	}

	@GetMapping("/mutualfund/home")
	public String userPage(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		LOGGER.info("Handling request to display user home page");

		User user = userService.findUserByUsername(userDetails.getUsername());
		BigDecimal totalInvestedAmount = userSchemeService.getSumInvestedAmount(user.getId());
		BigDecimal totalReturnAmount = userSchemeService.getSumCurrentAmount(user.getId());
		BigDecimal totalReturnsPercentage = userSchemeService.calculateReturnsPercentage(user.getId());

		userIconAttributes(model, userDetails);
		List<Object[]> pieChartData = transactionService.getTotalAmountByMutualFund(user.getId());
		List<UserScheme> userSchemes = userSchemeService.findSchemesByUser(user.getId());
		model.addAttribute("userSchemes", userSchemes);
		model.addAttribute("pieChartDataSummary", pieChartData);
		model.addAttribute("totalInvestedAmount", totalInvestedAmount);
		model.addAttribute("totalReturnAmount", totalReturnAmount);
		model.addAttribute("totalReturnsPercentage", totalReturnsPercentage);

		LOGGER.info("Home page displayed successfully for User: {}", user.getFirstName() + user.getLastName());

		return HOME_PAGE_VIEW;
	}

	@PostMapping("/mutualfund/register")
	public String processRegsiterForm(@ModelAttribute("userRegisterModel") UserRegisterModel userModel,
			RedirectAttributes redirectAttributes) throws Exception {
		LOGGER.info("Handling registration request for user: {} with email: {}",
				userModel.getFirstName() + userModel.getLastName(), userModel.getEmail());

		User newUser = new User(StringUtils.capitalize(userModel.getFirstName()),
				StringUtils.capitalize(userModel.getLastName()), userModel.getAge(), userModel.getPhoneNumber(),
				userModel.getEmail(), passwordEncoder.encode(userModel.getPassword()));
		User user = userService.createUser(newUser);
		if (user != null) {
			redirectAttributes.addFlashAttribute("message",
					"User registration is successful, please check your Email for your Username ");
			LOGGER.info("User registration successful for user: {} with email: {} ",
					userModel.getFirstName() + userModel.getLastName(), userModel.getEmail());
		} else {
			redirectAttributes.addFlashAttribute("message", "User with this Email already exists");
			LOGGER.error("User registration failed. User: {} with email {} already exists",
					userModel.getFirstName() + userModel.getLastName(), userModel.getEmail());
		}

		return "redirect:/mutualfund/register";
	}

	@GetMapping("/mutualfund/register")
	public String registerForm(@ModelAttribute("message") String message, Model model) {
		LOGGER.info("Handling request to display registration form");

		model.addAttribute("message", message);

		LOGGER.info("Registration form displayed");

		return REGISTER_VIEW;
	}

	@GetMapping("/mutualfund/login")
	public String login(@ModelAttribute("successMessage") String successMessage, Model model) {
		LOGGER.info("Handling request to display login form");

		model.addAttribute("successMessage", successMessage);

		LOGGER.info("Login form displayed");

		return LOGIN_VIEW;
	}

	@GetMapping("/mutualfund")
	public String landingPage() {
		LOGGER.info("Handling request to display landing page");

		return LANDING_PAGE_VIEW;
	}
}