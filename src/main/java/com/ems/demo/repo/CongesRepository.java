package com.ems.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.demo.model.Conges;


@Repository 
public interface CongesRepository extends JpaRepository<Conges, Integer>{ 

}
