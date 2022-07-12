<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get Data From Database</title>
</head>
<body>
<% 
Class.forName("com.mysql.jdbc.Driver");
Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3307/demo1","root","root");
Statement st = c.createStatement();

ResultSet rs = st.executeQuery("select * from id1");

	while(rs.next())
	{
		int id = rs.getInt("id");
		String fn = rs.getString("FirstName");
		String ln = rs.getString("LastName");
		String un = rs.getString("UserName");
		String pw = rs.getString("Password");
		String ge = rs.getString("Gender");
		String hb = rs.getString("Hobbies");
		String mn = rs.getString("MobileNo");
		String ci = rs.getString("City");
	%>
		<table border="1px">
		<tr>
		<td>id:</td><td><%=id%></td>
		</tr>
		<tr>
		<td>FirstName</td><td><%=fn%></td>
		</tr>
		<tr>
		<td>LastName:</td><td><%=ln%></td>
		</tr>
		<tr>
		<td>UserName:</td><td><%=un%></td>
		</tr>
		<tr>
		<td>Password:</td><td><%=pw%></td>
		</tr>
		<tr>
		<td>Gender:</td><td><%=ge%></td>
		</tr>
		<tr>
		<td>Hobbies:</td><td><%=hb%></td>
		</tr>
		<tr>
		<td>Mobile No:</td><td><%=mn%></td>
		</tr>
		<tr>
		<td>City:</td><td><%=ci%></td>
		</tr>
		</table>
		<br><br>
<% 	
	}
%>


</body>
</html>