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
String s1 =(String)request.getParameter("un1");
String s2 =(String)request.getParameter("pw1");
String un1="";
String pw1="";
String fn="";
String ln="";
%>
<% 

Class.forName("com.mysql.jdbc.Driver");
Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3307/demo1","root","root");
Statement st = c.createStatement();
ResultSet rs = st.executeQuery("select * from login9 where PassWord='"+s2+"'");

	while(rs.next())
	{
		int id = rs.getInt("id");
		fn = rs.getString("FirstName");
		ln = rs.getString("LastName");
		un1 = rs.getString("UserName");
		pw1 = rs.getString("Password");
	}
%>
	
<% 	
		if((s1.equals(un1)) && (s2.equals(pw1)))
		{
			session.setAttribute("fn1",fn);
			session.setAttribute("ln1",ln);	
			response.sendRedirect("welcome9.jsp");
		}
		else
		{	
			response.sendRedirect("login9.jsp");
			session.setAttribute("wrong","Wrong username or Password");
		}
	
%>


</body>
</html>