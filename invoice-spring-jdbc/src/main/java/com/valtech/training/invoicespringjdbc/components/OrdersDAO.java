package com.valtech.training.invoicespringjdbc.components;

import java.util.List;

public interface OrdersDAO {

	void createOrders(Orders order);

	long count();

	void updateOrders(Orders order);

	void deleteOrders(int orderId);

	Orders getOrders(int orderId);

	List<Orders> getAllOrders();

}