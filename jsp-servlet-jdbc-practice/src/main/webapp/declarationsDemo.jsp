<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>JSP Declaration Tag</h3>
<%!
String makeItLower(String data){
	return data.toLowerCase();
}
%>
<br/>
Lower case of "HELLO WORLD!" is:<%= makeItLower("HELLO WORLD!") %>
</body>
</html>