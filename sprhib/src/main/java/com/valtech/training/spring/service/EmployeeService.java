package com.valtech.training.spring.service;

import com.valtech.training.hibernate.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee e);

	Employee makeActive(Employee e);

	Employee makeInActive(Employee e);

	Employee incrementSalary(Employee e, float increment);

	void incrementSalaryForAll(int increment);

}