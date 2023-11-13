package com.valtech.training.employeedepartmentspringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valtech.training.employeedepartmentspringboot.services.EmployeeDepartmentService;

@Controller
public class EmployeeDepartmentController {

	@Autowired
	private EmployeeDepartmentService employeeDepartmentService;
	
	@GetMapping("/employeeslist")
//	@ResponseBody
	public String getAllEmployees() {
		return "employeeslist";
	}
	
}
