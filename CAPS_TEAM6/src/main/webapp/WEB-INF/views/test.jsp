<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<link href="<c:url value='/css/simple.css'/>" rel="stylesheet"
	type="text/css" />
<a href="${pageContext.request.contextPath}/Admin/newCourse">Add
	Course</a>
<c:if test="${fn:length(courses) gt 0 }">
	<br />
	<br />
	<table class="borderAll">
		<tr>
			<th><s:message code="label.course.index" /></th>
			<th><s:message code="label.course.id" /></th>
			<th><s:message code="label.course.name" /></th>
			<th><s:message code="label.course.credit" /></th>
			<th><s:message code="label.course.room" /></th>
			<th><s:message code="label.course.startdate" /></th>
			<th><s:message code="label.course.enddate" /></th>
			<th><s:message code="label.course.studentlimit" /></th>
			<th><s:message code="label.course.currentEnrollno" /></th>
			<th><s:message code="label.course.fee" /></th>
			<th><s:message code="label.course.edit" /></th>
			<th><s:message code="label.course.delete" /></th>
		</tr>
		<c:forEach items="${courses}" var="course" varStatus="index">
			<tr class="${index.index%2==0?'even':'odd'}">
				<td class="nowrap">${index.index+1}</td>
				<td class="nowrap">${course.cid}</td>
				<td class="nowrap">${course.cname}</td>
				<td class="nowrap">${course.credit}</td>
				<td class="nowrap">${course.room}</td>
				<td class="nowrap">${course.startdate}</td>
				<td class="nowrap">${course.enddate}</td>
				<td class="nowrap">${course.studentlimit}</td>
				<td class="nowrap">${course.currentEnrollno}</td>
				<td class="nowrap">${course.fee}</td>
				<td align="center"><a
					href="${pageContext.request.contextPath}//Admin/editCourse/${course.cid}.html">
						<s:message code="label.course.edit" />
				</a></td>
				<td><a
					href="${pageContext.request.contextPath}/Admin/editCourse/${course.cid}.html">
						<s:message code="label.course.delete" />
				</a></td>

			</tr>
		</c:forEach>
	</table>
</c:if>
