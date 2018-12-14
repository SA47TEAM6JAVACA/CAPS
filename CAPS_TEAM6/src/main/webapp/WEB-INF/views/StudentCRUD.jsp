<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="<c:url value='/css/simple.css'/>" rel="stylesheet"
	type="text/css" />

<a href="${pageContext.request.contextPath}/AdminStudent/newStudent">Add
	Student</a>
<c:if test="${fn:length(Students) gt 0}">
	<br />
	<br />
	<table class="borderAll">
		<tr>
			<th><td class="header"><s:message code="label.student.index" /></th>
			<th><td class="header"><s:message code="label.student.name" /></th>
			<th><td class="header"><s:message code="label.student.nickName" /></th>						
			<th><td class="header"><s:message code="label.student.email" /></th>
			<th><td class="header"><s:message code="label.student.password" /></th>
			<th><td class="header"><s:message code="label.student.edit" /></th>
			<th><td class="header"><s:message code="label.student.delete" /></th>
		</tr>
		<c:forEach var="Students" items="${Students}" varStatus="status">
			<tr class="${status.index%2==0?'even':'odd'}">
				<td class="nowrap">${status.index}</td>
				<td class="nowrap">${Students.firstmiddlename}</td>
				<td class="nowrap">${Students.lastname}</td>	
				<td class="nowrap">${Students.semail}</td>
				<td class="nowrap">${Students.spassword}</td>
				<td align="center">
				<a
					href="${pageContext.request.contextPath}/AdminStudent/editStudent/${Students.sid}.html">
						<td class="header"><s:message code="label.student.edit" />
				</a></td>
				<td><a
					href="${pageContext.request.contextPath}/AdminStudent/deleteStudent/${Students.sid}.html">
					<td class="header"><s:message
							code="label.student.delete" /></a></td>

			</tr>
		</c:forEach>
	</table>
</c:if>
