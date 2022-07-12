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
int id=0;
String un1="";
String pw1="";
String fn="";
String ln="";
%>
<% 
Class.forName("com.mysql.jdbc.Driver");
Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3307/demo1","root","root");
Statement st = c.createStatement();
st.executeUpdate("update edit set PassWord='"+s3+"' where UserName='"+id+"'");
st.close();
c.close();
//out.println(s);
//out.println(s1);
response.sendRedirect("t7.jsp");

%>

</body>
</html>