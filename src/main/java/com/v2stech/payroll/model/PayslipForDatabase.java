package com.v2stech.payroll.model;

import lombok.Data;

@Data
public class PayslipForDatabase {

	private int employeeId;
	private String month;
	private int year;
	private double totalSalary;

}
