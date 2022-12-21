<%@ page import="java.sql.*"%>
<%
String str1=request.getParameter("un");
String str2=request.getParameter("pw");
%>
<%
String fn="";
String ln="";
String un1="";
String pw1="";
Class.forName("com.mysql.jdbc.Driver");
Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3307/demo1","root","root");
Statement st = c.createStatement();
ResultSet rs = st.executeQuery("select * from login9 where PassWord='"+str2+"' AND UserName='"+str1+"' ");

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

if(str1.equals(un1) && str2.equals(pw1))
	{
		out.println("HELLO ! ADMIN  "+fn);
	}
else
	{
		out.println("WRONG USERNAME OR PASSWORD !");
	}
%>