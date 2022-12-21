<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View user Detail</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<table border="1px solid black">
<tr>
	<td>Sr no.</td>
	<td>FirstName</td>
	<td>LastName</td>
	<td>UserName</td>
	<td>Password</td>
</tr>
<c:forEach var="i" items="${sessionScope.data}" varStatus="j" >
<tr>
	<td>${j.count}</td>
	<td>${i.firstname}</td>
	<td>${i.lastname}</td>
	<td>${i.username}</td>
	<td>${i.password}</td>
</tr>
</c:forEach>
</table>
</body>
</html>