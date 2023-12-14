package com.valtech.poc.mutualfundportfolio.models;

import com.valtech.poc.mutualfundportfolio.entities.User;

public class UserRegisterModel {

	private String firstName;
	private String lastName;
	private int age;
	private long phoneNumber;
	private String email;
	private String password;
	private String confirmPassword;

	public UserRegisterModel() {
		super();
	}

	public UserRegisterModel(String firstName, String lastName, int age, long phoneNumber, String email,
			String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
	}

	public User getUser() {
		return new User(firstName, lastName, age, phoneNumber, email, password);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
