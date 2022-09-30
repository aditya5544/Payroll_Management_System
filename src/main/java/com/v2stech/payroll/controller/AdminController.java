package com.v2stech.payroll.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.v2stech.payroll.exception.AlreadExistException;
import com.v2stech.payroll.exception.DataNotExistedException;
import com.v2stech.payroll.model.PayslipForDatabase;
import com.v2stech.payroll.model.UserData;
import com.v2stech.payroll.service.AdminService;
import com.v2stech.payroll.service.HomeService;


/**
 * @author Aditya Kadam
 */

@Controller
public class AdminController {
	@Autowired
	private HomeService serviceImpl;

	@Autowired
	private AdminService adminServiceImpl;

	
	/**
	 * Insert data through INSERT Button from admin insert page.
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
	 * View inserted data through VIEW button from Admin insert Page.
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
	 * Show data on payslip structure page after clicking search button.
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
	 * Delete data after clicking delete button from admin dashboard.
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
	

	/**
	 * Delete functionality Trying with pathvarible
	 * @param empId
	 * @param month
	 * @param year
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws AlreadExistException
	 * @throws DataNotExistedException
	 */
	@DeleteMapping ("/dataDeletion/{empId}/{month}/{year}")
	public void deletion(@PathVariable String empId,@PathVariable String month, @PathVariable String year) throws ClassNotFoundException, SQLException, AlreadExistException, DataNotExistedException {
		adminServiceImpl.deleteData(empId,month,year);
	}
	
	/**
	 * Get salary from Admin update page.
	 * @param payslipModel
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws DataNotExistedException
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
	 * Show Insertion page after clicking Insert Button from Admin Dashboard.
	 * @param modelAndView
	 * @return ModelAndView
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws DataNotExistedException
	 */
	@GetMapping("adminPanel/accountantInsertion")
	public ModelAndView accountantInsertion(ModelAndView modelAndView) throws ClassNotFoundException, SQLException, DataNotExistedException {
		modelAndView.addObject("userList", adminServiceImpl.employeesNameList());
		modelAndView.addObject("dataYear", adminServiceImpl.getCurrntYear());
		modelAndView.setViewName("AdminInsertion");
		return modelAndView;
	}
	
	/**
	 * Show updation page after clicking UPDATE button from admin dashboard
	 * @method employeesNameList
	 * @method getCurrntYear
	 * @param modelAndView
	 * @return modelandView
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws DataNotExistedException
	 */
	@GetMapping("adminPanel/accountantUpdation")
	public ModelAndView accountantUpdation(ModelAndView modelAndView) throws ClassNotFoundException, SQLException, DataNotExistedException {
		modelAndView.addObject("userList", adminServiceImpl.employeesNameList());
		modelAndView.addObject("dataYear", adminServiceImpl.getCurrntYear());
		modelAndView.setViewName("AdminUpdation");
		return modelAndView;
	}

	/**
	 * Show Search page after clicking Search button from admin dashboard.
	 * @method employeesNameList
	 * @method getCurrntYear
	 * @param modelAndView
	 * @return modelAndView
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws DataNotExistedException
	 */
	@GetMapping("adminPanel/accountantSearch")
	public ModelAndView accountantSearch(ModelAndView modelAndView) throws ClassNotFoundException, SQLException, DataNotExistedException {
		modelAndView.addObject("userList", adminServiceImpl.employeesNameList());
		modelAndView.addObject("dataYear", adminServiceImpl.getCurrntYear());
		modelAndView.setViewName("AdminSearch");
		return modelAndView;
	}

	/**
	 * Show Delete page after clicking DELETE button from admin dashboard
	 * @method employeesNameList
	 * @method getCurrntYear
	 * @param modelAndView
	 * @return moelAndView
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws DataNotExistedException
	 */
	@GetMapping("adminPanel/accountantDeletion")
	public ModelAndView accountantDeletion(ModelAndView modelAndView) throws ClassNotFoundException, SQLException, DataNotExistedException {
		modelAndView.addObject("userList", adminServiceImpl.employeesNameList());
		modelAndView.addObject("dataYear", adminServiceImpl.getCurrntYear());
		modelAndView.setViewName("AdminDeletion");
		return modelAndView;
	}


	
	/**
	 * Method used to go back to admin search page
	 * @param modelAndView
	 * @return modelAndView
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws DataNotExistedException
	 */
	
	@GetMapping("adminPanel/backToadminSearch")
	public ModelAndView backToAdminSearchPage(ModelAndView modelAndView ,PayslipForDatabase payslipModel) throws ClassNotFoundException, SQLException, DataNotExistedException {
		modelAndView.addObject("userList", adminServiceImpl.employeesNameList());
		modelAndView.addObject("dataYear", adminServiceImpl.getCurrntYear());
		modelAndView.setViewName("AdminSearch");
		return modelAndView;
	}

	/**
	 * For logout and go back to login page
	 * @param modelAndView
	 * @return modelAndView
	 */
	@GetMapping("adminPanel/dashboard/logout")
	public ModelAndView backToLoginPage(ModelAndView modelAndView) {
		modelAndView.setViewName("LoginPage");
		return modelAndView;
	}
	
	
	/**
	 * Method used for go to Admin Dashboard page.
	 * @param modelAndView 
	 * @return ModelAndView
	 */
	@GetMapping("adminPanel/back")
	public ModelAndView backToAdminDashbaord(ModelAndView modelAndView) {
		modelAndView.setViewName("AdminDashboard");
		return modelAndView;
	}

	
}
