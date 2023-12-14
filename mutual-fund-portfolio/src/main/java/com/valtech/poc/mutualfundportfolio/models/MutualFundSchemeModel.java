package com.valtech.poc.mutualfundportfolio.models;

import com.valtech.poc.mutualfundportfolio.entities.MutualFund;

public class MutualFundSchemeModel {

	private String schemeName;
	private String description;
	private double netAssetValue;
	private MutualFund mutualFund;

	public MutualFundSchemeModel() {
		super();
	}

	public MutualFundSchemeModel(String schemeName, String description, double netAssetValue, MutualFund mutualFund) {
		super();
		this.schemeName = schemeName;
		this.description = description;
		this.netAssetValue = netAssetValue;
		this.mutualFund = mutualFund;
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

}
