package com.valtech.poc.mutualfundportfolio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.poc.mutualfundportfolio.entities.MutualFund;
import com.valtech.poc.mutualfundportfolio.repositories.MutualFundRepository;

@Service
public class MutualFundServiceImpl implements MutualFundService {

	@Autowired
	MutualFundRepository mutualFundRepository;

	@Override
	public MutualFund createMutualFund(MutualFund mutualFund) {
		return mutualFundRepository.save(mutualFund);
	}

	@Override
	public MutualFund updateMutualFund(MutualFund mutualFund) {
		return mutualFundRepository.save(mutualFund);
	}

	@Override
	public List<MutualFund> getAllMutualFunds(){
		return mutualFundRepository.findAll();
	}

}
