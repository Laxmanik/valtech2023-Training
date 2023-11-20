package com.valtech.training.invoicespringjdbc.components;

public class Item {

	private int itemId;
	private String itemName;
	private float itemAmount;
	private int manufactureId;

	public Item() {
	}

	public Item(int itemId, String itemName, float itemAmount, int manufactureId) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemAmount = itemAmount;
		this.manufactureId = manufactureId;
	}

	public Item(String itemName, float itemAmount, int manufactureId) {
		super();
		this.itemName = itemName;
		this.itemAmount = itemAmount;
		this.manufactureId = manufactureId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getItemAmount() {
		return itemAmount;
	}

	public void setItemAmount(float itemAmount) {
		this.itemAmount = itemAmount;
	}

	public int getManufactureId() {
		return manufactureId;
	}

	public void setManufactureId(int manufactureId) {
		this.manufactureId = manufactureId;
	}

}
