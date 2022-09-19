package com.v2stech.payroll.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.v2stech.payroll.dao.GenericDao;
import com.v2stech.payroll.exception.AlreadExistException;
import com.v2stech.payroll.exception.DataNotExistedException;
import com.v2stech.payroll.model.PayslipForDatabase;
import com.v2stech.payroll.model.UserData;
import com.v2stech.payroll.service.AdminService;
import com.v2stech.payroll.service.HomeService;


/**
 * @author Aditya Kadam
 */
@RestController
public class AdminController {
	@Autowired
	private HomeService serviceImpl;
	@Autowired
	private GenericDao genericDaoImpl;
	@Autowired
	private AdminService adminServiceImpl;

	
	/**
	 * @work Method to insert data through INSERT Button from admin insert page.
	 * @mapping PostMapping
	 * @param payslip with @RequestBody to take data from request.
	 * @return String
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws AlreadExistException
	 */
	
	@PostMapping("/addData")
	public String inseration(@RequestBody PayslipForDatabase payslip)
			throws SQLException, ClassNotFoundException, AlreadExistException {
		Boolean existedDataStatus = serviceImpl.dataCheckExisted(payslip);
		if (Boolean.TRUE.equals(existedDataStatus)) {
			throw new AlreadExistException("Data Already Existed! Can't Insert!");
		} else {
			adminServiceImpl.insertData(payslip);
			return "Added Succesfully!";
		}
	}


