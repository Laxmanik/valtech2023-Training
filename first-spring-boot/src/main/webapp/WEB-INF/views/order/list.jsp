<%@page import="com.valtech.training.firstspringboot.models.OrderModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order List</title>
</head>
<body>
	<h2>List of orders</h2>
	<%
	List<OrderModel> orders = (List<OrderModel>) request.getAttribute("orders");
	%>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Item</th>
				<th>ItemCount</th>
				<th>Description</th>
				<th>OrderDate</th>
				<th>Actions</th>
			<tr>
		</thead>
		<!-- 
		JSTL core
		<c:forEach />
		 -->
		<%
		for (OrderModel o : orders) {
			request.setAttribute("o", o);
		%>

		<tr>
			<td>${o.id}</td>
			<td>${o.item}</td>
			<td>${o.itemCount}</td>
			<td>${o.description}</td>
			<td>${o.orderDate}</td>
			<td><a href="delete?id=${o.id}">Delete</a> <a
				href="edit?id=${o.id}">Edit</a></td>
		</tr>
		<%
		}
		%>
		<tfoot>
			<tr>
				<td colspan="5" align="right">
					<form action="new" method="get">
						<input type="submit" name="submit" value="NEW ORDER" />
					</form>
				</td>
			</tr>
		</tfoot>

	</table>
</body>
</html>