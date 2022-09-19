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

	<section class="vh-80 gradient-custom">
		<div class="container py-4 h-50">

			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-12 col-md-8 col-lg-6 col-xl-5">
					<div class="card bg-dark text-white" style="border-radius: 1rem;">
						<div class="card-body p-4 text-center">
							<div class="text-center">
								<img src="https://v2stech.com/assets/images/logo.png"
									class="rounded" alt="iconCompany">
							</div>
							<div class="mb-md-5 mt-md-4 pb-5">
								<h2 class="fw-bold mb-2 text-uppercase text-white-50 mb-1">
									<spring:message code="login.header" />
								</h2>
								<div class="form-outline form-white mb-4">
									<div style="display: flex; flex-direction: row;">
										<label class="form-label" for="typeEmail"
											style="margin-right: 48px;">
											
											<spring:message code="login.email" />
											
											</label> <input type="text"
											id="email" class="form-control form-control-lg"
											style="height: 100%;" />
									</div>
									<span style="color:red" id="EmailError" class="error"></span>
								</div>

								<div class="form-outline form-white mb-4">
									<div style="display: flex; flex-direction: row;">
										<label class="form-label" for="typeEmail"
											style="margin-right: 20px;">
											
											<spring:message code="login.password" />
											
											</label> <input
											type="password" id="password"
											class="form-control form-control-lg" style="height: 100%;" />
									</div>
									<span style="margin-left: 38px; color:red" id="PasswordError" class="error"></sapn>
								</div>

								<div id="exceptionMessage" class="col-sm-12"
									style="display: none;">
									<div class="alert alert-danger">
										<span id="error"></span>
									</div>
								</div>
								<button class="btn btn-outline-light btn-lg px-5" type="submit"
									id="login">
									<spring:message code="login.button" />
									</button>
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