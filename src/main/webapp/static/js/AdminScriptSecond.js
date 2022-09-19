$(document).ready(function() {
});


function dataNotInsertedStatus(field, message) {
	if (field == "" || field == null) {
		$("#notInsertedDataError").html("Data Not Inserted");
		$("#notInsertedDataError").show();
		$("#notInsertedDataError").delay(1000).fadeOut('slow')
		$("#exampleModal").modal('hide');
		flag = false;
	} else {
		$("#notInsertedDataError").hide();
		$("#exampleModal").modal('show');
		flag = true;
	}
	return flag;
}

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


function salaryDetails(event) {
	{
		var empId = $("#updateEmpId").val();
		var month = $("#updateMonth").val();
		var year = $("#updateYear").val();
		var data = {
			employeeId: empId,
			month: month,
			year: year
		}
		var url = "http://localhost:8080/payroll_Management_System/dataForSalary";
		$.ajax({
			type: 'POST',
			url: url,
			data: JSON.stringify(data),
			contentType: 'application/json',
			success: function(response) {
				$("#updateSalary").val(response.totalSalary);
			}
		});
	}
}

$("#view").on("click", function() {
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
	var empIdStatus = dataNotInsertedStatus(insertData.employeeId, "Name");
	var salaryStatus = dataNotInsertedStatus(insertData.totalSalary, "Salary");
	var monthStatus = dataNotInsertedStatus(insertData.month, "Month");
	var yearStatus = dataNotInsertedStatus(insertData.year, "Year");
	if (!empIdStatus && !salaryStatus && !monthStatus && !yearStatus) {
		return flag;
	}

	$.ajax({
		url: "http://localhost:8080/payroll_Management_System/insertionList",
		type: "GET",
		success: function(response) {
			$("#data").html("");
			$("#data").append("<tr><td>" + response.employeeId + "</td><td>" + response.month + "</td><td>" + response.year + "</td><td>" + response.totalSalary + "</td></tr>")
		}
	});
});



$("#update").on("click", function() {
	var empId = $("#updateEmpId").val();
	var month = $("#updateMonth").val();
	var year = $("#updateYear").val();
	var salary = $("#updateSalary").val();
	var data = {
		employeeId: empId,
		month: month,
		year: year,
		totalSalary: salary
	}
	var empIdStatus = status(data.employeeId, "Name");
	var monthStatus = status(data.month, "Month");
	var yearStatus = status(data.year, "Year");
	var salaryStatus = status(data.totalSalary, "Salary");
	if (salaryStatus) {
		varSalaryDegitStatus = NumberPatternStatus(data.totalSalary, "Salary");
	}
	if (yearStatus) {
		varYearDegitStatus=NumberPatternStatus(data.year, "Year");
	}
	if (!empIdStatus || !monthStatus || !yearStatus) {
		return flag;
	}

	var url = "http://localhost:8080/payroll_Management_System/updatedata";
	$.ajax({
		type: 'PUT',
		url: url,
		data: JSON.stringify(data),
		contentType: 'application/json',
		success: function(response) {
			alert(response);
		},
		error: function(message) {
			$('#error').html(message.responseText)
			$('#exceptionMessage').show();
			$("#exceptionMessage").delay(1000).fadeOut("slow");
		}
	});
});


