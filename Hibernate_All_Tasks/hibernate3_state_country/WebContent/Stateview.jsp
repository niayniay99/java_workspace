<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View State</title>
</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<body>
<table border="1">
<tr>
	<td>Sr. no :</td>
	<td>State :</td>
	<td>Country :</td>
</tr>
<c:forEach var="i" items="${sessionScope.data}" varStatus="j">
<tr>
	<td>${j.count}</td>
	<td>${i.statename}</td>
	<td>${i.countryvo.countryname}</td>
<td><a href="StateController?id=${i.stateid}&flag=delete">Delete</a></td>
<td><a href="StateController?id=${i.stateid}&flag=edit">Edit</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>