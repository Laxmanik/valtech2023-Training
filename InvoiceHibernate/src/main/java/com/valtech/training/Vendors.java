package com.valtech.training;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Vendors")
public class Vendors {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private String phone_no;
	private String vendor_name;
	@OneToOne(targetEntity = Address.class,cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id",referencedColumnName = "id")
	private Address address;
	@OneToMany(targetEntity = Items.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "vendors")
	private Set<Items> items;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getVendor_name() {
		return vendor_name;
	}

	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Set<Items> getItems() {
		return items;
	}
	public void setItems(Set<Items> items) {
		this.items = items;
	}

	public Vendors() {
	}

	public Vendors(String email, String phone_no, String vendor_name) {
		this.email = email;
		this.phone_no = phone_no;
		this.vendor_name = vendor_name;
	}

}
