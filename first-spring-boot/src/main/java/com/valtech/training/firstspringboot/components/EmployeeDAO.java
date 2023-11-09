package com.valtech.training.firstspringboot.components;

import java.util.List;

public interface EmployeeDAO {

	void deleteEmployee(int id);

	void updateEmployee(Employee emp);

	void createEmployee(Employee emp);

	List<Employee> getAllEmployees();

	Employee getEmployee(int id);
	
	public long count();

}