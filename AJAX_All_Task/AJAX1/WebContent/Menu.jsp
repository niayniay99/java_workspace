<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu</title>
</head>
<body>
<form action="UserController" method="post">
<table border="solid black">
<tr>
	<td colspan="2" align="center">---------------------------</td>
</tr>
<tr>
	<td colspan="2" align="center"><h1><b>User :</b></h1></td>
</tr>
<tr>
	<td><a href="adduserdetail.jsp"><h2>Add User</h2></a></td>
	<td><a href="UserController?flag=viewun"><h2>View User</h2></a></td>
</tr>
<tr>
	<td colspan="2" align="center">---------------------------</td>
</tr>

<tr>
	<td colspan="2" align="center"><h1><b>Registration:</b></h1></td>
</tr>
<tr>
	<td colspan="2"><a href="StateCountryAJAX.jsp"><h2>Register AJAX form</h2></a></td>
</tr>
</table>
</form>
</body>
</html>