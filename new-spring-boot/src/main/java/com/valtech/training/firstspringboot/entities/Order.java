package com.valtech.training.firstspringboot.entities;

import java.time.LocalDate;
import javax.persistence.*;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name = "orders")
public class Order {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String item;
	private int count;
	private String description;
	private LocalDate orderDate;
	
	public Order() {}
	
	public Order(String item, int count, String description, LocalDate orderDate) {
		super();
		this.item = item;
		this.count = count;
		this.description = description;
		this.orderDate = orderDate;
	}
	public Order(long id, String item, int count, String description, LocalDate orderDate) {
		super();
		this.id = id;
		this.item = item;
		this.count = count;
		this.description = description;
		this.orderDate = orderDate;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	
	
	
}
