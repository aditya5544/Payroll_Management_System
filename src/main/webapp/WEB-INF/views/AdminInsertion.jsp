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
		<a class="btn btn-outline-light btn-lg px-2" type="submit" href="back"><spring:message code="button.back" /></a>
	</div>
	<h1 style="text-align: center;"><spring:message code="insert.header" /></h1>
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
											style="margin-right: 50px; width: 50%;">
											
										<spring:message code="lable.name" />
											
											</label>
										
										<select
											style="height: 48px; margin-right: 4px; width: 288%;"
											id="empId" class="form-select"
											aria-label="Default select example">
											<option selected disabled value=""><spring:message code="placeholder.name" /> </option>
											<c:forEach items="${userList}" var="userdata">
												<option value="${userdata.id}">${userdata.name}</option>
											</c:forEach>
										</select>
									</div>
									<span style="margin-left: 38px; color:red" id="NameError" class="error"></span>
								</div>

								<div class="form-outline form-white mb-4">
									<div style="display: flex; flex-direction: row;">
										<label class="form-label" for="typeSalary"
											style="margin-right: 50px;"><spring:message code="lable.salary" /></label> <input type="text"
											id="salary" class="form-control form-control-lg" />
									</div>
									<span style="margin-left: 38px; color:red" id="SalaryError" class="error"></span>
								</div>

								<div class="form-outline form-white mb-4">
									<div style="display: flex; flex-direction: row;">
										<label class="form-label" for="typeMonth"
											style="margin-right: 50px; width: 50%;"><spring:message code="lable.month" /></label> <select
											style="height: 48px; margin-right: 4px; width: 288%;"
											id="month" class="form-select"
											aria-label="Default select example">
											<option  disabled selected><spring:message code="placeholder.month" /></option>
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
											style="margin-right: 50px; width: 50%;"><spring:message code="lable.year" /></label> 
											<select
											style="height: 48px; margin-right: 4px; width: 288%;"
											id="year" class="form-select"
											aria-label="Default select example">
											<option disabled selected><spring:message code="placeholder.year" /></option>
											<option value="${dataYear.year}">${dataYear.year}</option>
										</select>
									</div>
									<span style="margin-left: 38px; color: red" id="YearError"
										class="error"></span>
								</div>
								
								
								
								
								
								
								<div id="exceptionMessageAlready" class="col-sm-12"
									style="display: none;">
									<div class="alert alert-danger">
										<span id="errorAlready"></span>
									</div>
								</div>
							<span style="margin-left: 38px; color:red" id="notInsertedDataError" class="error"></span>
							<br>
								<button class="btn btn-outline-light btn-lg px-2" type="submit"
									id="insert"><spring:message code="button.insert" /></button>
								<button class="btn btn-outline-light btn-lg px-2"
									type="submitView" id="view"><spring:message code="button.view" /></button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<table class="table user-table">
					<thead>
						<tr>
							<th><spring:message code="table.head.empid" /></th>
							<th><spring:message code="table.head.month" /></th>
							<th><spring:message code="table.head.year" /></th>
							<th><spring:message code="table.head.salary" /></th>
						</tr>
					</thead>
					<tbody id="data"></tbody>
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="<c:url value="/static/js/AdminScript.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/static/js/AdminScriptSecond.js" />"></script>
</body>

</html>

