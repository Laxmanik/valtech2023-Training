package com.valtech.training.employeedepartmentspringboot.controllers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valtech.training.employeedepartmentspringboot.models.EmployeeModel;
import com.valtech.training.employeedepartmentspringboot.services.EmployeeDepartmentService;

@Controller
public class EmployeeDepartmentController {

	@Autowired
	private EmployeeDepartmentService employeeDepartmentService;
	
//	@Autowired
//	private JdbcTemplate jdbcTemplate; //using jdbc template foro querying list
	
	@GetMapping("/employeeslist")
//	@ResponseBody
	public String getAllEmployees(Model model) {
		model.addAttribute("employees",
				employeeDepartmentService.getAllEmployees().stream().map(employee -> new EmployeeModel(employee)).collect(Collectors.toList()));
//		List<Map<String, Object>> employees = jdbcTemplate.queryForList("select * from employee"); //without creating Model
//		model.addAttribute("employees", employees);
		return "employeeslist";
	}
	
	@GetMapping("/newEmployee")
	public String newEmplyee(Model model) {
		model.addAttribute("employee", new EmployeeModel());
		return "addOrEditEmployee";
	}
	
	@PostMapping(path = "/save", params = "submit")
	public String saveEmployee(@ModelAttribute 	EmployeeModel employeeModel, Model model) {
		employeeDepartmentService.createEmployee(employeeModel.getEmployee());
		model.addAttribute("employees",
				employeeDepartmentService.getAllEmployees().stream().map(employee -> new EmployeeModel(employee)).collect(Collectors.toList()));
		return "employeeslist";
	}
	
	@PostMapping(path = "/save", params = "cancel")
	public String cancelEmployee(Model model) {
		model.addAttribute("employees",
				employeeDepartmentService.getAllEmployees().stream().map(employee -> new EmployeeModel(employee)).collect(Collectors.toList()));
		return "redirect:employeeslist";
	}
	
}
