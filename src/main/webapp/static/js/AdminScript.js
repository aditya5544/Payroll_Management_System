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


function NumberPatternStatus(field, message) {
	var NumberRegex = new RegExp('^[0-9]*$');
	if (!NumberRegex.test(field)) {
		$("#" + message + "Error").html("Required only numeric");
		$("#" + message + "Error").show();
		flag = false;
	} else {
		$("#" + message + "Error").hide();
		flag = true;
	}
	return flag;
}


$("#insert").on("click", function() {
	var empId = $("#empId").val();
	var salary = $("#salary").val();
	var month = $("#month").val();
	var year = $("#year").val();
	var insertData = {
		employeeId: empId,
		totalSalary: salary,
		month: month,
		year: year
	};
	var empIdStatus = status(insertData.employeeId, "Name");
	var salaryStatus = status(insertData.totalSalary, "Salary");
	var monthStatus = status(insertData.month, "Month");
	var yearStatus = status(insertData.year, "Year");

	if (salaryStatus) {
		var numberSalaryStatus = NumberPatternStatus(insertData.totalSalary, "Salary");
	}
	if (yearStatus) {
		var numberYearStatus = NumberPatternStatus(insertData.year, "Year");
	}
	if (!empIdStatus || !salaryStatus || !monthStatus || !yearStatus) {
		return;
	}

	$.ajax({
		url: "http://localhost:8080/payroll_Management_System/addData",
		type: 'POST',
		data: JSON.stringify(insertData),
		contentType: 'application/json',
		success: function(response) {
			alert(response);
		},
		error: function(message) {
			$('#errorAlready').html(message.responseText)
			$('#exceptionMessageAlready').show();
			$("#exceptionMessageAlready").delay(1000).fadeOut("slow");
		}
	});
});



$("#delete").on("click", function() {
	var empId = $("#deleteEmpId").val();
	var month = $("#deleteMonthId").val();
	var year = $("#deleteYearId").val();
	var deleteData = {
		employeeId: empId,
		month: month,
		year: year
	};
	var empIdStatus = status(deleteData.employeeId, "Name");
	var monthStatus = status(deleteData.month, "Month");
	var yearStatus = status(deleteData.year, "Year");

	if (yearStatus) {
		var yearNumberstatus = NumberPatternStatus(deleteData.year, "Year");
	}
	if (!empIdStatus || !monthStatus || !yearStatus) {
		return flag;
	}
	$.ajax({
		url: "http://localhost:8080/payroll_Management_System/dataDeletion/"+empId+"/"+month+"/"+year,
		type: 'DELETE', 
		data: JSON.stringify(deleteData),
		contentType: 'application/json',
		success: function() {
			alert("Successfully");
		},
		error: function(message) {
			$('#error').html(message.responseText)
			$('#exceptionMessage').show();
			$("#exceptionMessage").delay(1000).fadeOut("slow");
		}
	});
});



$("#searchSubmit").on("click", function() {
	var empId = $("#searchEmpId").val();
	var month = $("#searchMonth").val();
	var year = $("#searchYear").val();
	var searchData = {
		employeeId: empId,
		month: month,
		year: year
	};

	var empidStatus = status(searchData.employeeId, "Name");
	var monthStatus = status(searchData.month, "Month");
	var yearStatus = status(searchData.year, "Year");


	if (yearStatus) {
		var yearNumberstatus = NumberPatternStatus(searchData.year, "Year");
	}
	if (!empidStatus || !monthStatus || !yearStatus) {
		return flag
	}

	$.ajax({
		url: "http://localhost:8080/payroll_Management_System/searchData",
		type: "POST",
		data: JSON.stringify(searchData),
		contentType: 'application/json',
		success: function(data) {
			$("body").html(data)

		},
		error: function(message) {
			$('#error').html(message.responseText)
			$('#exceptionMessage').show();
			$("#exceptionMessage").delay(1000).fadeOut("slow");
		}
	});
});





