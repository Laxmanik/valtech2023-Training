package com.valtech.training.employeedepartmentspringboot.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valtech.training.employeedepartmentspringboot.services.EmployeeDepartmentService;

@Controller
public class EmployeeDepartmentController {

	@Autowired
	private EmployeeDepartmentService employeeDepartmentService;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/employeeslist")
//	@ResponseBody
	public String getAllEmployees(Model model) {
		List<Map<String, Object>> employees = jdbcTemplate.queryForList("select * from employee");
		model.addAttribute("employees", employees);
		return "employeeslist";
	}
	
}
