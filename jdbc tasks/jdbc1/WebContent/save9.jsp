<%@page import="com.mysql.fabric.Response"%>
<%@page import="sun.security.provider.certpath.ResponderId"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String s=(String)request.getParameter("fn");
String s1=(String)request.getParameter("ln");
String s2=(String)request.getParameter("un");
String s3=(String)request.getParameter("pw");


Class.forName("com.mysql.jdbc.Driver");
Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3307/demo1","root","root");
Statement s10 = c.createStatement();
s10.executeUpdate("insert into login9(FirstName,LastName,UserName,Password) values('"+s+"','"+s1+"','"+s2+"','"+s3+"')");
s10.close();
c.close();
response.sendRedirect("login9.jsp");
%>


</body>
</html>