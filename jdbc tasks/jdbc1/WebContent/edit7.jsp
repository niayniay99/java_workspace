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
int id = Integer.parseInt(request.getParameter("id"));
Class.forName("com.mysql.jdbc.Driver");
Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3307/demo1","root","root");
Statement st = c.createStatement();

ResultSet rs = st.executeQuery("select* from edit where id="+id);

	while(rs.next())
	{
		int id1 = rs.getInt("id");
		String fn = rs.getString("FirstName");
		String ln = rs.getString("LastName");
	%>
	<form action=update7.jsp>
		<table border="1px">
		<tr>
		<td><input type="hidden" name="id1" value="<%=id1%>"></td>
		</tr>
		<tr>
		<td>FirstName</td><td><input type="text" name="fn" value="<%=fn%>"></td>
		</tr>
		<tr>
		<td>LastName:</td><td><input type="text" name="ln" value="<%=ln%>"></td>
		</tr>
		<tr>
		<td><td colspan=2 align="center" ><input type="submit" value="Update"></td>

		</tr>
		</table>		
		</form>
		<br><br>
<% 	
	}
%>

</body>
</html>