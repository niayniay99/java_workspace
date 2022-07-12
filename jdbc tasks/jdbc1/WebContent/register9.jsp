<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
<form action="save9.jsp">
<table border="1px" width = "300px" height = "300px" >
<tr>
<td>First Name:</td><td><input type="text" name="fn"></td>
</tr>
<tr>
<td>Last Name:</td><td><input type="text" name="ln"></td>
</tr>
<tr>
<td>UserName:</td><td><input type="text" name="un"></td>
</tr>
<tr>
<td>Password:</td><td><input type="text" name="pw"></td>
</tr>
<tr>
<td colspan=2 align="center" > <input type="submit" value="Register" name="register"></td>
</tr>
</table>
</form>
</body>
</html>