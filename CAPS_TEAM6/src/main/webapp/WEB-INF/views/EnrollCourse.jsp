<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<link href="<c:url value='/css/style.css'/>" rel="stylesheet"
	type="text/css" />

<%-- <a href="${pageContext.request.contextPath}/student/create">Add
	Student</a> --%>
	
	<br />
	<br />
	<table class="borderAll">
		<tr>
			<th><s:message code="label.course.name" /></th>
			<th><s:message code="label.course.startDate" /></th>
			<th><s:message code="label.course.endDate" /></th>
		</tr>
		<c:forEach var="course" items="${courses}" varStatus="status">
			<tr class="${status.index%2==0?'even':'odd'}">
				<td class="nowrap">${course.cname}</td>
				<td class="nowrap">${course.startdate}</td>
				<td class="nowrap">${course.enddate}</td>
				
			</tr>
		</c:forEach>
	</table>
