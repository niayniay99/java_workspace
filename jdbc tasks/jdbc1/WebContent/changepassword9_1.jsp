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
String s =(String)request.getParameter("un");
String s1 =(String)request.getParameter("opw");
String s2 =(String)request.getParameter("npw");
String s3 =(String)request.getParameter("cnpw");
session.setAttribute(s,"s1");
session.setAttribute(s1,"s2");
session.setAttribute(s2,"s3");
session.setAttribute(s3,"s4");

 
Class.forName("com.mysql.jdbc.Driver");
Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3307/demo1","root","root");
Statement st = c.createStatement();

ResultSet rs = st.executeQuery("select * from id1 where UserName='"+s+"' AND PassWord='"+s1+"'");

	while(rs.next())
	{
		int	id = rs.getInt("id");
		String fn = rs.getString("FirstName");
		String ln = rs.getString("LastName");
	}
%>
</body>
</html>