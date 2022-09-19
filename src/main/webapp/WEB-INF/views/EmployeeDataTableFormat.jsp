<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Data Table</title>
</head>
<style>


th, td {
	border: solid 3px black;
}

thead {
	background: black;
	color: white;
}

body {
	background: white;
}



</style>
<body>



	<table class="table user-table">
		<thead>
			<tr>
				<th>Month</th>
				<th>Year</th>
				<th>Total Salary</th>
				<th>Conveyance Allowance</th>
				<th>HRA</th>
				<th>Medical Allowance</th>
				<th>Total Earnings</th>
				<th>Deduction</th>
				<th>Net Amount</th>
			</tr>
		</thead>
		<tbody id="employeeList">
			<c:forEach items="${employeeList}" var="userdata">
				<tr>
					<td>${userdata.paySlipMonth}</td>
					<td>${userdata.paySlipYear}</td>
					<td>${userdata.totalSalary}</td>
					<td>${userdata.conveyanceAllowance}</td>
					<td>${userdata.hra}</td>
					<td>${userdata.medicalAllowance}</td>
					<td>${userdata.totalEarnings}</td>
					<td>${userdata.deduction}</td>
					<td>${userdata.netAmount}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a class="btn btn-primary btn-lg px-2" type="submit" href="backToEmployeeDashboard">Back</a>
</body>
</html>