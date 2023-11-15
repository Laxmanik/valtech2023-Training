<%@page import="com.valtech.training.employeedepartmentspringboot.models.DepartmentModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Department List</title>
</head>
<body>
	<h2 align="center">Department List</h2>
	<%
	List<DepartmentModel> departments = (List<DepartmentModel>) request.getAttribute("departments");
	%>
	<table border="1" align="center">
		<tr>
			<th>Department Id</th>
			<th>Department Name</th>
			<th>Department Location</th>
		</tr>

		<c:forEach var="department" items="${departments}">
			<%
			request.setAttribute("departments", departments);
			%>
			<tr>
				<td>${department.deptId}</td>
				<td>${department.deptName}</td>
				<td>${department.deptLocation}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>