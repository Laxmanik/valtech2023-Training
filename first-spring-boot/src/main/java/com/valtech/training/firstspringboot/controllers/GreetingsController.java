package com.valtech.training.firstspringboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingsController {
	
//	private Model model;

//	@RequestMapping(method = RequestMethod.GET, path="/hello")
//	@ResponseBody
	
	
	@GetMapping("/hello")
	public String hello() {
	//public String hello(@RequestParam("name") String name,Model model) {
//		model.addAttribute("name",name);
		return "hello";
	}
}
