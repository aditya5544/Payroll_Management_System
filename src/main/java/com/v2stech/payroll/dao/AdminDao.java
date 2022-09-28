package com.v2stech.payroll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.v2stech.payroll.exception.AlreadExistException;
import com.v2stech.payroll.exception.DataNotExistedException;
import com.v2stech.payroll.model.PayslipForDatabase;
import com.v2stech.payroll.model.UserCredentialModel;
import com.v2stech.payroll.model.UserData;

/*
 * Admin dao class to contain JDBC logic
 * used HomeDao object to access methods
 */
@Repository
public class AdminDao {

	@Autowired
	HomeDao homeDaoImpl;

	@Autowired
	GenericDao genericDaoImpl;

	@Autowired
	private JdbcTemplate jdbcTemplate;
//
//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}

	private int empSr;
	private double totalSalary;
	private String month;
	private int year;

	@Autowired
	private Connection connection;

	/**
	 * @work Method to insert data through INSERT Button from admin insert page.
	 * @param payslip
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void insertIntoPayslip(PayslipForDatabase payslip) throws SQLException, ClassNotFoundException {
		PreparedStatement preparedStatement = genericDaoImpl.getPreparestatement();
		preparedStatement = connection.prepareStatement(
				"insert into payslip(employee_sr,total_salary,pay_slip_month,pay_slip_year)values((select employee_sr from employee where employee_id=?),?,?,?)");
		preparedStatement.setInt(1, payslip.getEmployeeId());
		preparedStatement.setDouble(2, payslip.getTotalSalary());
		preparedStatement.setString(3, payslip.getMonth());
		preparedStatement.setInt(4, payslip.getYear());
		preparedStatement.addBatch();
		preparedStatement.executeBatch();
		System.out.println("Data Inserted into Payslip successfully");
	}

	/**
	 * @work Method to view inserted data through VIEW button from Admin insert
	 *       Page.name
	 * @return method
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public PayslipForDatabase showInsertedData() throws SQLException, ClassNotFoundException {

		PreparedStatement preparedStatement = genericDaoImpl.getPreparestatement();
		ResultSet resultSet = genericDaoImpl.getResultSet();
		preparedStatement = connection.prepareStatement(
				"select employee_id ,pay_slip_month,pay_slip_year,total_salary from payslip inner join employee using(employee_sr) where employee_sr in(select employee_sr from employee where employee_id=?) and pay_slip_month=? and pay_slip_year=?;");
		preparedStatement.setInt(1, empSr);
		preparedStatement.setString(2, month);
		preparedStatement.setInt(3, year);
		System.out.println("Inserted Data Showing");
		resultSet = preparedStatement.executeQuery();
		PayslipForDatabase payslipListStore = new PayslipForDatabase();
		while (resultSet.next()) {
			payslipListStore.setEmployeeId(resultSet.getInt(resultSet.getMetaData().getColumnName(1)));
			payslipListStore.setMonth(resultSet.getString(resultSet.getMetaData().getColumnName(2)));
			payslipListStore.setYear(resultSet.getInt(resultSet.getMetaData().getColumnName(3)));
			payslipListStore.setTotalSalary(resultSet.getDouble(resultSet.getMetaData().getColumnName(4)));
		}
		return payslipListStore;
	}

	/**
	 * @work return object which will use to show data on playslip structure page
	 * @param payslipForDatabase
	 * @return object
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws DataNotExistedException
	 */
	public UserData searchPayslip(PayslipForDatabase payslipForDatabase)
			throws SQLException, ClassNotFoundException, DataNotExistedException {
		PreparedStatement preparedStatement = genericDaoImpl.getPreparestatement();
		ResultSet resultSet = genericDaoImpl.getResultSet();
		preparedStatement = connection.prepareStatement(
			"select employee_id,employee_name,designation_type,employee_function_types,pay_slip_month,pay_slip_year,\n"
			+ "location,employee_joining,employee_PAN,employee_UAN_no,employee_PF_no,employee_Bank_Details,ESI_No,PRAN_NO,total_salary,\n"
			+ "(total_salary*0.16)Conveyance_Allowance ,(total_salary*0.32)HRA,(total_salary*0.16)Medical_Allowance,\n"
			+ "(total_salary+(total_salary*0.16)+(total_salary*0.32)+(total_salary*0.16))Total_Earnings,(total_salary*0.12)PF,(total_salary*0.012)ESIC,(200)TAX,\n"
			+ "((total_salary*0.12)+(total_salary*0.012)+200)Deduction,((total_salary+(total_salary*0.16)+(total_salary*0.32)+(total_salary*0.16))-((total_salary*0.12)+(total_salary*0.012)+200))Net_Amount \n"
			+ "from employee inner join payslip using(employee_sr) inner join company_details using(company_details_id) \n"
			+ " inner join designation using(designation_id) inner join company using(company_id)\n"
			+ "inner join employee_function using (employee_function_id) where employee_sr in(select employee_sr from employee where employee_id=?) and pay_slip_month=? and pay_slip_year=?");
		preparedStatement.setInt(1, payslipForDatabase.getEmployeeId());
		preparedStatement.setString(2, payslipForDatabase.getMonth());
		preparedStatement.setInt(3, payslipForDatabase.getYear());
		System.out.println("Data Searched into Payslip successfully");
		resultSet = preparedStatement.executeQuery();
		if (!resultSet.isBeforeFirst()) {
			throw new DataNotExistedException("Data Not existed");
		} else {
			UserData userData = new UserData();
			while (resultSet.next()) {
				userData.setEmployeeId(resultSet.getInt(resultSet.getMetaData().getColumnName(1)));
				userData.setEmployeeName(resultSet.getString(resultSet.getMetaData().getColumnName(2)));
				userData.setDesignationType(resultSet.getString(resultSet.getMetaData().getColumnName(3)));
				userData.setFunctionTypes(resultSet.getString(resultSet.getMetaData().getColumnName(4)));
				userData.setPaySlipMonth(resultSet.getString(resultSet.getMetaData().getColumnName(5)));
				userData.setPaySlipYear(resultSet.getString(resultSet.getMetaData().getColumnName(6)));
				userData.setLocation(resultSet.getString(resultSet.getMetaData().getColumnName(7)));
				userData.setEmployeeJoining(resultSet.getString(resultSet.getMetaData().getColumnName(8)));
				userData.setPanNo(resultSet.getString(resultSet.getMetaData().getColumnName(9)));
				userData.setUanNo(resultSet.getString(resultSet.getMetaData().getColumnName(10)));
				userData.setPfNo(resultSet.getString(resultSet.getMetaData().getColumnName(11)));
				userData.setBankDetails(resultSet.getString(resultSet.getMetaData().getColumnName(12)));
				userData.setEsiNo(resultSet.getString(resultSet.getMetaData().getColumnName(13)));
				userData.setPranNo(resultSet.getString(resultSet.getMetaData().getColumnName(14)));
				userData.setTotalSalary(resultSet.getDouble(resultSet.getMetaData().getColumnName(15)));
				userData.setConveyanceAllowance(resultSet.getDouble(resultSet.getMetaData().getColumnName(16)));
				userData.setHra(resultSet.getDouble(resultSet.getMetaData().getColumnName(17)));
				userData.setMedicalAllowance(resultSet.getDouble(resultSet.getMetaData().getColumnName(18)));
				userData.setTotalEarnings(resultSet.getDouble(resultSet.getMetaData().getColumnName(19)));
				userData.setPf(resultSet.getString(resultSet.getMetaData().getColumnName(20)));
				userData.setEsic(resultSet.getString(resultSet.getMetaData().getColumnName(21)));
				userData.setTax(resultSet.getString(resultSet.getMetaData().getColumnName(22)));
				userData.setDeduction(resultSet.getDouble(resultSet.getMetaData().getColumnName(23)));
				userData.setNetAmount(resultSet.getDouble(resultSet.getMetaData().getColumnName(24)));
			}
			return userData;
		}
	}

