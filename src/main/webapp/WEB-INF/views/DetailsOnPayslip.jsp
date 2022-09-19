<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pal slip Structure</title>
<link rel="stylesheet" href="<c:url value="/static/css/PayslipStruture.css" />" />
</head>
<body>
    <div class="main">
        <div class="formtable1">
            <h1>V2STech Solutions Pvt Ltd</h1>
            <h2>Payslip</h2>
            <table>
                <tr>
                    <td>
                        <strong><label> Id</label></strong>
                        <input type="text" id="empid" name="empid" value="${empData.employeeId}"/>
                    </td>
                    <td>
                        <strong><label for="fname">Name </label></strong>
                        <input type="text" id="empname" name="empname" value="${empData.employeeName}"/>
                    </td>
                    <td>
                        <strong><label for="fname">Designation</label></strong>
                        <input type="text" id="desig" name="desig" value="${empData.designationType}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <strong><label>Function</label></strong>
                        <input type="text" id="function" name="function" value="${empData.functionTypes}"/>
                    </td>
                    <td>
                        <strong><label for="fname">Month</label></strong>
                        <input type="text" id="month" name="month" value="${empData.paySlipMonth}"/>
                    </td>
                    <td>
                        <strong><label for="fname">year </label></strong>
                        <input type="text" id="year" name="year" value="${empData.paySlipYear}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <strong><label>Location</label></strong>
                        <input type="text" id="location" name="location" value="${empData.location}"/>
                    </td>
                    <td>
                        <strong><label for="fname">Joing Date</label></strong>
                        <input type="text" id="joingdate" name="joingdate" value="${empData.employeeJoining}"/>
                    </td>
                    <td>
                       <strong> <label for="fname">Pan </label></strong>
                        <input type="text" id="pan" name="pan" value="${empData.panNo}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <strong><label>UAN No</label></strong>
                        <input type="text" id="uan" name="uan" value="${empData.uanNo}"/>
                    </td>
                    <td>
                        <strong><label for="fname">PF No</label></strong>
                        <input type="text" id="pf" name="pf" value="${empData.pfNo}"/>
                    </td>
                    <td>
                        <strong><label for="fname">Bank Details </label></strong>
                        <input type="text" id="bank" name="bank" value="${empData.bankDetails}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <strong><label>ESI No</label></strong>
                        <input type="text" id="esino" name="esino" value="${empData.esiNo}"/>
                    </td>
                    <td>
                        <strong><label for="fname">PRAN No</label></strong>
                        <input type="text" id="pranno" name="pranno" value="${empData.pranNo}"/>
                    </td>
                    <td>
                       <strong><label for="fname">Total Salary</label></strong>
                        <input type="text" id="totalsal" name="totalsal" value="${empData.totalSalary}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <strong><label>Conveyance ALW</label></strong>
                        <input type="text" id="conallow" name="conallow" value="${empData.conveyanceAllowance}"/>
                    </td>
                    <td>
                        <strong><label for="fname">HRA</label></strong>
                        <input type="text" id="hra" name="hra" value="${empData.hra}"/>
                    </td>
                    <td>
                       <strong> <label for="fname">Medical ALW</label></strong>
                        <input type="text" id="medallow" name="medallow" value="${empData.medicalAllowance}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <strong><label>Total Earnings</label></strong>
                        <input type="text" id="earn" name="earn" value="${empData.totalEarnings}"/>
                    </td>
                    <td>
                        <strong><label for="fname">Deduction</label></strong>
                        <input type="text" id="deduction" name="deduction" value="${empData.deduction}"/>
                    </td>
                    <td>
                        <strong><label for="fname">Net Amount</label></strong>
                        <input type="text" id="netamt" name="netamt" value="${empData.netAmount}"/>
                    </td>
                </tr>
            </table>
        </div>
    </div>
    <a class="btn btn-lg px-2" type="submit" href="backToadminSearch">Back</a>
</body>
</body>
</html>


