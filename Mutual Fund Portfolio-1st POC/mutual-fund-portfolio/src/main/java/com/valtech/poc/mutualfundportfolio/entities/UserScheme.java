package com.valtech.poc.mutualfundportfolio.entities;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UserScheme {
	@EmbeddedId
	private UserSchemeId id;
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "userId", insertable = false, updatable = false)
	@JsonIgnore
	private User user;
	@ManyToOne(targetEntity = MutualFundScheme.class)
	@JoinColumn(name = "schemeId", insertable = false, updatable = false)
	@JsonIgnore
	private MutualFundScheme scheme;
	@Column(precision = 10, scale = 2)
	private BigDecimal purchasedNav;
	@Column(precision = 10, scale = 2)
	private BigDecimal schemeUnits;
	@Column(precision = 10, scale = 2)
	private BigDecimal investedAmount;
	@Column(precision = 10, scale = 2)
	private BigDecimal currentAmount;

	public UserScheme() {
	}

	public UserScheme(UserSchemeId id, BigDecimal schemeUnits, BigDecimal investedAmount) {
		this.id = id;
		this.schemeUnits = schemeUnits;
		this.investedAmount = investedAmount;
	}

	public UserScheme(UserSchemeId id, BigDecimal purchasedNav, BigDecimal schemeUnits, BigDecimal investedAmount) {
		this.id = id;
		this.purchasedNav = purchasedNav;
		this.schemeUnits = schemeUnits;
		this.investedAmount = investedAmount;
	}

	public UserScheme(UserSchemeId id, BigDecimal schemeUnits) {
		this.id = id;
		this.schemeUnits = schemeUnits;
	}

	public UserScheme(UserSchemeId id) {
		this.id = id;
	}

	public UserSchemeId getId() {
		return id;
	}

	public void setId(UserSchemeId id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public MutualFundScheme getScheme() {
		return scheme;
	}

	public void setScheme(MutualFundScheme scheme) {
		this.scheme = scheme;
	}

	public BigDecimal getSchemeUnits() {
		return schemeUnits;
	}

	public void setSchemeUnits(BigDecimal schemeUnits) {
		this.schemeUnits = schemeUnits;
	}

	public BigDecimal getInvestedAmount() {
		return investedAmount;
	}

	public void setInvestedAmount(BigDecimal investedAmount) {
		this.investedAmount = investedAmount;
	}

	public BigDecimal getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(BigDecimal currentAmount) {
		this.currentAmount = currentAmount;
	}

	public BigDecimal getPurchasedNav() {
		return purchasedNav;
	}

	public void setPurchasedNav(BigDecimal purchasedNav) {
		this.purchasedNav = purchasedNav;
	}

}
