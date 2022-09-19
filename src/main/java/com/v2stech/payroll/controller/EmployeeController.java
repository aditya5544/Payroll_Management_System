package com.v2stech.payroll.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.v2stech.payroll.service.EmployeeService;

/**
 * @author Aditya Kadam
 *
 */

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeServiceImpl;

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
	 */
	@GetMapping("/employeePage/backToEmployeeDashboard")
	public ModelAndView backToEmployeeDashboard() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("LoginPage");
		return modelAndView;
	}

}
