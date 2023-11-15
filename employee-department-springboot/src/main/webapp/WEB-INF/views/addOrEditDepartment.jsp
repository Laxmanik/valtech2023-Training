<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Add/Edit Department</h2>
	<form action="saveDept" method="post">
		<table>
			<tr>
				<td>Department Id</td>
				<td><input type="text" disabled="disabled" name="deptId" /></td>
			</tr>
			<tr>
				<td>Department Name</td>
				<td><input type="text" name="deptName" /></td>
			</tr>
			<tr>
				<td>Department Location</td>
				<td><input type="text" name="deptLocation" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Add Department" /> 
				<input type="submit" name="cancel" value="cancel" /></td>
			</tr>
		</table>
	</form>
</body>
</html>