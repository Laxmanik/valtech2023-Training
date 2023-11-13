package com.valtech.training.employeedepartmentspringboot.services;

import java.util.List;

import com.valtech.training.employeedepartmentspringboot.entities.Department;
import com.valtech.training.employeedepartmentspringboot.entities.Employee;

public interface EmployeeDepartmentService {

	//Create, Update, Get , getAll Department
	Department createDepartment(Department department);

	Department updateDepartment(Department department);

	Department getDepartment(int deptId);

	List<Department> getAllDepartments();

	//Create, Update, Get , getAll Employee
	Employee createEmployee(Employee employee);

	Employee updateEmployee(Employee employee);

	Employee getEmployee(int id);

	List<Employee> getAllEmployees();

}