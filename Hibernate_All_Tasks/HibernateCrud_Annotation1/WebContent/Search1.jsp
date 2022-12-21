<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<body>
<form>
<table border="1px solid black">
	<tr>
	<td>S.No.</td>
	<td>FirstName</td>
	<td>LastName</td>
	<td>Edit</td>
	<td>Delete</td>
	</tr>
	<c:forEach items="${sessionScope.data}" var="i" varStatus="j">
		<tr>
			<td>${j.count}</td>
			<td>${i.firstname}</td>
			<td>${i.lastname}</td>
			<td><a href="Regco?flag=edit&id=${i.regid}">edit</a></td>
			<td><a href="Regco?flag=delete&id=${i.regid}">delete</a></td>
		</tr>
	</c:forEach>
</table>
</form>
</body>
</html>