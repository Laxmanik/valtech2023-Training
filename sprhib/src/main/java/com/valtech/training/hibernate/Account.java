package com.valtech.training.hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Account { // One to Many Relation (Account => Transactions)

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double balance;
	private String accoutType;
	@OneToMany(targetEntity = Tx.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH }, fetch = FetchType.LAZY, mappedBy = "account")
	private Set<Tx> txs;
	@ManyToMany(targetEntity = Customer.class, fetch = FetchType.LAZY)
	@JoinTable(name = "customer_account", 
	joinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"),  //this table to join table, current table to other table
	inverseJoinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id") //other table to current table, customer to account table
	)
	private Set<Customer> customers;

	public Account(double balance, String accoutType) {
		this.balance = balance;
		this.accoutType = accoutType;
	}

	public Account() {
	}
	
	

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}
	
	public void addCustomer(Customer cust) {
		if(getCustomers() == null) {
			setCustomers(new HashSet<Customer>());
		}
		getCustomers().add(cust);
		
	}

	public void addTx(Tx tx) {
		if (getTxs() == null) {
			setTxs(new HashSet<Tx>());
		}
		getTxs().add(tx);
		tx.setAccount(this);
	}

	public void setTxs(Set<Tx> txs) {
		this.txs = txs;
	}

	public Set<Tx> getTxs() {
		return txs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccoutType() {
		return accoutType;
	}

	public void setAccoutType(String accoutType) {
		this.accoutType = accoutType;
	}

}
