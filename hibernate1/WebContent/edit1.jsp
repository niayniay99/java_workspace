<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit & Update</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<form action="Regcon">
<table border="1px solid black">
<c:forEach var="i" items="${sessionScope.ed}">

	<tr>
		<td>FirstName: </td>
		<td><input type="text" name="fn" value="${i.firstname}"></td>
	</tr>
	<tr>
		<td>LastName: </td>
		<td><input type="text" name="ln" value="${i.lastname}"></td>
	</tr>
	<tr>
		<td>
			<input type="hidden" name="id" value="${i.id}">
			<input type="hidden" name="flag" value="update">
		</td>
	</tr>
</c:forEach>
<tr>
<td rowspan="2" colspan="2">
<input type="submit" name="update" value="update"></td></tr>
</table>
</form>
</body>
</html>