package com.v2stech.payroll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.v2stech.payroll.model.UserCredentialModel;
import com.v2stech.payroll.model.UserData;

@Repository
@SessionAttributes("sessionUser")
public class EmployeeDao {

	@Autowired
	GenericDao genericDaoImpl;

	private String username;
	
	@Autowired
	Connection connection;


	public Boolean loginCredentials(UserCredentialModel userCredential) throws SQLException, ClassNotFoundException {
		PreparedStatement preparedStatement = genericDaoImpl.getPreparestatement();
		ResultSet resultSet = genericDaoImpl.getResultSet();
		preparedStatement = connection
				.prepareStatement("select * from employee where employee_email=? and employee_password=?");
		preparedStatement.setString(1, userCredential.getUsername());
		preparedStatement.setString(2, userCredential.getPassword());
		System.out.println("User Validate successfully");
		resultSet = preparedStatement.executeQuery();
		this.username = userCredential.getUsername();
		if (!resultSet.isBeforeFirst()) {
			return false;
		} else {
			return true;
		}
	}
	

//	public UserCredentialModel loginCredentials(UserCredentialModel userCredential) throws SQLException, ClassNotFoundException {
//		PreparedStatement preparedStatement = genericDaoImpl.getPreparestatement();
//		ResultSet resultSet = genericDaoImpl.getResultSet();
//		preparedStatement = connection
//				.prepareStatement("select * from employee where employee_email=? and employee_password=?");
//		preparedStatement.setString(1, userCredential.getUsername());
//		preparedStatement.setString(2, userCredential.getPassword());
//		resultSet = preparedStatement.executeQuery();
//		this.username = userCredential.getUsername();
//		return userCredential;
//	}

	public UserCredentialModel UserCredentialModel(UserCredentialModel userCredImpl)
			throws SQLException, ClassNotFoundException {
		ResultSet resultSet = genericDaoImpl.getResultSet();
		PreparedStatement preparedStatement = genericDaoImpl.getPreparestatement();
		preparedStatement = connection.prepareStatement("select * from employee where employee_email=?");
		preparedStatement.setString(1, username);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			userCredImpl.setUsername(resultSet.getString(resultSet.getMetaData().getColumnName(6)));
			userCredImpl.setPassword(resultSet.getString(resultSet.getMetaData().getColumnName(7)));
			userCredImpl.setUserType(resultSet.getString(resultSet.getMetaData().getColumnName(3)));
			userCredImpl.setId(resultSet.getInt(resultSet.getMetaData().getColumnName(2)));
			userCredImpl.setName(resultSet.getString(resultSet.getMetaData().getColumnName(5)));
		}
		return userCredImpl;
	}
	
	
	public UserCredentialModel getData(String email)
			throws SQLException, ClassNotFoundException {
		ResultSet resultSet = genericDaoImpl.getResultSet();
		PreparedStatement preparedStatement = genericDaoImpl.getPreparestatement();
		preparedStatement = connection.prepareStatement("select * from employee where employee_email=?");
		preparedStatement.setString(1, email);
		resultSet = preparedStatement.executeQuery();
		UserCredentialModel userCredImpl=new UserCredentialModel();
		while (resultSet.next()) {
			userCredImpl.setUsername(resultSet.getString(resultSet.getMetaData().getColumnName(6)));
			userCredImpl.setPassword(resultSet.getString(resultSet.getMetaData().getColumnName(7)));
			userCredImpl.setUserType(resultSet.getString(resultSet.getMetaData().getColumnName(3)));
			userCredImpl.setId(resultSet.getInt(resultSet.getMetaData().getColumnName(2)));
			userCredImpl.setName(resultSet.getString(resultSet.getMetaData().getColumnName(5)));
		}
		return userCredImpl;
	}
	

	public List<UserData> getListAfterLogin() throws ClassNotFoundException, SQLException {
		List<UserData> employeeDataList = new ArrayList();
		ResultSet resultSet = genericDaoImpl.getResultSet();
		PreparedStatement preparedStatement = genericDaoImpl.getPreparestatement();
		preparedStatement = connection.prepareStatement("select pay_slip_month,pay_slip_year,total_salary,\n"
				+ "(total_salary*0.16)Conveyance_Allowance ,(total_salary*0.32)HRA,(total_salary*0.16)Medical_Allowance,\n"
				+ "(total_salary+(total_salary*0.16)+(total_salary*0.32)+(total_salary*0.16))Total_Earnings,(total_salary*0.12)PF,(total_salary*0.012)ESIC,(200)TAX,\n"
				+ "((total_salary*0.12)+(total_salary*0.012)+200)Deduction,((total_salary+(total_salary*0.16)+(total_salary*0.32)+(total_salary*0.16))-((total_salary*0.12)+(total_salary*0.012)+200))Net_Amount \n"
				+ "from employee inner join payslip using(employee_sr) inner join company_details using(company_details_id) \n"
				+ " inner join designation using(designation_id) inner join company using(company_id)\n"
				+ "inner join employee_function using (employee_function_id) where employee_email=?");
		preparedStatement.setString(1, username);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			UserData userDetails = new UserData();
			userDetails.setPaySlipMonth(resultSet.getString(resultSet.getMetaData().getColumnName(1)));
			userDetails.setPaySlipYear(resultSet.getString(resultSet.getMetaData().getColumnName(2)));
			userDetails.setTotalSalary(resultSet.getDouble(resultSet.getMetaData().getColumnName(3)));
			userDetails.setConveyanceAllowance(resultSet.getDouble(resultSet.getMetaData().getColumnName(4)));
			userDetails.setHra(resultSet.getDouble(resultSet.getMetaData().getColumnName(5)));
			userDetails.setMedicalAllowance(resultSet.getDouble(resultSet.getMetaData().getColumnName(6)));
			userDetails.setTotalEarnings(resultSet.getDouble(resultSet.getMetaData().getColumnName(7)));
			userDetails.setPf(resultSet.getString(resultSet.getMetaData().getColumnName(8)));
			userDetails.setEsic(resultSet.getString(resultSet.getMetaData().getColumnName(9)));
			userDetails.setTax(resultSet.getString(resultSet.getMetaData().getColumnName(10)));
			userDetails.setDeduction(resultSet.getDouble(resultSet.getMetaData().getColumnName(11)));
			userDetails.setNetAmount(resultSet.getDouble(resultSet.getMetaData().getColumnName(12)));
			employeeDataList.add(userDetails);
		}
		return employeeDataList;
	}

}
