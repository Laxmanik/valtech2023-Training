package com.valtech.training.spring.service;

import com.valtech.training.hibernate.Employee;
import com.valtech.training.spring.dao.EmployeeDAO;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;

	@Override
	public Employee createEmployee(Employee e) {
		return employeeDAO.saveEmployee(e);
	}

	@Override
	public Employee makeActive(Employee e) {
		e.setActive(true);
		return employeeDAO.updateEmployee(e);
	}

	@Override
	public Employee makeInActive(Employee e) {
		e.setActive(false);
		return employeeDAO.updateEmployee(e);
	}

	@Override
	public Employee incrementSalary(Employee e, float increment) {
		e.setSalary(e.getSalary()+increment);
		return employeeDAO.updateEmployee(e);
	}
	
	@Override
	public void incrementSalaryForAll(int increment) {
		employeeDAO.getAllEmployees().forEach(e -> e.setSalary(e.getSalary() + increment));
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
}
