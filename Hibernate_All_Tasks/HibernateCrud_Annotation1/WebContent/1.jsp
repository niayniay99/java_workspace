<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Regco" method="post">
	<table border="1px solid black">
		<tr>
		<td>Enter Your FirstName</td>
		<td><input type="text" name="fn"></td>
		</tr>
		<tr>
		<td>Enter Your LastName</td>
		<td><input type="text" name="ln">
			<input type="hidden" name="flag" value="insert">
		</td>
		</tr>
		<tr>
			<td><input type="submit" value="register"></td>
			<td><a href="Regco?flag=search">Search</a></td>
		</tr>
	</table> 
</form>
</body>
</html>