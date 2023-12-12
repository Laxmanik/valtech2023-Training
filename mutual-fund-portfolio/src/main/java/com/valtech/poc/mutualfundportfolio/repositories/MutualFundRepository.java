package com.valtech.poc.mutualfundportfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.valtech.poc.mutualfundportfolio.entities.MutualFund;

@Repository
public interface MutualFundRepository extends JpaRepository<MutualFund, Integer> {

}
