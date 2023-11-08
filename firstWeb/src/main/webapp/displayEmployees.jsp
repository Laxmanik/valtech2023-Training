
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employees Details</title>
</head>
<body>



<table class="table table-bordered">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Experience</th>
            <th>Seniority</th>
            <th>SALARY</th>
            <th>DEPTID</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="em" items="${employees}" >
            <tr>
                
                <td><c:out value="${em.name}" /></td>
                <td><c:out value="${em.age}" /></td>
                <td><c:out value="${em.experience}" /></td>
                <td><c:out value="${em.seniority}" /></td>
                <td><c:out value="${em.salary}" /></td>
                <td><c:out value="${em.id}" /></td>
                <td><c:out value="${em.deptid}" /></td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>