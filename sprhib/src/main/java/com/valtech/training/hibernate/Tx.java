package com.valtech.training.hibernate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
//@Inheritance(strategy = InheritanceType.JOINED) //joined table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //single table example
@DiscriminatorColumn(name = "disc")   //Class level annotation
@DiscriminatorValue("tx")
@Table(name = "alltxs")
public class Tx { //Transaction Class

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private float amount;
	
	public Tx() {}
	
	public Tx(float amount) {
		super();
		this.amount = amount;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
