<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Regcon" method="post">

FIRSTNAME:<input type="text" name="fn"/><br>

LASTNAME:<input type="text" name="ln"/><br>

	<input type="hidden" name="flag" value="insert"/>
	<input type="submit" value="SUBMIT"/>
</form>
	<a href="Regcon?flag=search">Search</a>
</body>
</html>