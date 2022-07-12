<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="t21.jsp">
<table border = "1px" width ="300px" height = "300px">
<tr>
<td>First Name:</td><td><input type="text" name="fn" ></td>
</tr>
<tr>
<td>Last Name:</td>	<td><input type ="text" name="ln"></td>
</tr>
<tr>
<td>UserName:</td>	<td><input type ="text" name="un"></td>
</tr>
<tr>
<td>Password:</td>	<td><input type ="text" name="pw"></td>
</tr>
<td>Gender</td> <td><input type="radio" value="Male" text="Male" name="rb">Male
<input type="radio" value="Female" text="Female" name="rb">Female
</td>
<tr>
<td>Hobbies:</td><td><input type="checkbox" name="cb" value="Volleyball">Volleyball<br/>
<input type="checkbox" name="cb" value="Cricket">Cricket<br/>
<input type="checkbox" name="cb" value="Basketball">Basketball<br/>
<input type="checkbox" name="cb" value="Volleyball">Volleyball<br/>
<input type="checkbox" name="cb" value="Drawing">Drawing <br/></td>
</tr>
<tr>
<td>City</td><td><select name="city" id="city">
  <option value="Ahmedabad">Ahmedabad</option>
  <option value="Surat">Surat</option>
  <option value="Baroda">Baroda</option>
  <option value="Rajkot">Rajkot</option></td>
</tr>>
<tr>
<td>Mobile No.:</td><td><input type ="text" name="mob"></td>
</tr>
<tr>
<td colspan=2 align="center" ><input type="submit" value="Submit" name="Submit" ></td>
</tr>
</table>
</form>
</body>
</html>