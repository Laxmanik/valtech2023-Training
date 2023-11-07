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
@Table(name = "Customers")
public class Customers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String customerFisrt_Name;
	private String customerLast_Name;
	private int phone_no;
	private String email;
	@OneToOne(targetEntity = Address.class, cascade = { CascadeType.MERGE, CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;
	@OneToOne(targetEntity = Orders.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customers")
	private Orders orders;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerFisrt_Name() {
		return customerFisrt_Name;
	}

	public void setCustomerFisrt_Name(String customerFisrt_Name) {
		this.customerFisrt_Name = customerFisrt_Name;
	}

	public String getCustomerLast_Name() {
		return customerLast_Name;
	}

	public void setCustomerLast_Name(String customerLast_Name) {
		this.customerLast_Name = customerLast_Name;
	}

	public int getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(int phone_no) {
		this.phone_no = phone_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Customers() {
	}

	public Customers(String customerFisrt_Name, String customerLast_Name, int phone_no, String email) {
		this.customerFisrt_Name = customerFisrt_Name;
		this.customerLast_Name = customerLast_Name;
		this.phone_no = phone_no;
		this.email = email;
	}

}
