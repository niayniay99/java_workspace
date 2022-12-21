<%@ page import="java.sql.*" %>
<% 
	String str1 = request.getParameter("fn");
	String str2 = request.getParameter("ln");
	String str3 = request.getParameter("un");
	String str4 = request.getParameter("pw");
	System.out.println(str1);
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3307/demo1","root","root");
	Statement s2 = c.createStatement();
	s2.executeUpdate("insert into login9(FirstName,LastName,UserName,PassWord) values('"+str1+"','"+str2+"','"+str3+"','"+str4+"')");
	s2.close();
	c.close();

%>