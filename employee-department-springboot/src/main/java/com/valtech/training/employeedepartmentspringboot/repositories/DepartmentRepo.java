package com.valtech.training.employeedepartmentspringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.employeedepartmentspringboot.entities.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer>{

}
