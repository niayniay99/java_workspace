<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Controller">
<table border="1px solid black">
	<tr>
		<td>FirstName</td>
		<td><input type="text" name="fn"></td>		
	</tr>
	<tr>
		<td>LastName</td>
		<td><input type="text" name="ln"></td>		
	</tr>
	<tr>
		<td>UserName</td>
		<td><input type="text" name="un"></td>		
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="text" name="pw"></td>		
	</tr>
	<tr>
		<td>
		<input type="hidden" name="flag" value="insert">
		<input type="submit" name="Register" value="Register">
		</td>
	</tr>
	
</table>

</form>
<h1><a href="Controller?flag=search">Search</a></h1>
</body>
</html>