package com.v2stech.payroll.model;

import lombok.Data;

@Data
public class UserData {

	private String companyName;
	private String companyAddress;
	private String companyCIN;
	private String companyWebsite;
	private int employeeId;
	private String employeeName;
	private String designationType;
	private String functionTypes;
	private String paySlipMonth;
	private String paySlipYear;
	private String location;
	private String employeeJoining;
	private String panNo;
	private String uanNo;
	private String pfNo;
	private String bankDetails;
	private String esiNo;
	private String pranNo;
	private double totalSalary;
	private double conveyanceAllowance;
	private double hra;
	private double medicalAllowance;
	private double totalEarnings;
	private double deduction;
	private double netAmount;
	private String pf;
	private String esic;
	private String tax;
	
}
