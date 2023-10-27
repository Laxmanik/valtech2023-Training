<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link href="https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css" rel="stylesheet"></link>
</head>
<body class="bg-blue-200 flex items-center justify-center h-screen">
<div id="form" class="bg-red">
	<form action="login" method="post">
	Name : <input name="name" type="text"/> <%= request.getAttribute("message") %> <br /> <br/>
	Password : <input name="pass" type="password" /> <%= request.getAttribute("message1") %> <br /> <br/>
	<input name="Submit" type="submit" value="login"  class="bg-black-500 text-white py-2 px-4 rounded-md hover:bg-red-600"/><br/>
	<%= request.getAttribute("message3") %>
	</form>
</div>		
</body> 
</html>