<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<body>
<table border="1">
<tr>
	<td>ID</td>
	<td>FirstName</td>
	<td>LastName</td>
</tr>
<c:forEach var="i" items="${sessionScope.data}">
<tr><td>${i.id}</td>
<td>${i.firstname}</td>
<td>${i.lastname}</td>
<td><a href="Regcon?id=${i.id}&flag=delete">Delete</a></td>
<td><a href="Regcon?id=${i.id}&flag=edit">edit</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>