	/**
	 * @work Delete data after clicking delete button from admin dashboard. without JDBCTemplate
	 * @param payslipModel
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws AlreadExistException
	 * @throws DataNotExistedException
	 * 
	 */

//	public void deleteFromPayslipp(PayslipForDatabase payslipModel)
//			throws ClassNotFoundException, SQLException, AlreadExistException, DataNotExistedException {
//		PreparedStatement preparedStatement = genericDaoImpl.getPreparestatement();
//		ResultSet resultSet = genericDaoImpl.getResultSet();
//		preparedStatement = connection.prepareStatement(
//				"delete from payslip where employee_sr in (select employee_sr from employee where employee_id=?) and pay_slip_month=? and pay_slip_year=?;");
//		preparedStatement.setInt(1, payslipModel.getEmployeeId());
//		preparedStatement.setString(2, payslipModel.getMonth());
//		preparedStatement.setInt(3, payslipModel.getYear());
//		int result = preparedStatement.executeUpdate();
//		if (result == 0) {
//			throw new DataNotExistedException("Data Not existed");
//		}
//	}

/**
 * @imp delete method already created but trying with jdbcTemplate
 * @param payslipModel
 * @throws ClassNotFoundException
 * @throws SQLException
 * @throws AlreadExistException
 * @throws DataNotExistedException
 */
	public void deleteFromPayslip(String empId,String month,String year)
			throws ClassNotFoundException, SQLException, AlreadExistException, DataNotExistedException {
		String query="delete from payslip where employee_sr in (select employee_sr from employee where employee_id="+empId+") and pay_slip_month="+"'"+month+"'"+" and pay_slip_year="+year+";";
		int result = jdbcTemplate.update(query);
		System.out.println("result: "+ result);
		if (result == 0) {
			throw new DataNotExistedException("Data Not existed");
		}
	}

	
	
