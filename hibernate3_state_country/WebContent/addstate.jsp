<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add State</title>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<form action="StateController">
<h1> 
	Select Country : 
	<select name="countryId">
	<c:forEach var="i" items="${sessionScope.data}">
		<option value="${i.id}">${i.countryname}</option>
	</c:forEach>
	</select>
	<br/>
	Enter State Name :
		<input type="text" name="sn">
		<br/>
		<input type="hidden" name="flag" value="insertstate">
		<br/>
		<input type="submit" value="add"> 
</h1>

</form>
</body>
</html>