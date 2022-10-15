<% 
	System.out.println("UserJSOn"); 
	
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@  taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="userList" value="${sessionScope.data}"></c:set>

<c:set var="lengthofList" value="${f:length(userList)}"></c:set>

[
	<c:forEach var="i" items="${cityList}" varStatus="j">
	{
	"userId":"${i.userid}",
	"userName":"${i.username}"
	}
	
	<c:if test="${j.count ne lengthofList}">,</c:if>
	</c:forEach>
]