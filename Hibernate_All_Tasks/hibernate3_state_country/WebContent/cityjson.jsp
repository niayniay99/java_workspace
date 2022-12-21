<% System.out.println("CityJSOn"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@  taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="cityList" value="${sessionScope.data}"></c:set>

<c:set var="lengthofList" value="${f:length(cityList)}"></c:set>

[
	<c:forEach var="i" items="${cityList}" varStatus="j">
	{
	"cityId":"${i.cityid}",
	"cityName":"${i.cityname}"
	}
	
	<c:if test="${j.count ne lengthofList}">,</c:if>
	</c:forEach>
]