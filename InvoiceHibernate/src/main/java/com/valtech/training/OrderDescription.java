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
@Table(name = "Order_Description")
public class OrderDescription {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int quantity;
	@OneToOne(targetEntity = Items.class,cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY)
	@JoinColumn(name = "item_id",referencedColumnName = "id")
	private Items items;
	@OneToOne(targetEntity = Orders.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "orderDescription")
	private Orders orders;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Items getItems() {
		return items;
	}
	public void setItems(Items items) {
		this.items = items;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	
	public OrderDescription() {
	}
	
	public OrderDescription(int quantity) {
		this.quantity = quantity;
	}

}
