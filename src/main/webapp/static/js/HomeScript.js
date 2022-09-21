$(document).ready(function() {
});

function status(field, message) {
	if (field == "" || field == null) {
		$("#" + message + "Error").html(message + " Field is Required");
		$("#" + message + "Error").show();
		flag = false;
	} else {
		$("#" + message + "Error").hide();
		flag = true;
	}
	return flag;
}

function emailPatternStatus(field,message) {
	var EmailRegex = new RegExp('^[a-z]+[a-z0-9.+]+@[v2stech]+[.]{1}[A-Za-z]{2,}$');
	if (!EmailRegex.test(field)) {
		$("#" + message + "Error").html(message+" Formate is not matching");
		$("#" + message + "Error").show();
		flag = false;
	} else {
		$("#" + message + "Error").hide();
		flag = true;
	}
	return flag;
}



$("#login").on("click", function() {
	var email = $("#email").val();
	var password = $("#password").val();
	var loginData = {
		username: email,
		password: password
	}
	var emailStatus = status(loginData.username, "Email");
	var passwordStatus = status(loginData.password, "Password");
	if(emailStatus)
	{
		var emailPattern = emailPatternStatus(loginData.username, "Email");
	}
	if (!emailStatus || !passwordStatus || !emailPattern) {
		return;
	}
	

	var url = "http://localhost:8080/payroll_Management_System/loginCredential";
	$('#emailError').html("");
	$('#passwordError').html("");
	$.ajax({
		type: 'POST',
		url: url,
		data: JSON.stringify(loginData),
		contentType: 'application/json',
		success: function(data) {
			/*$("body").html(data)*/
			if (data === "e") {
				window.location.href = "http://localhost:8080/payroll_Management_System/employeePage/"+email;
			}
			else {
				window.location.href = "http://localhost:8080/payroll_Management_System/adminPage/"+email
			}
		},
		error: function(message) {
			$('#error').html(message.responseText)
			$('#exceptionMessage').show();
			$("#exceptionMessage").delay(1000).fadeOut("slow");
			$('#emailError').html(message.responseJSON.username);
			$('#passwordError').html(message.responseJSON.password);
		}

	});
});


$("#viewEmployeeData").on("click", function() {
	$.ajax({
		url: "http://localhost:8080/payroll_Management_System/viewEmployeeAllData",
		type: "GET",
		contentType: 'application/json',
		success: function(data) {
			$("body").html(data)
		}
	});

});