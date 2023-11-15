<%@page import="com.valtech.training.employeedepartmentspringboot.models.EmployeeModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add or Edit Employee</title>
</head>
<body>
	<h2>Fill Particular Employee Details</h2>
	<% EmployeeModel employee =(EmployeeModel) request.getAttribute("employee"); %>
	<form method="post" action="save">
		<table>
			<tr>
				<td>Employee Id</td>
				<td><input type="text" disabled="disabled" name="id" /></td>
			</tr>
			<tr>
				<td>Employee Name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input type="text" name="age" /></td>
			</tr>
			<tr>
				<td>Experience</td>
				<td><input type="text" name="experience" /></td>
			</tr>
			<tr>
				<td>Seniority</td>
				<td><input type="text" name="seniority"/></td>
			</tr>
			<tr>
				<td>Salary</td>
				<td><input type="text" name="salary"/></td>
			</tr>
			<tr>
				<td>Department Id</td>
				<td><input type="text" name="department"/></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Add Employee" /> 
				<input type="submit" name="cancel" value="cancel" /></td>
			</tr>

		</table>
	</form>
</body>
</html>