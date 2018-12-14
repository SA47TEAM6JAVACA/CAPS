<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<ul class="sidelist">
	<c:forEach var="listMapview" items="${sessionScope.USERSESSION.link}">

		<li><a href="${listMapview.value}"> ${listMapview.key}</a></li>

	</c:forEach>
</ul>

<hr>
<a href="${pageContext.request.contextPath}/AdminStudent/newStudent">Add
	Student</a>
<c:if test="${fn:length(Students) gt 0}">
	<br />
	<br />
	<table>
		<tr>
			<td>#</td>
			<td>Id</td>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Email</td>
			<td>Password</td>
			<td>EDIT</td>
			<td>DELETE</td>
		</tr>
		<c:forEach var="Students" items="${Students}" varStatus="status">
			<tr>
				<td>${status.index}</td>
				<td>${Students.sid}</td>
				<td>${Students.firstmiddlename}</td>
				<td>${Students.lastname}</td>
				<td>${Students.semail}</td>
				<td>${Students.spassword}</td>
				<td><a
					href="${pageContext.request.contextPath}/AdminStudent/editStudent/${Students.sid}.html">Edit</a></td>
				<td><a
					href="${pageContext.request.contextPath}/AdminStudent/deleteStudent/${Students.sid}.html">Delete</a></td>

			</tr>
		</c:forEach>
	</table>


</c:if>
