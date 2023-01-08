package com.ems.demo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.ems.demo.model.Conges;
import com.ems.demo.model.Employee;
import com.ems.demo.repo.CongesRepository;
import com.ems.demo.repo.EmployeeRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class CongesServiceImpl implements CongesService {

	@Autowired
	private CongesRepository congesRepository;
	
	@Override
	public List<Conges> getAllConges() {
		return congesRepository.findAll();
	}

	@Override
	public void saveConges(Conges conges) {
		this.congesRepository.save(conges);
	}

	@Override
	public Conges getCongesById(int id) {
		Optional<Conges> optional = congesRepository.findById(id);
		Conges conges = null;
		if(optional.isPresent()) {
			conges = optional.get();
		}else {
			throw new RuntimeException("Employee not found for id :: " + id);
		}
		return conges;
	}

	@Override
	public void deleteCongesById(int id) {
		this.congesRepository.deleteById(id);
		
	}
	
	public String exportReport(String format) throws FileNotFoundException, JRException {
		List<Conges> employeeList = getAllConges();	
		String path = "C://Users//M2i//Desktop//projet//";
		
		File file = ResourceUtils.getFile("classpath:Employees.jrxml");
		JasperReport jasper = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(employeeList);		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("Conges", "List");		
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasper, parameters, ds);
		
		if(format.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint, path +"//employees.html");
		}
		if(format.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path +"//employees.pdf");
		}
		
		return "path : "+path;
	}

}
