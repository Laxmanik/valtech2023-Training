package com.valtech.training;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Items")
public class Items {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String item_Name;
	private String description;
	private int unit_Price;
	@ManyToOne(targetEntity = Vendors.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "vendors_id",referencedColumnName = "id")
	private Vendors vendors;
	@OneToOne(targetEntity = OrderDescription.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "items")
	private OrderDescription orderDescription;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getItem_Name() {
		return item_Name;
	}
	public void setItem_Name(String item_Name) {
		this.item_Name = item_Name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getUnit_Price() {
		return unit_Price;
	}
	public void setUnit_Price(int unit_Price) {
		this.unit_Price = unit_Price;
	}
	
	public Vendors getVendors() {
		return vendors;
	}
	public void setVendors(Vendors vendors) {
		this.vendors = vendors;
	}
	
	public OrderDescription getOrderDescription() {
		return orderDescription;
	}
	public void setOrderDescription(OrderDescription orderDescription) {
		this.orderDescription = orderDescription;
	}

	public Items() {
	}
	
	public Items(String item_Name, String description, int unit_Price) {
		this.item_Name = item_Name;
		this.description = description;
		this.unit_Price = unit_Price;
	}
	
}
		