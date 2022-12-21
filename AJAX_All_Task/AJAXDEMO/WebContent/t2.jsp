<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AJAX Task 2</title>
</head>
<body>
<script type="text/javascript" >

function fn1()
	{
		
		var x=document.getElementById("un");
		var y=document.getElementById("pw");
		
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
	htp.open("get","verify2.jsp?un="+x.value+"&pw="+y.value,true);
	htp.send();
}

</script>
				
</head>

<body>

USER NAME:<input type="text" name="un" id="un"/><br>
PASSWORD:<input type="password" id="pw"/><br>

<input type="submit"  value="LOGIN" onclick="fn1()"/>

</body>
</html>