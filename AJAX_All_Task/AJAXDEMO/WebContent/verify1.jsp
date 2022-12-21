<%
String str1=request.getParameter("un");
String str2=request.getParameter("pw");

if(str1.equals("admin") && str2.equals("admin"))
	{
		out.println("HELLO ! ADMIN");
	}
else
	{
		out.println("WRONG USERNAME OR PASSWORD !");
	}
%>
