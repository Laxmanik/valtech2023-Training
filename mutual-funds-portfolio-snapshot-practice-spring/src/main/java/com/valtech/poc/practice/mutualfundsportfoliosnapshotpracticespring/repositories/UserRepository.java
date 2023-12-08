package com.valtech.poc.practice.mutualfundsportfoliosnapshotpracticespring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.poc.practice.mutualfundsportfoliosnapshotpracticespring.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}