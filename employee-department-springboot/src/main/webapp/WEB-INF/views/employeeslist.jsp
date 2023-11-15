<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Employee List</h2>

	<table border="1">
		<tr>
			<th>Emp Id</th>
			<th>Name</th>
			<th>Age</th>
			<th>Experience</th>
			<th>Seniority</th>
			<th>Salary</th>
			<th>Dept Id</th>
		</tr>

		<c:forEach var="employee" items="${employees}"> 
			<tr>
				<td>${employee.id}</td>
				<td>${employee.name}</td>
				<td>${employee.age}</td>
				<td>${employee.experience}</td>
				<td>${employee.seniority}</td>
				<td>${employee.salary}</td>
				<td>${employee.dept_id}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>