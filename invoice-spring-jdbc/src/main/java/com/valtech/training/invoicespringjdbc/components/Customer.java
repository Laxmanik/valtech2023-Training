package com.valtech.training.invoicespringjdbc.components;

public class Customer {

	private int customerId;
	private String customerName;
	private long phoneNo;
	private int addressId;

	public Customer() {
	}

	public Customer(int customerId, String cutomerName, long phoneNo, int addressId) {
		super();
		this.customerId = customerId;
		this.customerName = cutomerName;
		this.phoneNo = phoneNo;
		this.addressId = addressId;
	}

	public Customer(String cutomerName, long phoneNo, int addressId) {
		super();
		this.customerName = cutomerName;
		this.phoneNo = phoneNo;
		this.addressId = addressId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String cutomerName) {
		this.customerName = cutomerName;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

}