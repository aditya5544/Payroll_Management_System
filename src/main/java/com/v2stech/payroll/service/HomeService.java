package com.v2stech.payroll.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.v2stech.payroll.dao.AdminDao;
import com.v2stech.payroll.dao.EmployeeDao;
import com.v2stech.payroll.exception.InvalidCredentialException;
import com.v2stech.payroll.exception.InvalidFieldException;
import com.v2stech.payroll.model.PayslipForDatabase;
import com.v2stech.payroll.model.UserCredentialModel;

@Service

public class HomeService {

	@Autowired
	AdminDao adminDaoImpl;
	
	@Autowired
	EmployeeDao employeeDaoImpl;

	public Boolean dataCheckExisted(PayslipForDatabase payslip) throws ClassNotFoundException, SQLException {
		return adminDaoImpl.checkExistedData(payslip);
	}
	
	public String loginCreadShowDashboard(UserCredentialModel userCredModel, BindingResult result)
			throws SQLException, ClassNotFoundException, InvalidCredentialException, InvalidFieldException {
	boolean creadentialResult = employeeDaoImpl.loginCredentials(userCredModel);
		if (creadentialResult) {
			UserCredentialModel userDataFromTable = employeeDaoImpl.UserCredentialModel(userCredModel);
			if (userDataFromTable.getUsername().equals(userCredModel.getUsername())
					&& userDataFromTable.getPassword().equals(userCredModel.getPassword())) {
				if (userDataFromTable.getUserType().equalsIgnoreCase("admin")) {
					return "a";
				} else {
					return "e";
				}
			}
		} else {
			throw new InvalidCredentialException("Invalid Credentials");
		}
		return null;
	}

}
