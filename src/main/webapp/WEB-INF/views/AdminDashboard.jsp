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

<body style="margin-top: 20px">

<a class="btn btn-outline-light btn-lg px-2 float-right" type="submit" href="dashboard/logout" style="margin-left:20px">
<spring:message code="adminDashboard.button.logout" />
</a>
<h4 style="float:right ">Hi ${sessionUser.username}</h4>

	<section class="vh-80 gradient-custom">
		<div class="container px-2 py-4 h-50">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-12 col-md-8 col-lg-6 col-xl-5">
					<div class="card bg-dark text-white" style="border-radius: 1rem;">
						<div class="card-body p-4 text-center">
							<div class="mb-md-5 mt-md-4 pb-4">
								<a class="btn btn-outline-light  btn-lg px-2 mb-4" type="submit"
			                        id="insert"  style="width:100% !important" href="accountantInsertion"><spring:message code="adminDashboard.button.insert" /></a><br>
			                    <a class="btn btn-outline-light btn-lg px-2 mb-4" type="submit"
			                        id="update" style="width:100% !important" href="accountantUpdation"><spring:message code="adminDashboard.button.update" /></a><br>
			                    <a class="btn btn-outline-light btn-lg px-2 mb-4" type="submit"
			                        id="delete" style="width:100% !important" href="accountantDeletion"><spring:message code="adminDashboard.button.delete" /></a><br>
			                    <a class="btn btn-outline-light btn-lg px-2 mb-4" type="submit"
			                        id="search" style="width:100% !important" href="accountantSearch"><spring:message code="adminDashboard.button.search" /></a><br>
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