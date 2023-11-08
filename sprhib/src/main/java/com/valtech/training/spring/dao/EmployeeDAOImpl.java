package com.valtech.training.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.valtech.training.hibernate.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	private SessionFactory sessionFactory;
	
	@Override
	public void deleteEmployee(Employee emp) {
		Session ses = sessionFactory.getCurrentSession();
		ses.delete(emp);
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		Session ses = sessionFactory.getCurrentSession();
		ses.persist(emp);
		return emp;
	}
	
	@Override
	public Employee loadEmployee(int empId) {
		Session ses = sessionFactory.getCurrentSession();
		Employee emp = (Employee) ses.load(Employee.class, empId);
		return emp;
	}
	
	@Override
	public Employee updateEmployee(Employee emp) {
		Session ses = sessionFactory.getCurrentSession();
		emp = (Employee) ses.merge(emp);
		return emp;
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		Session ses = sessionFactory.getCurrentSession();
		List<Employee> emps = ses.createQuery("from employee e").list(); 
		return emps;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
