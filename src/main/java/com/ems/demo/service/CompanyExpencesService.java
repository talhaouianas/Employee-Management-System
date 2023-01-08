package com.ems.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.demo.model.CompanyExpences;
import com.ems.demo.repo.CompanyExpencesRepo;


@Service
public class CompanyExpencesService {
	
	@Autowired
	CompanyExpencesRepo repo;
	
	public void addexpences(CompanyExpences addexpences) {
		repo.save(addexpences);
	}
	
}
