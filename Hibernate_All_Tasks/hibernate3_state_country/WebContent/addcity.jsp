<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Your City</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<form action="CityController">
	<h1>
	Select State:
	
	<select name="stateId">
	
		<c:forEach var="i" items="${sessionScope.data}" >
			<option value="${i.stateid}">${i.statename}</option>
		</c:forEach>
	
	</select>
	<br/>
	
	Enter City Name:
		<input type="text" name="city">
	<br/>
		<input type="hidden" name="flag" value="insertcity">
	<br/>
		<input type="submit" name="add">
	</h1>
	
</form>
</body>
</html>