<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="jsp.servlet.jdbc.practice.FunctionUtilities"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Lower case of "Hello World!" is : <%= FunctionUtilities.makeItLower("Hello World!") %>
</body>
</html>