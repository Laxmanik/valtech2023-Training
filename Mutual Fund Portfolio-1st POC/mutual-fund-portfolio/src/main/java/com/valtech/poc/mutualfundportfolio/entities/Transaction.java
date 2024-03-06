package com.valtech.poc.mutualfundportfolio.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "userId", referencedColumnName = "id")
	@JsonIgnore
	private User user;
	@ManyToOne(targetEntity = MutualFundScheme.class, fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "schemeId", referencedColumnName = "id")
	@JsonIgnore
	private MutualFundScheme mutualFundScheme;
	@Column(precision = 10, scale = 2)
	private BigDecimal netAssetValue;
	@Column(precision = 10, scale = 2)
	private BigDecimal amount;
	@Column(precision = 10, scale = 2)
	private BigDecimal navUnits;
	private LocalDateTime date;
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;

	public Transaction() {
	}

	public Transaction(User user, MutualFundScheme mutualFundScheme, BigDecimal netAssetValue, BigDecimal amount, BigDecimal navUnits, LocalDateTime date, TransactionType transactionType) {
		this.user = user;
		this.mutualFundScheme = mutualFundScheme;
		this.netAssetValue = netAssetValue;
		this.amount = amount;
		this.navUnits = navUnits;
		this.date = date;
		this.transactionType = transactionType;
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

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getNavUnits() {
		return navUnits;
	}

	public void setNavUnits(BigDecimal navUnits) {
		this.navUnits = navUnits;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public BigDecimal getNetAssetValue() {
		return netAssetValue;
	}

	public void setNetAssetValue(BigDecimal netAssetValue) {
		this.netAssetValue = netAssetValue;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
}
