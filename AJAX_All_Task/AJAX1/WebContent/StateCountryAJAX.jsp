<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register AJAX Page</title>
</head>
<body>
	<script type="text/javascript">
		function fn3() {
			var un = document.getElementById("un");
			console.log(un.value);
			var s1 = document.getElementById("s1");
			console.log(s1.value);
			var htp = new XMLHttpRequest();

			htp.onreadystatechange = function() {
				if (htp.readyState == 4) {
					var res = htp.responseText;
				
				}
			}
			htp.open("get", "UserController?un=" + un.value
					+ "&flag=checkusernameajax", true);
			htp.send();
		}
	</script>
	<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
	<h1>
		Registration For New User: <br>
		<br> <input type="text" name="fn" id="un" placeholder="Username">
		<span style="display: none; color: red" id="s1">this username
			already exist</span> <br> <input type="submit" name="submit"
			onclick="fn3()">
		
		<br>
	</h1>
</body>
</html>