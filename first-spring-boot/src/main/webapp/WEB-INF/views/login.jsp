<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post">
		<table>
			<tr>
				<td>Username: </td>
				<td><input name="username" type="text" /></td>
			</tr>
			<tr>
				<td>Password: </td>
				<td><input name="password" type="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="submit" value="Login"/></td>
			</tr>
		</table>
	</form>
</body>
</html>