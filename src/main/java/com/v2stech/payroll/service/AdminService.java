package com.v2stech.payroll.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.v2stech.payroll.dao.AdminDao;
import com.v2stech.payroll.exception.AlreadExistException;
import com.v2stech.payroll.exception.DataNotExistedException;
import com.v2stech.payroll.model.PayslipForDatabase;
import com.v2stech.payroll.model.UserCredentialModel;
import com.v2stech.payroll.model.UserData;

@Service
public class AdminService {

	@Autowired
	AdminDao adminDaoImpl;
		
	/**
	 * @work Method to insert data through INSERT Button from admin insert page.
	 * @param payslip
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void insertData(PayslipForDatabase payslip) throws ClassNotFoundException, SQLException {
		adminDaoImpl.insertIntoPayslip(payslip);

	}
	
	/**
	 * @work Method to view inserted data through VIEW button from Admin insert Page.
	 * @return method
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public PayslipForDatabase viewInsertedData() throws ClassNotFoundException, SQLException {
		return adminDaoImpl.showInsertedData();
	}


	/**
	 * @work return object which will use to show data on playslip structure page
	 * @param payslipForDatabase
	 * @return object
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws DataNotExistedException
	 */
	public UserData searchedDataintoPayslip(PayslipForDatabase payslipForDatabase)
			throws ClassNotFoundException, SQLException, DataNotExistedException {
		return adminDaoImpl.searchPayslip(payslipForDatabase);
	}
	
	
	
	/**
	 * @work Delete data after clicking delete button from admin dashboard.
	 * @param payslipModel
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws DataNotExistedException
	 * @throws AlreadExistException
	 */
//	public void deleteData(PayslipForDatabase payslipModel)
//			throws ClassNotFoundException, SQLException, DataNotExistedException, AlreadExistException {
//		adminDaoImpl.deleteFromPayslip(payslipModel);
//	}
	
	
	
	public void deleteData(String empId,String month,String year)
			throws ClassNotFoundException, SQLException, DataNotExistedException, AlreadExistException {
		adminDaoImpl.deleteFromPayslip( empId, month, year);
	}
	
	

	
	/**
	 * @work update data after clicking update button from admin dashboard.
	 * @param payslip
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws DataNotExistedException
	 */
	
//	public void updatesalaryData(PayslipForDatabase payslip)
//			throws ClassNotFoundException, SQLException, DataNotExistedException {
//		adminDaoImpl.updateChanges(payslip);
//	}
	
	
	public void updatesalaryData(PayslipForDatabase payslipModel)
			throws ClassNotFoundException, SQLException, DataNotExistedException, AlreadExistException {
		adminDaoImpl.updateChanges(payslipModel);
	}
	
	
	
	/**
	 * @work return arraylist to show name in Dropdwon.
	 * @return arraylist to show name in Dropdwon.
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws DataNotExistedException
	 */
	public List<UserCredentialModel> employeesNameList()
			throws SQLException, ClassNotFoundException, DataNotExistedException {
		return adminDaoImpl.getEmployeesNameList();
	}



	/**
	 * @work return object to show current year into dropdown
	 * @return object
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws DataNotExistedException
	 */
	public PayslipForDatabase getCurrntYear() throws ClassNotFoundException, SQLException, DataNotExistedException {
		return adminDaoImpl.getCurrentYear();
	}

	public PayslipForDatabase salaryShowofInsertedData(PayslipForDatabase payslip)
			throws ClassNotFoundException, SQLException, DataNotExistedException {
		return adminDaoImpl.getSalary(payslip);
	}

	public ModelAndView checker(UserCredentialModel userCread,ModelAndView modelandView)  {
		if (!userCread.getUserType().equalsIgnoreCase("Admin")) {
			modelandView.setViewName("LoginPage");
			return modelandView;
		}
		return null;
	}
	
	
	
	

}
