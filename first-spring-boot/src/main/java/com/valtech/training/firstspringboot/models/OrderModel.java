package com.valtech.training.firstspringboot.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.valtech.training.firstspringboot.entities.Order;

public class OrderModel {

	private static final DateTimeFormatter ORDER_DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	private long id;
	private String item;
	private int itemCount;
	private String description;
	private String orderDate;

	public OrderModel() {
		super();
	}

	public OrderModel(Order order) {
		this.id = order.getId();
		this.item = order.getItem();
		this.itemCount = order.getItemCount();
		this.description = order.getDescription();
		this.orderDate = order.getOrderDate() == null ? "" : order.getOrderDate().format(ORDER_DATE_FORMATTER);
	}

	public Order getOrder() {
		return new Order(id, item, itemCount, description, LocalDate.parse(orderDate, ORDER_DATE_FORMATTER));
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

}