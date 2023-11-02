package com.valtech.training.hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ttx")
public class AtmTx extends Tx {

	private int atm;
	
	public AtmTx() {
	}
	
	public AtmTx(float amount, int atm) {
		super(amount);
		this.atm = atm;
	}



	public int getAtm() {
		return atm;
	}

	public void setAtm(int atm) {
		this.atm = atm;
	}
	
	
	
}
