<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>JSP Built-in Objects</h3>
Request User Agent: <%=request.getHeader("User-Agent") %>
<br/><br/>
Request Language: <%= request.getLocale() %>
</body>
</html>