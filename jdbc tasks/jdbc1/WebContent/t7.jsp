<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Task</title>
</head>
<body>
<% 
Class.forName("com.mysql.jdbc.Driver");
Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3307/demo1","root","root");
Statement st = c.createStatement();

ResultSet rs = st.executeQuery("select* from edit");%>
<table border="1px">
		<tr>
		<td>id:</td>
		<td>FirstName</td>
		<td>LastName</td>
		</tr>
<% 		
	while(rs.next())
	{
		int id = rs.getInt("id");
		String fn = rs.getString("FirstName");
		String ln = rs.getString("LastName");
		
	%>
		<tr>
		<td><%=id%></td>
		<td><%=fn%></td>
		<td><%=ln%></td>
		<td><a href="delete7.jsp?id=<%=id%>">delete</a></td>
		<td><a href="edit7.jsp?id=<%=id%>">Edit</a></td>
		</tr>
<% 	
	}

%>
		</table>
</body>
</html>