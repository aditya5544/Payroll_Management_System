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

<script type="text/javascript"
	src="<c:url value="/static/js/login.js" />"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</head>

<body>
<form action="logindata" method=post">
    <section class="vh-80 gradient-custom">
        <div class="container py-4 h-50">
          <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
              <div class="card bg-dark text-white" style="border-radius: 1rem;">
                <div class="card-body p-4 text-center">
      
                  <div class="mb-md-5 mt-md-4 pb-5">
                    <p class="text-white-50 mb-5">Employee Details</p>

                    <div class="form-outline form-white mb-4">
                      <input type="text" id="typeEmailX" class="form-control form-control-lg" />
                      <label class="form-label" for="typeEmployeeId">Employee Id</label>
                    </div>
      
                    <div class="form-outline form-white mb-4">
                      <input type="text" id="month" class="form-control form-control-lg" />
                      <label class="form-label" for="typeMonth">Month</label>
                    </div>
      
                    <div class="form-outline form-white mb-4">
                      <input type="text" id="year" name="year" class="form-control form-control-lg" />
                      <label class="form-label" for="typeMonth">Year</label>
                    </div>
                    <button class="btn btn-outline-light btn-lg px-5" type="submit">Submit</button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
     </form>
</body>

</html>