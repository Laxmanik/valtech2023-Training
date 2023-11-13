package com.valtech.training.firstspringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.firstspringboot.entities.Order;

public interface OrderRepo extends JpaRepository<Order, Long>{

}
