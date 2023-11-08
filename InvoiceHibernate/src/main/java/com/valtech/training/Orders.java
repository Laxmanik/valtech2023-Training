package com.valtech.training;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Orders {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String orderDate;
	@OneToOne(targetEntity = Customers.class,cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY)
	@JoinColumn(name = "customers_id",referencedColumnName = "id")
	private Customers customers;
	@OneToOne(targetEntity = OrderDescription.class,cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY)
	@JoinColumn(name = "orderDescription_id",referencedColumnName = "id")
	private OrderDescription orderDescription;
	
	public int getId() {
		return id;
	}
	public void setOrders_ID(int id) {
		this.id = id;
	}
	
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	public Customers getCustomers() {
		return customers;
	}
	public void setCustomers(Customers customers) {
		this.customers = customers;
	}
	
	public OrderDescription getOrderDescription() {
		return orderDescription;
	}
	public void setOrderDescription(OrderDescription orderDescription) {
		this.orderDescription = orderDescription;
	}
	
	public Orders() {
	}
	
	public Orders(String orderDate) {
		super();
		this.orderDate = orderDate;
	}
	
}
