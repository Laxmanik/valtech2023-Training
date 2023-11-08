package com.valtech.training.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.valtech.training.hibernate.Employee;

@Repository //All DAO classes will be defined using Repository
//@Service -> for all classes that are service class.. they will need Transaction(Tx) Support
//@Controller -> for all classes when we want them to  be used for presentation logic
//@Component -> they are general classes which need to be registered with beans
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
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
