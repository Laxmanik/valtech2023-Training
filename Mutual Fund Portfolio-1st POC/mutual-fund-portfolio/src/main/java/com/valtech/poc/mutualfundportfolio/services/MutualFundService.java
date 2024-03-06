package com.valtech.poc.mutualfundportfolio.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.valtech.poc.mutualfundportfolio.entities.MutualFund;
import com.valtech.poc.mutualfundportfolio.entities.MutualFundScheme;

public interface MutualFundService {

	MutualFund createMutualFund(MutualFund mutualFund);

	MutualFund updateMutualFund(MutualFund mutualFund);

	List<MutualFund> getAllMutualFundTypes();

	MutualFund getMutualFundById(int id);

	MutualFundScheme createMutualFundScheme(MutualFundScheme scheme);

	MutualFundScheme updateMutualFundScheme(MutualFundScheme scheme);

	List<MutualFundScheme> getAllMutualFundSchemes();

	MutualFundScheme getMutualFundSchemeById(int id);

	List<MutualFundScheme> getAllSchemesByMutualFundType(int mutualFundId);

	Page<MutualFundScheme> listAll(int pageNumber);
	
	Page<MutualFundScheme> listAllSchemes(int pageNumber);
}