package com.ems.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.demo.model.CompanyExpences;

public interface CompanyExpencesRepo extends JpaRepository<CompanyExpences, Integer>{
	
}
