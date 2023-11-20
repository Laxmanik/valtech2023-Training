package com.valtech.training.invoicespringjdbc.components;

public class Vendor {

	private int vendorId;
	private String vendorName;
	private int addressId;

	public Vendor() {
	}

	public Vendor(int vendorId, String vendorName, int addressId) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.addressId = addressId;
	}

	public Vendor(String vendorName, int addressId) {
		super();
		this.vendorName = vendorName;
		this.addressId = addressId;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

}
