<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<table border="1">
<tr>
	<td>SR No.</td>
	<td>FirstName</td>
	<td>LastName</td>
	<td>Username</td>
	<td>Password</td>
</tr>
<c:forEach var="i"  items="${sessionScope.data}" varStatus="j">
<tr><td>${j.count}</td>
<td>${i.fn}</td>
<td>${i.ln}</td>
<td>${i.lvo.un}</td>
<td>${i.lvo.pw}</td>
<td><a href="Controller?id=${i.id}&flag=delete">Delete</a></td>
<td><a href="Controller?id=${i.id}&flag=edit">edit</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>