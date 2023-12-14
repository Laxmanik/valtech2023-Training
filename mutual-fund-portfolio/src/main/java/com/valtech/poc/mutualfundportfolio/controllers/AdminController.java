package com.valtech.poc.mutualfundportfolio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.valtech.poc.mutualfundportfolio.services.MutualFundService;

@Controller
public class AdminController {

	@Autowired
	MutualFundService mutualFundService;

	@GetMapping("/mutualfund/admin")
	public String adminPage(Model model) {
		model.addAttribute("mutualfunds", mutualFundService.getAllMutualFunds());
		return "adminPage";
	}

	@GetMapping("/mutualfund/schemes")
	public String adminSchemesPage() {
		return "adminSchemes";
	}

}
