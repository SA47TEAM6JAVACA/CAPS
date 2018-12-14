<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<head>
</head>

<body>
	<a
		href="${pageContext.request.contextPath}/Admin/newCoures">Add
		Course</a>
	<c:if test="${fn:length(courses) gt 0 }">
		<table>
			<tr>
				<td>ID</td>
				<td>NAME</td>
				<td>StartDate</td>
				<td>EndDate</td>
				<td>Edit</td>
				<td>Delete</td>
			</tr>
			<c:forEach items="${courses}" var="course" varStatus="index">
				<tr>
					<td>${index.index+1}</td>
					<td>${course.cid}</td>
					<td>${course.cname}</td>
					<td>${course.startdate}</td>
					<td>${course.enddate}</td>
					<td><a
						href="${pageContext.request.contextPath}/Admin/editCoures/${course.cid}">Edit
							Course</a></td>
					<td><a
						href="${pageContext.request.contextPath}/Admin/deleteCourses/${course.cid}">Delete 
							Course</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>