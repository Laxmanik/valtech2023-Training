package com.valtech.poc.mutualfundportfolio.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "userId", referencedColumnName = "id")
	private User user;
	@ManyToOne(targetEntity = MutualFundScheme.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "schemeId", referencedColumnName = "id")
	private MutualFundScheme mutualFundScheme;
	private double netAssetValue;
	private double amount;
	private double navUnits;
	private LocalDate date;

	public Transaction() {
		super();
	}

	public Transaction(User user, MutualFundScheme mutualFundScheme, double netAssetValue, double amount,
			double navUnits) {
		super();
		this.user = user;
		this.mutualFundScheme = mutualFundScheme;
		this.netAssetValue = netAssetValue;
		this.amount = amount;
		this.navUnits = navUnits;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public MutualFundScheme getMutualFundScheme() {
		return mutualFundScheme;
	}

	public void setMutualFundScheme(MutualFundScheme mutualFundScheme) {
		this.mutualFundScheme = mutualFundScheme;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getNavUnits() {
		return navUnits;
	}

	public void setNavUnits(double navUnits) {
		this.navUnits = navUnits;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getNetAssetValue() {
		return netAssetValue;
	}

	public void setNetAssetValue(double netAssetValue) {
		this.netAssetValue = netAssetValue;
	}

}
