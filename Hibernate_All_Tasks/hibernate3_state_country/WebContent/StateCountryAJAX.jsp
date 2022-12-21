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
function fn1() {
	var cn1 = document.getElementById("cn");
	console.log(cn1.value);
	var st1 = document.getElementById("st");
	var htp = new XMLHttpRequest();

	htp.onreadystatechange = function() {
		if (htp.readyState == 4) {
		//	alert(htp.responseText);
			
			var jsn = JSON.parse(htp.responseText);

			st1.innerHTML='';
			st1.innerHTML='<option>Select</option>';
						
			for (var i = 0; i < jsn.length; i++) {
				var opt = document.createElement("option");

				opt.value = jsn[i].stateId;
				opt.text = jsn[i].stateName;

				st1.options.add(opt);
}
		}
	}
	htp.open("get", "StateController?countryid="+cn.value+"&flag=loadstateAJAX", true);
	htp.send();
}
function fn2()
{
	var st1 = document.getElementById("st");
	console.log(st.value);
	var ct1 = document.getElementById("ct");
	console.log(ct1.value);
	var htp = new XMLHttpRequest();

	htp.onreadystatechange = function() {
		if (htp.readyState == 4) {
		//	alert(htp.responseText);
			
			var jsn = JSON.parse(htp.responseText);

			ct1.innerHTML='';
			ct1.innerHTML='<option>Select</option>';
						
			for (var i = 0; i < jsn.length; i++) {
				var opt = document.createElement("option");

				opt.value = jsn[i].cityId;
				opt.text = jsn[i].cityName;

				ct1.options.add(opt);
}
		}
	}
	htp.open("get", "CityController?stateid="+st.value+"&flag=loadcityAJAX", true);
	htp.send();
}

</script>

<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
	<h1>
	Registration For New User:
	<br><br>
	
	SELECT COUNTRY:
	<select id="cn" onchange="fn1()">
		
		<option>SELECT</option>
		<c:forEach var="i" items="${sessionScope.data}">
		
			<option value="${i.id}">${i.countryname}</option>
		
		</c:forEach>
	
	</select>
	<br>
	<br> SELECT STATE:
	<select id="st" onchange="fn2()">

		<option>SELECT</option>
		<c:forEach var="i" items="${sessionScope.data}">
		
			<option></option>
		
		</c:forEach>
		
	</select>
<br> SELECT City:
	<select id="ct">

		<option>SELECT</option>
		<c:forEach var="i" items="${sessionScope.data}">
		
			<option></option>
		
		</c:forEach>
		
	</select>
	
<br>
</h1>
</body>
</html>