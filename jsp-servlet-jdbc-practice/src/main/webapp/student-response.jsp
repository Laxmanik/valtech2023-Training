<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = " java.util.* " %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Verification</title>
</head>
<body>
The Student is Confirmed:
<%= request.getParameter("firstName") %> <%= request.getParameter("lastName") %> belong to <%= request.getParameter("country") %> have selected <%= request.getParameter("favouriteLanguage") %> language.
<br/><br/>
Another Shortcut method to display:
<br/><br/>
The Student is Confirmed:
${param.firstName} ${param.lastName}
belong to ${param.country} have selected ${param.favouriteLanguage} language.
<!-- To display list of course -->

<% 
String[] courses = request.getParameterValues("course");
if(courses != null) { //if user not selects check boxes
for(String course: courses) {
    out.println("<li>"+course+"</li>");
}
}
%>

</body>
</html>