package com.valtech.training.invoicespringjdbc.components;

public class OrderSummary {

	private int id;
	private int itemId;
	private int itemQuantity;

	public OrderSummary() {
	}

	public OrderSummary(int id, int itemId, int itemQuantity) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.itemQuantity = itemQuantity;
	}

	public OrderSummary(int itemId, int itemQuantity) {
		super();
		this.itemId = itemId;
		this.itemQuantity = itemQuantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

}