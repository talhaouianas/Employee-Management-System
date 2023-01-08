package com.ems.demo.service;

import java.io.FileNotFoundException;
import java.util.List;

import com.ems.demo.model.Conges;



import net.sf.jasperreports.engine.JRException;

public interface CongesService {	
	List<Conges> getAllConges();
	void saveConges(Conges conges);
	Conges getCongesById(int id);
	void deleteCongesById(int id);
	//String exportReport(String format) throws FileNotFoundException, JRException;
}
