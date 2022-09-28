package com.v2stech.payroll.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.v2stech.payroll.service.EmployeeService;

/**
 * @author Aditya Kadam
 */

@RestController
@SessionAttributes("sessionUser")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeServiceImpl;
	
	@Autowired
	private HomeController homeController;

	/**
	 * @work Method used to go on another page which having payslip data related to person.
	 * @param modelAndView
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * 
	 */

	@GetMapping("/viewEmployeeAllData")
	public ModelAndView employeeDataInTable(ModelAndView modelAndView) throws ClassNotFoundException, SQLException {
		modelAndView.addObject("employeeList", employeeServiceImpl.employeeDetailsList());
		modelAndView.setViewName("EmployeeDataTableFormat");
		return modelAndView;
	}

	/**
	 * @work Back to Employee dashboard from "EmployeeDataTableFormat" Page
	 * @return modelAndView
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@GetMapping("employeePanel/backToEmployeeDashboard")
	public ModelAndView backToEmployeeDashboard() {
		return employeeLogout();		
	}
	
	
	@GetMapping("/employeePanel/logout")
	public ModelAndView employeeLogout() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("LoginPage");
		return modelAndView;
	}

}
