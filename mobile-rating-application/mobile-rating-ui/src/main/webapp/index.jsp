<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fancy PhoneNumber Ranker</title>
</head>
<body>
<h2 align="center">Fancy PhoneNumber Ranker</h2>
<form align="center" action="MobileRankingServlet" method="post">
<p>Enter 10 digit PhoneNumber one per line</p>
<textarea name="phoneNumbers" rows="10" cols="30" placeholder="Enter 10 digit PnoneNumbers"></textarea>
<br/> <br/>
<input type="submit" value="Rank PhoneNumber" />
</form>
</body>
</html>