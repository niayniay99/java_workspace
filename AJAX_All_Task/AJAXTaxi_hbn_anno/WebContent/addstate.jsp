<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add State_taxi</title>
</head>
<body>
<h1>Add State:</h1>
<form>
<table border="1px solid black" height="100px" width="400px">
	<tr>
		<td>Enter State Name:</td>
		<td><input type="text" name="sn"></td>
	</tr>
	<tr>
		<td align="center" colspan="2"><input type="hidden" name="flag" value="statename">
			<input type="submit" name="Add" value="Add"></td>
	</tr>
</table>
<a href="menu.jsp">Menu</a>
</form>
</body>
</html>