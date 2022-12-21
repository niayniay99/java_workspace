<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View City</title>
</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<body>
<table border="1px solid black">
<tr>
	<td>Sr no</td>
	<td>City</td>
	<td>State</td>
</tr>
<c:forEach var="i" items="${sessionScope.data}" varStatus="j">
<tr>
	<td>${j.count}</td>
	<td>${i.cityname}</td>
	<td>${i.statevo.statename}</td>
	<td><a href="CityController?id=${i.cityid}&flag=delete">Delete</a></td>
	<td><a href="CityController?id=${i.cityid}&flag=edit">Edit</a></td>
	
</tr>
</c:forEach>
</table>
</body>
</html>