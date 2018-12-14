<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<ul class="sidelist">
	<c:forEach var="listMapview" items="${sessionScope.USERSESSION.link}">

		<li><a href="${listMapview.value}"> ${listMapview.key}</a></li>

	</c:forEach>
</ul>

<hr>
<style>
#content {
	overflow: auto;
	width: 600px;
	background: gray;
}

#left {
	float: left;
	width: 20%;
}

#right {
	overflow: hidden;
	width: 80%;
}

.ui-datepicker {
	background: #333;
	border: 1px solid #555;
	color: #EEE;
}
</style>
		<h1>This is the Course Lecturer page</h1>
		<div id="content">
			<form:form
				action="${pageContext.request.contextPath}/Admin/newCourse"
				mehtod="POST" modelAttribute="course">
				<div id="left">
					<div>ID:</div>
					<div>Name:</div>
				</div>

				<div id="right">
					<div>
						<form:input path="cid" size="11" readonly="true" />
					</div>
					<div>
						<form:input path="cid" size="11" readonly="true" />
					</div>
				</div>
				<br />
				<div>This is all the Lecturers</div>
				<table class="borderAll">
					<tr>
						<th><s:message code="label.course.index" /></th>
						<th><s:message code="label.course.id" /></th>
						<th><s:message code="label.course.name" /></th>
						<th><s:message code="label.course.credit" /></th>
						<th><s:message code="label.course.room" /></th>
					</tr>
					<c:forEach items="${llist}" var="lecturer" varStatus="index">
						<tr class="${index.index%2==0?'even':'odd'}">
							<td class="nowrap">${index.index+1}</td>
							<td class="nowrap">${lecturer.lid}</td>
							<td class="nowrap">${lecturer.firstmiddlename}</td>
							<td class="nowrap">${lecturer.lastname}</td>
							<td class="nowrap">${lecturer.lemail}</td>
							<td><a
								href="${pageContext.request.contextPath}/Admin/addlecturer/${course.cid}/${lecturer.lid}.html">
									Add </a></td>
						</tr>
					</c:forEach>
				</table>
				<div>This is Lecturers for this course</div>
				<table class="borderAll">
					<tr>
						<th><s:message code="label.course.index" /></th>
						<th><s:message code="label.course.id" /></th>
						<th><s:message code="label.course.name" /></th>
						<th><s:message code="label.course.credit" /></th>
						<th><s:message code="label.course.room" /></th>
					</tr>
					<c:forEach items="${lclist}" var="lecCou" varStatus="index">
						<tr class="${index.index%2==0?'even':'odd'}">
							<td class="nowrap">${index.index+1}</td>
							<td class="nowrap">${lecCou.lid}</td>
							<td class="nowrap">${lecCou.firstmiddlename}</td>
							<td class="nowrap">${lecCou.lastname}</td>
							<td class="nowrap">${lecCou.lemail}</td>
						</tr>
					</c:forEach>
				</table>
				<br />
				<input type="submit" value="Submit" />
				<input type="reset" value="Cancel" />
				<br />
			</form:form>
		</div>