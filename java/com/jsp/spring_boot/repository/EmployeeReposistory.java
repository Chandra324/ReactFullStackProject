package com.jsp.spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.jsp.spring_boot.entity.Employee;

import jakarta.transaction.Transactional;

public interface EmployeeReposistory extends JpaRepository<Employee, Long>{
	
	  
}
