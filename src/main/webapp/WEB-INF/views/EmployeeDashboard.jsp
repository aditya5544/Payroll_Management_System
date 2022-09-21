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
<h4 style="float:right">hi ${sessionUser.username} </h4>
<a class="btn btn-outline-light btn-lg px-2 float-right" type="submit" href="logout">Log Out</a>
	<section class="vh-80 gradient-custom">
		<div class="container px-2 py-4 h-50">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-12 col-md-8 col-lg-6 col-xl-5">
					<div class="card bg-dark text-white" style="border-radius: 1rem;">
						<div class="card-body p-4 text-center">
							<div class="mb-md-5 mt-md-4 pb-4">
								<input type="text" id="Id" value="${userData.id}"
									class="form-control form-control-lg" /> <br> <input
									type="text" id="name" value="${userData.name}"
									class="form-control form-control-lg" />
									<br>
								<button class="btn btn-outline-light btn-lg px-2"
									type="submit" id="viewEmployeeData" >All Pay slips</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	<script type="text/javascript"
		src="<c:url value="/static/js/HomeScript.js" />"></script>
</body>
</html>