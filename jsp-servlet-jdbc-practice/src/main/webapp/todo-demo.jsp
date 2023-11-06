<%@page import="java.util.ArrayList"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TO DO List</title>
</head>
<body>
<h1 align="center">TO DO LIST!</h1>
<!--  Create html form to enter task -->

<form action="todo-demo.jsp">
Add a task: <input type="text" name="task" />
<input type="submit" value="submit" />
</form>

<!-- TO List Tasks  -->
<%
List<String> tasks =(List<String>) session.getAttribute("myToDoList");

if(tasks == null) {
	tasks = new ArrayList<String>();
	session.setAttribute("myToDoList", tasks);
}

//see if there is data to add
String task = request.getParameter("task");
if(task != null){
	tasks.add(task);
}

%>

<hr>

Tasks to do: 
<ol>
<%
for(String tsk : tasks) {
	out.println("<li>"+tsk+"</li>");
}
%>
</ol>


</body>
</html>