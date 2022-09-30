package com.v2stech.payroll.controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.v2stech.payroll.dao.EmployeeDao;
import com.v2stech.payroll.exception.InvalidCredentialException;
import com.v2stech.payroll.exception.InvalidFieldException;
import com.v2stech.payroll.model.UserCredentialModel;
import com.v2stech.payroll.service.HomeService;

/**
 * @author Aditya Kadam
 */
@Controller

@SessionAttributes("sessionUser")
public class HomeController {

	@Autowired
	private EmployeeDao employeeDaoImpl;

	@Autowired
	private HomeService homeServiceImpl;
	
	UserCredentialModel usermodel ;

	/**
	 * @work Method used to Display login Page.
	 * @param modelAndView
	 * @return modelAndView
	 */
	@GetMapping("/")
	public ModelAndView loginPageDisplay(ModelAndView modelAndView) {
		modelAndView.setViewName("LoginPage");
		return modelAndView;
	}

	/**
	 * @work Method used to display Admin dashboard after matching admin
	 *       credentilas.
	 * @param modelAndView
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@RequestMapping("/adminPanel/{email}")
	public ModelAndView adminDashBoardPage( ModelAndView modelAndView, UserCredentialModel userModel,
			@PathVariable String email) throws ClassNotFoundException, SQLException {
		usermodel = employeeDaoImpl.getData(email);
		modelAndView.addObject("sessionUser", usermodel);
		modelAndView.setViewName("AdminDashboard");
		return modelAndView;
	}
	
	
	/**
	 * 
	 * @work method used to display EMPLOYEE DASHBOARD PAGE after matching employee
	 *       credentials.
	 * @param email
	 * @param modelAndView
	 * @return modelAndView
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@GetMapping("/employeePanel/{email}")
	public ModelAndView customerDetailsPage(@PathVariable String email, ModelAndView modelAndView)
			throws ClassNotFoundException, SQLException {
		UserCredentialModel usermodel = employeeDaoImpl.getData(email);
		modelAndView.addObject("sessionUser", usermodel);
		modelAndView.addObject("userData", usermodel);
		modelAndView.setViewName("EmployeeDashboard");
		return modelAndView;
	}

	/**
	 * @work method use for login credentilas
	 * @param userCredModel
	 * @param result
	 * @return String
	 * @throws ClassNotFoundException
	 * @throws InvalidFieldException
	 * @throws SQLException
	 * @throws InvalidCredentialException
	 */
	@RequestMapping("/loginCredential")
	public String loginCheck(@Valid @RequestBody UserCredentialModel userCredModel, BindingResult result)
			throws ClassNotFoundException, InvalidFieldException, SQLException, InvalidCredentialException {
		return homeServiceImpl.loginCreadShowDashboard(userCredModel, result);
	}

}
