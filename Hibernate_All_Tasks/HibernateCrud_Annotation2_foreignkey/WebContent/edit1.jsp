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

<form action="Controller">
<table border="1">
	<c:forEach var="i" items="${sessionScope.ed}">
	<tr>
		<td>FirstName: </td>
		<td><input type="text" name="fn" value="${i.Fn}"></td>
	</tr>
	<tr>
		<td>LastName: </td>
		<td><input type="text" name="ln" value="${i.Ln}"></td>
	</tr>
	<tr>
		<td>UserName: </td>
		<td><input type="text" name="un" value="${i.lvo.Un}"></td>
	</tr>
	<tr>
		<td>Password: </td>
		<td><input type="text" name="ln" value="${i.lvo.Pw}"></td>
	</tr>
	<tr>
		<td>
			<input type="hidden" name="regid" value="${i.Regid}">
			<input type="hidden" name="logid" value="${i.lvo.Logid}">
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