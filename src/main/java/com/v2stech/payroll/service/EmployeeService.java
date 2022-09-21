package com.v2stech.payroll.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.v2stech.payroll.dao.EmployeeDao;
import com.v2stech.payroll.model.UserData;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDaoImpl;

	public List<UserData> employeeDetailsList() throws ClassNotFoundException, SQLException {
		List<UserData> userdataList = new ArrayList<UserData>();
		userdataList = employeeDaoImpl.getListAfterLogin();
		return userdataList;
	}

}
