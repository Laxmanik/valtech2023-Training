package com.valtech.training.invoicespringjdbc.components;

public class Address {

	private int addressId;
	private String street;
	private String city;
	private int zipcode;

	public Address() {
	}

	public Address(int id, String street, String city, int zipcode) {
		super();
		this.addressId = id;
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
	}

	public Address(String street, String city, int zipcode) {
		super();
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int id) {
		this.addressId = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

}
