<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter User Details</title>
</head>
<body>
<form action="UserController">
<table border="1px solid black" width="300px" height="300px">
<tr>
	<td colspan="2" align="center" ><input type="text" name="fn" placeholder="Firstname"></td>
</tr>
<tr>
	<td colspan="2" align="center"><input type="text" name="ln" placeholder="Lastname"></td>
</tr>
<tr>
	<td colspan="2" align="center"><input type="text" name="un" placeholder="Username"></td>
</tr>
<tr>
	<td colspan="2" align="center"><input type="text"  name="pw" placeholder="password">
	<input type="hidden" name="flag" value="addusername">
	</td>
</tr>
<tr>
	<td colspan="2" align="center" ><input type="submit" name="Enter"></td>
</tr>
</table>
</form>
</body>
</html>