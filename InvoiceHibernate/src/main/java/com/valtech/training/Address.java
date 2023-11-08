package com.valtech.training;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int building_no;
	private String street;
	private String city;
	private String state;
	private String country;
	private int zipCode;
	@OneToOne(targetEntity = Vendors.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "address")
	private Vendors vendors;
	@OneToOne(targetEntity = Customers.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "address")
	private Customers  customers;
	

	public Customers getCustomers() {
		return customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBuilding_no() {
		return building_no;
	}

	public void setBuilding_no(int building_no) {
		this.building_no = building_no;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public Vendors getVendors() {
		return vendors;
	}

	public void setVendors(Vendors vendors) {
		this.vendors = vendors;
	}

	public Address() {
	}

	public Address(int building_no, String street, String city, String state, String country, int zipCode) {
		this.building_no = building_no;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}

}
