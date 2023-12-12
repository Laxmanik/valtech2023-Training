package com.valtech.poc.mutualfundportfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.valtech.poc.mutualfundportfolio.entities.MutualFundScheme;

@Repository
public interface MutualFundSchemeRepository extends JpaRepository<MutualFundScheme, Integer> {

}
