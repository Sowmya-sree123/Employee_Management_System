<%@page import="com.employee.entity.EmployeeDetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%EmployeeDetails employeeDetails=(EmployeeDetails)request.getAttribute("update"); %>
<form action="updateddetails">
<input value=<%=employeeDetails.getId() %> hidden="true" name="id">
<br>
<input value=<%=employeeDetails.getName() %> name="name">
<br>
<input value=<%=employeeDetails.getEmailid() %> name="emailid">
<br>
<input value=<%=employeeDetails.getDeptno() %> name="deptno">
<br>
<input value=<%=employeeDetails.getSalary() %> name="salary">
<br>
<input value=<%=employeeDetails.getPassword() %> name="password">
<br>
<input type="submit">
</form>

</body>
</html>