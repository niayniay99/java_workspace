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
    String s = "Nilay";
    String s1 = "Doshi";
   
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://database-2.cj2lt2eirqx6.ap-south-1.rds.amazonaws.com/database11","admin1234","admin1234");
    Statement st = con.createStatement();
    st.executeUpdate("insert into table11(FirstName,LastName) values('"+s+"','"+s1+"')");
    st.close();
    con.close();
%>

</body>
</html>