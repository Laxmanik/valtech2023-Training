package com.valtech.team3.bookmyseat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.team3.bookmyseat.entities.RestrictedSeat;

@Repository
public interface RestrictedSeatRepo extends JpaRepository<RestrictedSeat, Integer>{

}
