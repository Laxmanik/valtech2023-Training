package com.valtech.training.firstspringboot.services;

import java.util.List;

import com.valtech.training.firstspringboot.entities.Order;

public interface OrderService {

	Order createOrder(Order order);

	Order updateOrder(Order order);

	Order getOrder(long orderId);

	List<Order> getAllOrders();

}