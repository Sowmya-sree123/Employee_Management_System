<%@page import="com.employee.entity.EmployeeDetails"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>All Employee Details</h1>
<%
List<EmployeeDetails> list=(List<EmployeeDetails>)request.getAttribute("listofemployeedetails");
%>
<table>
<tr>
<th>Name</th>
<th>Emailid</th>
<th>Salary</th>
<th>Deptno</th>
</tr>

<%for(EmployeeDetails emp:list) 
{
%>
<tr>
<td><%=emp.getName() %></td>
<td><%=emp.getEmailid() %></td>
<td><%=emp.getSalary() %></td>
<td><%=emp.getDeptno() %></td>
<td>
<form action="deletebyid">
<input value=<%=emp.getId() %> hidden="true" name="empid">
<input type="submit" value="DELETE">
</form>
</td>
<td>
<form action="update">
<input value=<%=emp.getId() %> hidden="true" name="id">
<input type="submit" value="UPDATE">
</form>
</td>
</tr>
<%} %>
</table>
</center>
</body>
</html>