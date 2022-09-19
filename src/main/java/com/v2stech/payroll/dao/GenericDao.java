package com.v2stech.payroll.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GenericDao {
	
	

	@Autowired
	private Connection connect ;
	
	
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	
	


	public Statement getStatement() throws ClassNotFoundException {
		try {
			if (statement == null)
			{
				return statement = connect.createStatement();
			}
				
		} catch (SQLException e) {
		}
		return statement;
	}


	public PreparedStatement getPreparestatement() throws ClassNotFoundException {
		return preparedStatement;
	}
	
	public ResultSet getResultSet() throws ClassNotFoundException {
		return resultSet;
	}

}
