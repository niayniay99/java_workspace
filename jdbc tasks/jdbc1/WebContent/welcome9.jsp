<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
You Have logged in successfully!!
<%
String s0=(String)session.getAttribute("fn1");
String s1=(String)session.getAttribute("ln1");
out.print("Welcome "+s1);
out.println(" "+s0);
%>
</body>
</html>