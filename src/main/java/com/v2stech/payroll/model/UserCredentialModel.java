package com.v2stech.payroll.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserCredentialModel {

	@NotEmpty(message = "Email Field Should not be Empty")
	@Pattern(regexp = "^[a-z]+[a-z0-9.+]+@[v2stech]+[.]{1}[A-Za-z]{2,}$", message = "Email is not in proper format(abc@v2stech.com)")
	private String username;
	@NotEmpty(message = "Password Field Should not be Empty")
	private String password;
	private String name;
	private int id;
	private String userType;

}
