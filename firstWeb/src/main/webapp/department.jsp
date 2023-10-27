<%@page import="firstWeb.Department"%>
<%@page import="firstWeb.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Department Details</title>
</head>
<body>
	<%
	Department dept = (Department) session.getAttribute("dept");
	%>
	
	<table>
		<tr>
			<td>Department Id:</td>
			<td><%=dept.getDeptId()%></td>
		</tr>
		<tr>
			<td>Department Name:</td>
			<td><%=dept.getDeptName()%></td>
		</tr>
		<tr>
			<td>Department Location:</td>
			<td><%=dept.getDeptLocation()%></td>
		</tr>
		<tr>

			<td colspan="2">
				<form action="deptCtlr" method="post">
					<input type="submit" name="submit" value="First" /> 
					<input type="submit" name="submit" value="Previous" /> 
					<input type="submit" name="submit" value="Next" /> 
					<input type="submit" name="submit" value="Last" />
				</form>
			</td>

		</tr>
		
	</table>
	
	<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Age</th>
						<th>Experience</th>
						<th>Seniority</th>
						<th>SALARY</th>
						<th>DEPTID</th>
						
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="employee" items="${getEmployeeByDeptId}">

						<tr>
							<td><c:out value="${employee.id}" /></td>
							<td><c:out value="${employee.name}" /></td>
							<td><c:out value="${employee.age}" /></td>
							<td><c:out value="${employee.experience}" /></td>
							<td><c:out value="${employee.seniority}" /></td>
							<td><c:out value="${employee.salary}" /></td>
							<td><c:out value="${employee.deptid}" /></td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>


</body>
</html>