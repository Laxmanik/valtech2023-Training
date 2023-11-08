<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Conversion Result</title>
<style>
.result-container {
	display: block;
	text-align: center;
    color: Green;
}

.result-text{
        font-weight: bold;
        color: blue;
}

.btn-secondary{
		display: block;
        width: 100%;
        padding: 10px;
        background-color: Red;
        color: #fff;
        border: none;
        border-radius: 3px;
        cursor: pointer;
}
</style>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
	<div class="container result-container">
		<h3 class="title">Result</h3>
		<h1 class="result-text">
			The result is:
			<%=request.getAttribute("result")%></h1>
		<a href="convert.jsp" class="btn btn-secondary">Go Back</a>
	</div>
</body>
</html>