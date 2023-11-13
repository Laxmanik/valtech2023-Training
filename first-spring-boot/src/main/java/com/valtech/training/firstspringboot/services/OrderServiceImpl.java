package com.valtech.training.firstspringboot.services;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.firstspringboot.entities.Order;
import com.valtech.training.firstspringboot.repositories.OrderRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepo orderRepo;
	
	@PostConstruct
	public void populateOrders() {
		
		Order order=new Order("IPhone 14 Pro Max", 25, "Apple Iphone", LocalDate.of(2023, 11, 8));
		Order order1=new Order("MacBook M1", 25, "Apple Laptop", LocalDate.of(2023, 11, 8));
		Order order2=new Order("MacBook M2", 25, "Apple Laptop", LocalDate.of(2023, 11, 8));
		Order order3=new Order("IPhone 15 Pro Max", 25, "Apple Iphone", LocalDate.of(2023, 11, 8));
		orderRepo.save(order);
		orderRepo.save(order1);
		orderRepo.save(order2);
		orderRepo.save(order3);
	}
	
	@Override
	public Order createOrder(Order order) {
		System.out.println(orderRepo.getClass().getName());
		return orderRepo.save(order);
	}
	
	@Override
	public Order updateOrder(Order order) {
		return orderRepo.save(order);
	}
	
	@Override
	public Order getOrder(long orderId) {
		return orderRepo.getReferenceById(orderId);
	}
	
	@Override
	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}
	
}
