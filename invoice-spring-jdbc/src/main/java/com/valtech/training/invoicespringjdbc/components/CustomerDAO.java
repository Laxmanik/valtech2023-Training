package com.valtech.training.invoicespringjdbc.components;

import java.util.List;

public interface CustomerDAO {

	void createCustomer(Customer customer);
	
	long count();
	
	void updateCustomer(Customer customer);
	
	void deleteCustomer(int customerId);
	
	Customer getCustomer(int customerId);
	
	List<Customer> getAllCustomers();
	
}