	/**
	 * @work update data after clicking update button from admin dashboard.
	 * @param payslipModel
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws DataNotExistedException
	 */
	
//	public void updateChanges(PayslipForDatabase payslipModel)
//			throws ClassNotFoundException, SQLException, DataNotExistedException {
//		PreparedStatement preparedStatement = genericDaoImpl.getPreparestatement();
//		preparedStatement = connection.prepareStatement(
//				"update payslip set total_salary=? where employee_sr in(select employee_sr from employee where employee_id=?) and pay_slip_month=? and pay_slip_year=?;");
//		preparedStatement.setDouble(1, payslipModel.getTotalSalary());
//		preparedStatement.setInt(2, payslipModel.getEmployeeId());
//		preparedStatement.setString(3, payslipModel.getMonth());
//		preparedStatement.setInt(4, payslipModel.getYear());
//		if (payslipModel.getTotalSalary() == 0) {
//			throw new DataNotExistedException("Data not Existed");
//		} else {
//			preparedStatement.executeUpdate();
//			preparedStatement.close();
//		}
//
//	}
	
	//update with jdbc template
	public void updateChanges(PayslipForDatabase payslipModel)
			throws ClassNotFoundException, SQLException, AlreadExistException, DataNotExistedException {
		String query="update payslip set total_salary=? where employee_sr in(select employee_sr from employee where employee_id=?) and pay_slip_month=? and pay_slip_year=?;";
		if (payslipModel.getTotalSalary()==0) {
			throw new DataNotExistedException("Data Not existed");
		}
		else
		{
			jdbcTemplate.update(query,payslipModel.getTotalSalary(),payslipModel.getEmployeeId(),payslipModel.getMonth(),payslipModel.getYear());
		}
		
	}
	
	

