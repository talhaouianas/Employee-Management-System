package com.ems.demo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ems.demo.model.Conges;
import com.ems.demo.model.Employee;
import com.ems.demo.service.CongesService;
import com.ems.demo.service.CongesServiceImpl;
import com.ems.demo.service.EmployeeService;
import com.ems.demo.service.EmployeeServiceImpl;


@RestController
@Controller
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl service;
	@Autowired
	CongesServiceImpl conges;
	
	/*
	 * @Autowired private CongeServiceImpl congeServiceImpl;
	 */
	
	
@RequestMapping(method=RequestMethod.POST,value="admin/employee")
	
	public String addEmployee(Employee employee) {
		
		service.saveEmployee(employee);
		
		return "redirect:/admin/employee-datatable";
		
	}
	
@RequestMapping(method=RequestMethod.POST,value="admin/conges")

public String addConges(Conges conges) {
	
	conges.saveConges(conges);
	
	return "redirect:/admin/conges-datatable";
	
}

	
	@GetMapping("/admin/viewEmployee")
	public String viewEmployee(@RequestParam int id, Model model) {
		
		Employee employee = service.getEmployeeById(id);
		service.deleteEmployeeById(id);
		model.addAttribute("employee", employee);		
		return "employee/view_employee";
	}
	

	
	@RequestMapping("/admin/deleteEmployee")
	public String deleteEmployee(@RequestParam int id) {
		
		service.deleteEmployeeById(id);
		return "redirect:/admin/employee-datatable";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        return "login";
    }

    @RequestMapping("/success")
    public void loginPageRedirect(HttpServletRequest request, HttpServletResponse response, Authentication authResult) throws IOException, ServletException {

        String role =  authResult.getAuthorities().toString();

        if(role.contains("ADMIN")){
         response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/admin/employee-dashboard"));                            
         }
         else if(role.contains("USER")) {
             response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/admin/employee-user-dashboard"));
          
         }
        
    }
    
    
	 
	
	
}
