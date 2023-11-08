package com.valtech.training.firstspringboot.Components;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

	void deleteEmployee(int id);

	void updateEmployee(Employee emp);

	void createEmployee(Employee emp);

	List<Employee> getAllEmployees();

	Employee getEmployee(int id);
	
	public long count();

}