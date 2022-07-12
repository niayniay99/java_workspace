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
String s4=(String)request.getParameter("rb");
String s5[]=request.getParameterValues("cb");
String s7=(String)request.getParameter("city");

String s6=(String)request.getParameter("mob");
out.println("Data Entered Succesfully");
String s15="";
if (s5!= null && s5.length != 0) 
{
for (int i = 0; i < s5.length; i++)
	{
	s15 = s15+s5[i]+", ";
	}
}

Class.forName("com.mysql.jdbc.Driver");
Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3307/demo1","root","root");
Statement s10 = c.createStatement();
s10.executeUpdate("insert into id1(FirstName,LastName,Password,UserName,Gender,Hobbies,MobileNo,City) values('"+s+"','"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s15+"','"+s6+"','"+s7+"')");

s10.close();
c.close();

%>

</body>
</html>