<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" >

function fn1()
	{
		
		var x = document.getElementById("un");
		var y = document.getElementById("pw");
		
		var z1 = document.getElementById("fn");
		var z2 = document.getElementById("ln");
	
		var htp=new XMLHttpRequest();
		
		htp=new XMLHttpRequest();
		
		htp.onreadystatechange=function(){
			console.log('state: ',htp.readyState);
				
			/*
			There are five readyState of AJAX
				
				0=request not initialized
				1=request initialized
				2=process
				3=send
				4=response
				
			*/	
			if(htp.readyState==4){
						
					alert(htp.responseText);
			}
		}
	//	    method   page name?data                      Asyncronization
	htp.open("get","save.jsp?un="+x.value+"&pw="+y.value+"&fn"+z1.value+"&ln"+z2.value,true);
	htp.send();
}

</script>
				
</head>

<body>
<table border="1px solid black" >
<tr>
	<td>First Name:</td>
	<td><input type="text" name="fn" id="fn"></td>
</tr>
<tr>
	<td>Last Name:</td>
	<td><input type="text" name="ln" id="ln"></td>
</tr>
<tr>
	<td>USER NAME:</td>
	<td><input type="text" name="un" id="un"/></td>
</tr>
<tr>
	<td>PASSWORD:</td>
	<td><input type="password" id="pw"/></td>
</tr>
<tr>
	<td><input type="submit" value="LOGIN" onclick="fn1()"/></td>
</tr>
</table>
</body>
</html>