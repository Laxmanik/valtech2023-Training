package com.valtech.poc.mutualfundportfolio.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class MutualFundScheme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String schemeName;
	private String description;
	private double netAssetValue;
	@ManyToOne(targetEntity = MutualFund.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "typeId", referencedColumnName = "id")
	private MutualFund mutualFund;
	@OneToMany(targetEntity = Transaction.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "mutualFundScheme")
	private Set<Transaction> transactions;

	public void addTransactions(Transaction transaction) {
		if (getTransactions() == null) {
			setTransactions(new HashSet<Transaction>());
		}
		getTransactions().add(transaction);
		transaction.setMutualFundScheme(this);
	}

	public MutualFundScheme() {
		super();
	}

	public MutualFundScheme(String schemeName, String description, double netAssetValue, MutualFund mutualFund) {
		super();
		this.schemeName = schemeName;
		this.description = description;
		this.netAssetValue = netAssetValue;
		this.mutualFund = mutualFund;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getNetAssetValue() {
		return netAssetValue;
	}

	public void setNetAssetValue(double netAssetValue) {
		this.netAssetValue = netAssetValue;
	}

	public MutualFund getMutualFund() {
		return mutualFund;
	}

	public void setMutualFund(MutualFund mutualFund) {
		this.mutualFund = mutualFund;
	}

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

}
