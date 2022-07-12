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
int id = Integer.parseInt(request.getParameter("id1"));
String s =request.getParameter("fn");
String s1 =request.getParameter("ln");

Class.forName("com.mysql.jdbc.Driver");
Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3307/demo1","root","root");
Statement st = c.createStatement();
st.executeUpdate("update edit set FirstName='"+s+"',LastName='"+s1+"' where id='"+id+"'");
st.close();
c.close();
//out.println(s);
//out.println(s1);
response.sendRedirect("t7.jsp");
%>

</body>
</html>