	/**
	 * @work Method to view inserted data through VIEW button from Admin insert Page.
	 * @mapping GetMapping
	 * @return method
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@GetMapping("/insertionList")
	public PayslipForDatabase showingInsertedDataOnViewButtonClick()
			throws ClassNotFoundException, SQLException  {
		return adminServiceImpl.viewInsertedData();
	}

	
	/**
	 * @work method to show data on payslip structure page after clicking search button.
	 * @mapping PostMapping
	 * @method searchedDataintoPayslip-
	 * @param payslipModel
	 * @param modelAndView
	 * @return page through modelAndView
	 * @throws ClassNotFoundException
	 * @throws DataNotExistedException
	 * 
	 */
	@PostMapping("/searchData")
	public ModelAndView showDetailsOnPayslipStructurePage(@RequestBody PayslipForDatabase payslipModel,
			ModelAndView modelAndView) throws ClassNotFoundException, DataNotExistedException {
		UserData userData=new UserData();
		try {
			userData = adminServiceImpl.searchedDataintoPayslip(payslipModel);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		modelAndView.addObject("empData", userData);
		modelAndView.setViewName("DetailsOnPayslip");
		return modelAndView;
	}
	

	/**
	 * @work Delete data after clicking delete button from admin dashboard.
	 * @mapping PostMapping
	 * @param payslipModel used @RequestBody to take data from request.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws AlreadExistException
	 * @throws DataNotExistedException
	 */
	
//	@PostMapping("/dataDeletion")
//	public void deletion(@RequestBody PayslipForDatabase payslipModel) throws ClassNotFoundException, SQLException, AlreadExistException, DataNotExistedException {
//		adminServiceImpl.deleteData(payslipModel);
//	}
	

	//Delet functionality Trying with pathvarible
	@DeleteMapping ("/dataDeletion/{empId}/{month}/{year}")
	public void deletion(@PathVariable String empId,@PathVariable String month, @PathVariable String year) throws ClassNotFoundException, SQLException, AlreadExistException, DataNotExistedException {
		adminServiceImpl.deleteData(empId,month,year);
	}
	

	/*
	 * Method used get salary from inserted Data from Admin update page.
	 * Return type is Object.
	 * @GetMapping get page.
	 * @RequestBody to get Data from Payload/request.
	 * Throws ClassNotFoundExceptn, SQLEXception.
	 */
	@PostMapping("/dataForSalary")
	public PayslipForDatabase getSalaryofInsertedData(@RequestBody PayslipForDatabase payslipModel)
			throws ClassNotFoundException, SQLException, DataNotExistedException {
		return adminServiceImpl.salaryShowofInsertedData(payslipModel);
	}

	/**
	 * @work update data after clicking update button from admin dashboard.
	 * @mapping PostMapping
	 * @param payslipModel
	 * @param modelAndView
	 * @return String
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws DataNotExistedException
	 * @throws AlreadExistException 
	 */
	@PutMapping ("/updatedata")
	public String updateDataSalary(@RequestBody PayslipForDatabase payslipModel, ModelAndView modelAndView)
			throws ClassNotFoundException, SQLException, DataNotExistedException, AlreadExistException {
		adminServiceImpl.updatesalaryData(payslipModel);
		return "Updated Successfully!!";
	}
	


	/** 
	 * @work show insertion page after clicking INSERT button from admin dashboard
	 * @method employeesNameList
	 * @method getCurrntYear
	 * @param modelAndView
	 * @return page through modelAndView
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws DataNotExistedException
	 */
	@GetMapping("/accountantInsertion")
	public ModelAndView accountantInsertion(ModelAndView modelAndView) throws ClassNotFoundException, SQLException, DataNotExistedException {
		modelAndView.addObject("userList", adminServiceImpl.employeesNameList());
		modelAndView.addObject("dataYear", adminServiceImpl.getCurrntYear());
		modelAndView.setViewName("AdminInsertion");
		return modelAndView;
	}
	
	/**
	 * @work show updation page after clicking UPDATE button from admin dashboard
	 * @method employeesNameList
	 * @method getCurrntYear
	 * @param modelAndView
	 * @return modelandView
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws DataNotExistedException
	 */
	@GetMapping("/accountantUpdation")
	public ModelAndView accountantUpdation(ModelAndView modelAndView) throws ClassNotFoundException, SQLException, DataNotExistedException {
		modelAndView.addObject("userList", adminServiceImpl.employeesNameList());
		modelAndView.addObject("dataYear", adminServiceImpl.getCurrntYear());
		modelAndView.setViewName("AdminUpdation");
		return modelAndView;
	}

	/**
	 * @work show Search page after clicking Search button from admin dashboard
	 * @method employeesNameList
	 * @method getCurrntYear
	 * @param modelAndView
	 * @return modelAndView
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws DataNotExistedException
	 */
	@GetMapping("/accountantSearch")
	public ModelAndView accountantSearch(ModelAndView modelAndView) throws ClassNotFoundException, SQLException, DataNotExistedException {
		modelAndView.addObject("userList", adminServiceImpl.employeesNameList());
		modelAndView.addObject("dataYear", adminServiceImpl.getCurrntYear());
		modelAndView.setViewName("AdminSearch");
		return modelAndView;
	}

	/**
	 * @work show Delete page after clicking DELETE button from admin dashboard
	 * @method employeesNameList
	 * @method getCurrntYear
	 * @param modelAndView
	 * @return moelAndView
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws DataNotExistedException
	 */
	@GetMapping("/accountantDeletion")
	public ModelAndView accountantDeletion(ModelAndView modelAndView) throws ClassNotFoundException, SQLException, DataNotExistedException {
		modelAndView.addObject("userList", adminServiceImpl.employeesNameList());
		modelAndView.addObject("dataYear", adminServiceImpl.getCurrntYear());
		modelAndView.setViewName("AdminDeletion");
		return modelAndView;
	}


	
	/**
	 * @work Method used for go to Admin Dashboard page.
	 * @param modelAndView 
	 * @return ModelAndView
	 */
	@GetMapping("/back")
	public ModelAndView backToAdminDashbaord(ModelAndView modelAndView) {
		modelAndView.setViewName("AdminDashboard");
		return modelAndView;
	}
	
	/**
	 * @work method used to go back to admin search page
	 * @param modelAndView
	 * @return modelAndView
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws DataNotExistedException
	 */
	
	@GetMapping("/backToadminSearch")
	public ModelAndView backToAdminSearchPage(ModelAndView modelAndView) throws ClassNotFoundException, SQLException, DataNotExistedException {
		modelAndView.addObject("userList", adminServiceImpl.employeesNameList());
		modelAndView.addObject("dataYear", adminServiceImpl.getCurrntYear());
		
		modelAndView.setViewName("AdminSearch");
		return modelAndView;
	}

	
	/**
	 * @work method used to logout and go back to login page
	 * @param modelAndView
	 * @return modelAndView
	 */
	@GetMapping("employeePage/logout")
	public ModelAndView backToLoginPage(ModelAndView modelAndView) {
		modelAndView.setViewName("LoginPage");
		return modelAndView;
	}
}
