package com.v2stech.payroll.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HomeDao {

	@Autowired
	GenericDao genericDaoImpl;
	
	private String username;
	

	/*
	 * Boolean method to get result that given data is available in database or not
	 */
	
	
	
//public boolean login(UserCredentialModel userCredentialModel) throws SQLException, ClassNotFoundException {
//		
//		Connection connection = genericDaoImpl.getConnection();
//		ResultSet resultSet = genericDaoImpl.getResultSet();
//		PreparedStatement preparedStatement = genericDaoImpl.getPreparestatement();
//		preparedStatement = connection.prepareStatement(
//				"select * from employee where employee_email=? and employee_password=?");	
//		preparedStatement.setString(1, userCredentialModel.getUsername());
//		preparedStatement.setString(2, userCredentialModel.getUser_password());
//		resultSet = preparedStatement.executeQuery();
//		if (!resultSet.isBeforeFirst()) {
//			return false;
//		}
//		else
//		{
//		return true;
//		}
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Autowired
//	private DataSource dataSource;
//	
//	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}
//	
//	
//	
//	
//	
//	public void close() throws ClassNotFoundException, SQLException {
//		ResultSet resultSet=genericDaoImpl.getResultSet();
//		Statement statement=genericDaoImpl.getStatement();
//		Connection connection =dataSource.getConnection();
//
//		try {
//			if (resultSet != null) {
//				resultSet.close();
//			}
//
//			if (statement != null) {
//				statement.close();
//			}
//
//			if (connection != null) {
//				connection.close();
//			}
//		} catch (Exception e) {
//
//		}
//	}

}
