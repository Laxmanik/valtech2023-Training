<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h5 style="color:red">${message}</h5>
	<form action="register" method="post">
		<table>
			<tr>
				<td>Username :</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>Confirm Password :</td>
				<td><input type="password" name="confirmPassword" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="submit" value="Register" /></td>
			</tr>
		</table>
	</form>
</body>
</html>