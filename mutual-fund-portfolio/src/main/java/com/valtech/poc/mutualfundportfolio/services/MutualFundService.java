package com.valtech.poc.mutualfundportfolio.services;

import java.util.List;

import com.valtech.poc.mutualfundportfolio.entities.MutualFund;

public interface MutualFundService {

	MutualFund createMutualFund(MutualFund mutualFund);

	MutualFund updateMutualFund(MutualFund mutualFund);

	List<MutualFund> getAllMutualFunds();

}