<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="CountryController">
<h1>

		<b>Country Name :</b><input type="text" name="cn">
		<input type="hidden" name="flag" value="addcountry">
		</br></br>
		<b>Description :</b><input type="text" name="cdesc">
		</br></br> 
		<input type="submit" value="Add">
		</br></br>
		<a href="Menu.jsp">Menu</a>
		
</h1>
</form>
</body>
</html>