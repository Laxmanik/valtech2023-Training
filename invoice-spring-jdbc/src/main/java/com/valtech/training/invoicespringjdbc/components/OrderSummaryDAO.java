package com.valtech.training.invoicespringjdbc.components;

import java.util.List;

public interface OrderSummaryDAO {

	void createOrderSummary(OrderSummary os);

	long count();

	void updateOrderSummary(OrderSummary os);

	void deleteOrderSummary(int id);

	OrderSummary getOrderSummary(int id);

	List<OrderSummary> getAllOrderSummary();
	
}