<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
</head>
<body>
	<h2 align="center">Fancy PhoneNumber Ranker Result</h2>
	<p align="center">Ranked PhoneNumbers:</p>
	<br />
	<ol>
		<%
		List<String> rankedPhoneNumbers = (List<String>) request.getAttribute("rankedPhoneNumbers");
		%>
		<%
		for (String phoneNumber : rankedPhoneNumbers) {
		%>
		<li><%=phoneNumber%></li>
		<%
		}
		%>
	</ol>
	<p>
	<a href="index.jsp">Go back to Generate Rank for other Phone Numbers</a>
	</p>
</body>
</html>