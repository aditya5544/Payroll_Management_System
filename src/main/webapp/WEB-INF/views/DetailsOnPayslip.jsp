<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</head>

<body>
    <div class="main bg-white text-center">
        <div class="formtable1">
            <div class="headerbody">
                <h1>V2STech Solutions Pvt Ltd</h1>
                <h2>Payslip</h2>
            </div>
            <div class="container text-center">
                <div class="form-group row">
                    <label for="id" class="col-sm-1 col-form-label">Id</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="empid" value="${empData.employeeId}">
                    </div>

                    <label for="name" class="col-sm-1 col-form-label">Name</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="empname" value="${empData.employeeName}">
                    </div>

                    <label for="desig" class="col-sm-1 col-form-label">Designation</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="desig" value="${empData.designationType}">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="function" class="col-sm-1 col-form-label">Function</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="function" value="${empData.functionTypes}">
                    </div>

                    <label for="month" class="col-sm-1 col-form-label">Month</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="month" value="${empData.paySlipMonth}">
                    </div>

                    <label for="year" class="col-sm-1 col-form-label">Year</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="year" value="${empData.paySlipYear}">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="location" class="col-sm-1 col-form-label">Location</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="location" value="${empData.location}">
                    </div>

                    <label for="jdate" class="col-sm-1 col-form-label">Joining Date</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="joingdate" value="${empData.employeeJoining}">
                    </div>

                    <label for="pan" class="col-sm-1 col-form-label">Pan</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="pan" value="${empData.panNo}">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="uan" class="col-sm-1 col-form-label">UAN No</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="uan" value="${empData.uanNo}">
                    </div>

                    <label for="pfno" class="col-sm-1 col-form-label">PF No</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="pf" value="${empData.pfNo}">
                    </div>

                    <label for="bankDetail" class="col-sm-1 col-form-label">Bank Details</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="bank" value="${empData.bankDetails}">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="esiNo" class="col-sm-1 col-form-label">ESI No</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="esino" value="${empData.esiNo}">
                    </div>

                    <label for="pran" class="col-sm-1 col-form-label">PRAN NO</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="pranno" value="${empData.pranNo}">
                    </div>

                    <label for="basicSalary" class="col-sm-1 col-form-label">Basic Salary</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="totalsal" value="${empData.totalSalary}">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="convALW" class="col-sm-1 col-form-label">Conv. ALW</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="conallow" value="${empData.conveyanceAllowance}">
                    </div>

                    <label for="hra" class="col-sm-1 col-form-label">HRA</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="hra" value="${empData.hra}">
                    </div>

                    <label for="medALW" class="col-sm-1 col-form-label">Med. ALW</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="medallow" value="${empData.medicalAllowance}">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="totalEarn" class="col-sm-1 col-form-label">Total Earnings</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="earn" value="${empData.totalEarnings}">
                    </div>

                    <label for="pf" class="col-sm-1 col-form-label">PF Contribution</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="pfContro" value="${empData.pf}" >
                    </div>

                    <label for="esic" class="col-sm-1 col-form-label">ESIC</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="esic" value="${empData.esic}">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="tax" class="col-sm-1 col-form-label">TAX</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="earn" value="${empData.tax}">
                    </div>

                    <label for="deduction" class="col-sm-1 col-form-label">Deduction</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="deduction" value="${empData.deduction}">
                    </div>

                    <label for="netAmt" class="col-sm-1 col-form-label">Net Amount</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="netamt" value="${empData.netAmount}">
                    </div>
                </div>


            </div>
            <a class="btn btn-primary btn-lg px-2" type="submit" href="backToadminSearch">Back</a>

</body>
</html>


