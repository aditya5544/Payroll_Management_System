<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="<c:url value="/static/css/loginPageStyle.css" />" />

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</head>

<body>

<div class="btn align-items-center">
		<a class="btn btn-outline-light btn-lg px-2" type="submit" href="back">Back</a>
	</div>
	<h1 style="text-align: center;">Update Salary</h1>

	<section class="vh-80 gradient-custom">
		<div class="container px-2 py-4 h-50">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-12 col-md-8 col-lg-6 col-xl-5">
					<div class="card bg-dark text-white" style="border-radius: 1rem;">
						<div class="card-body p-4 text-center">

							<div class="mb-md-5 mt-md-4 pb-4">

								<div class="form-outline form-white mb-4">
									<div style="display: flex; flex-direction: row;">
										<label class="form-label" for="typeMonth"
											style="margin-right: 50px; width: 50%;">Name</label> <select
											style="height: 48px; margin-right: 4px; width: 288%;"
											id="updateEmpId" class="form-select"
											aria-label="Default select example">
											<option selected disabled value="">Employee Name</option>
											<c:forEach items="${userList}" var="userdata">
												<option value="${userdata.id}">${userdata.name}</option>
											</c:forEach>
										</select>
									</div>
									<span style="margin-left: 38px; color:red" id="NameError" class="error"></span>	
								</div>

								<div class="form-outline form-white mb-4">
									<div style="display: flex; flex-direction: row;">
										<label class="form-label" for="typeMonth"
											style="margin-right: 50px; width: 50%;">Month</label> <select
											style="height: 48px; margin-right: 4px; width: 288%;" 
											id="updateMonth" class="form-select"
											aria-label="Default select example">
											<option disabled selected>Select Month</option>
											<option value="January">January</option>
											<option value="February">February</option>
											<option value="March">March</option>
											<option value="April">April</option>
											<option value="May">May</option>
											<option value="June">June</option>
											<option value="July">July</option>
											<option value="August">August</option>
											<option value="September">September</option>
											<option value="October">October</option>
											<option value="November">November</option>
											<option value="December">December</option>
										</select>
									</div>
									<span style="margin-left: 38px; color:red" id="MonthError" class="error"></span>	
								</div>
								

								<div class="form-outline form-white mb-4">
									<div style="display: flex; flex-direction: row;">
										<label class="form-label" for="typeMonth"
											style="margin-right: 50px; width: 50%;">Year</label> 
											<select onchange="salaryDetails(event)"
											style="height: 48px; margin-right: 4px; width: 288%;"
											id="updateYear" class="form-select"
											aria-label="Default select example">
											<option disabled selected>Select Year</option>
											<option value="${dataYear.year}">${dataYear.year}</option>
										</select>
									</div>
									<span style="margin-left: 38px; color: red" id="YearError"
										class="error"></span>
								</div>

								<div class="form-outline form-white mb-4">
									<div style="display: flex; flex-direction: row;">
										<label class="form-label" for="typeSalary"
											style="margin-right: 50px;">Salary</label> 
											<input type="text" id="updateSalary" class="form-control form-control-lg" />
									</div>
									<span style="margin-left: 38px; color:red" id="SalaryError" class="error"></span>	
								</div>

								<div id=exceptionMessage class="col-sm-12"
									style="display: none;">
									<div class="alert alert-danger">
										<span id="error"></span>
									</div>
								</div>
								<button class="btn btn-outline-light btn-lg px-2" type="submit"
									data-toggle="modal" data-target="#exampleModal" id="update">Submit</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript"
		src="<c:url value="/static/js/AdminScriptSecond.js" />"></script>
</body>

</html>