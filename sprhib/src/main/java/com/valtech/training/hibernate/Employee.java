package com.valtech.training.hibernate;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;




@Entity
public class Employee {

	//1.Final Variable - Constant
	//2.Static variable
	//3.constructor
	//4.methods
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) //Hibernate generating primary key through mysql, GenaerationType.Identity -> mysql uses suto-increment on column
	
//	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="xyz") //for oracle, in this case hibernate will set primary key, even insertion query should be given with id
//	@SequenceGenerator(name="abc",sequenceName = "empseq")                 //for oracle 
	
	
//	@Id @GeneratedValue(strategy=GenerationType.TABLE,generator="abc")
//	@TableGenerator(name="abc",table="pktable",pkColumnName="PKcol",pkColumnValue="empseq",valueColumnName="seed") //independent of mysql and oracle, but here hibernate creates primary key based on seed value
	
	private int id;
	private String name;
	@Basic() @Temporal(TemporalType.DATE)
	private Date dob;
	private float salary;
	private char gender;
	private boolean active;
	@Version                              //optimistic locking with version
	private int version;
	
	public Employee() {}
	
	public Employee(int id, String name, Date dob, float salary, char gender, boolean active) {
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.salary = salary;
		this.gender = gender;
		this.active = active;
	}

	public Employee(String name, Date dob, float salary, char gender, boolean active) {
		this.name = name;
		this.dob = dob;
		this.salary = salary;
		this.gender = gender;
		this.active = active;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dob=" + dob + ", salary=" + salary + ", gender=" + gender
				+ ", active=" + active + ", version=" + version + "]";
	}
	
}
