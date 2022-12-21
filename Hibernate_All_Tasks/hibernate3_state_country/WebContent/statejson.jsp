

<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="stateList" value="${datastate}"></c:set>

<c:set var="lengthofList" value="${f:length(stateList)}"></c:set>

[
	<c:forEach var="i" items="${stateList}" varStatus="j">
	{
	"stateId":"${i.stateid}",
	"stateName":"${i.statename}"
		
	}
	
	<c:if test="${j.count ne lengthofList}">,</c:if>
	</c:forEach>
]
