package com.valtech.training.invoicespringjdbc.components;

import java.sql.Date;

public class Orders {

	private int orderId;
	private Date OrderDate;
	private int customerId;

	public Orders() {
	}

	public Orders(int orderId, Date orderDate, int customerId) {
		super();
		this.orderId = orderId;
		OrderDate = orderDate;
		this.customerId = customerId;
	}

	public Orders(Date orderDate, int customerId) {
		super();
		OrderDate = orderDate;
		this.customerId = customerId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
