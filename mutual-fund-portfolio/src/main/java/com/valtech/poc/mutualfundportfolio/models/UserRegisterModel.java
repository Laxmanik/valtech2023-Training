package com.valtech.poc.mutualfundportfolio.models;

import com.valtech.poc.mutualfundportfolio.entities.User;

public class UserRegisterModel {

	private String name;
	private int age;
	private String email;
	private String password;
	private String confirmPassword;

	public UserRegisterModel() {
		super();
	}

	public UserRegisterModel(String name, int age, String email, String password) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.password = password;
	}

	public UserRegisterModel(String name, int age, String email, String password, String confirmPassword) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public User getUser() {

		return new User(name, age, email, password);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
