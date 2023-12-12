package com.valtech.poc.mutualfundportfolio.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class MutualFund {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	private String description;
	@OneToMany(targetEntity = MutualFundScheme.class, mappedBy = "mutualFund")
	private Set<MutualFundScheme> mutualFundSchemes;

	public void addSchemes(MutualFundScheme scheme) {
		if (getMutualFundSchemes() == null) {
			setMutualFundSchemes(new HashSet<MutualFundScheme>());
		}
		getMutualFundSchemes().add(scheme);
		scheme.setMutualFund(this);
	}

	public MutualFund() {
		super();
	}

	public MutualFund(String type, String description) {
		super();
		this.type = type;
		this.description = description;
	}

	public MutualFund(int id, String type, String description) {
		super();
		this.id = id;
		this.type = type;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<MutualFundScheme> getMutualFundSchemes() {
		return mutualFundSchemes;
	}

	public void setMutualFundSchemes(Set<MutualFundScheme> mutualFundSchemes) {
		this.mutualFundSchemes = mutualFundSchemes;
	}

}