	/**
	 * @work return arraylist to show name in Dropdwon.
	 * @return List
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws DataNotExistedException
	 */
	public List<UserCredentialModel> getEmployeesNameList()
			throws SQLException, ClassNotFoundException, DataNotExistedException {
		List<UserCredentialModel> getNameList = new ArrayList();
		ResultSet resultSet = genericDaoImpl.getResultSet();
		PreparedStatement preparedStatement = genericDaoImpl.getPreparestatement();
		preparedStatement = connection.prepareStatement("select employee_id,employee_name from employee;");
		resultSet = preparedStatement.executeQuery();
		if (!resultSet.isBeforeFirst()) {
			throw new DataNotExistedException("Data Not Existed");
		} else {
			while (resultSet.next()) {
				UserCredentialModel userNameModel = new UserCredentialModel();
				userNameModel.setId(resultSet.getInt(resultSet.getMetaData().getColumnName(1)));
				userNameModel.setName(resultSet.getString(resultSet.getMetaData().getColumnName(2)));
				getNameList.add(userNameModel);
			}
			return getNameList;
		}
	}

	/**
	 * @work return object to show current year into dropdown
	 * @return object
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws DataNotExistedException
	 */

	public PayslipForDatabase getCurrentYear() throws SQLException, ClassNotFoundException, DataNotExistedException {
		ResultSet resultSet = genericDaoImpl.getResultSet();
		java.sql.Statement statement = genericDaoImpl.getStatement();
		statement = connection.createStatement();
		String sql = "select year(current_date());";
		resultSet = statement.executeQuery(sql);
		PayslipForDatabase payslipModel = new PayslipForDatabase();
		while (resultSet.next()) {
			payslipModel.setYear(resultSet.getInt(resultSet.getMetaData().getColumnName(1)));
		}
		return payslipModel;
	}

	public Boolean checkExistedData(PayslipForDatabase payslip) throws SQLException, ClassNotFoundException {
		ResultSet resultSet = genericDaoImpl.getResultSet();
		PreparedStatement preparedStatement = genericDaoImpl.getPreparestatement();
		preparedStatement = connection.prepareStatement(
				"select * from payslip  where employee_sr in(select employee_sr from employee where employee_id=?) and pay_slip_month=? and pay_slip_year=?");
		preparedStatement.setInt(1, payslip.getEmployeeId());
		preparedStatement.setString(2, payslip.getMonth());
		preparedStatement.setInt(3, payslip.getYear());
		System.out.println("Fetching Existed Data");
		resultSet = preparedStatement.executeQuery();
		this.empSr = payslip.getEmployeeId();
		this.totalSalary = payslip.getTotalSalary();
		this.month = payslip.getMonth();
		this.year = payslip.getYear();
		if (!resultSet.isBeforeFirst()) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @work return object which will use to show data on playslip structure page
	 * @param payslipForDatabase
	 * @return object
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws DataNotExistedException
	 */

	public PayslipForDatabase getSalary(PayslipForDatabase payslipModel)
			throws SQLException, ClassNotFoundException, DataNotExistedException {
		ResultSet resultSet = genericDaoImpl.getResultSet();
		PreparedStatement preparedStatement = genericDaoImpl.getPreparestatement();
		preparedStatement = connection.prepareStatement(
				"select employee_sr ,pay_slip_month,pay_slip_year,total_salary from payslip where employee_sr in(select employee_sr from employee where employee_id=?)and pay_slip_month=? and pay_slip_year=?;");
		preparedStatement.setInt(1, payslipModel.getEmployeeId());
		preparedStatement.setString(2, payslipModel.getMonth());
		preparedStatement.setInt(3, payslipModel.getYear());
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			payslipModel.setTotalSalary(resultSet.getDouble(resultSet.getMetaData().getColumnName(4)));
		}
		return payslipModel;

	}

}
