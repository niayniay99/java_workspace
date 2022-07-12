<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action ="verify9.jsp">
<table border="1px" width = "300px" height = "300px" >
<tr>
<td>UserName :</td><td><input type="text" name="un1"></td>
</tr>
<tr>
<td>Password :</td><td><input type="text" name="pw1"></td>
</tr>
<tr>
<td colspan=2 align="center"> <input type="submit" value="login" name="login"></td>
</tr>
<tr>
<td colspan=2 align="center"><a href="register9.jsp?">Register</a></td>		
</tr>
<tr>
<td colspan=2 align="center"><a href="changepassword9.jsp?">Change Password</a></td>		
</tr>
</table>
</form>
<%
String s0=(String)session.getAttribute("wrong");
if(s0!=null)
{
	out.println(s0);
	session.removeAttribute("wrong");
}
%>

</body>
</html>