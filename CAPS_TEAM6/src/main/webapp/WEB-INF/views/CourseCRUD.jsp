<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<<<<<<< HEAD
<ul class="sidelist">
	<c:forEach var="listMapview" items="${sessionScope.USERSESSION.link}">

		<li><a href="${listMapview.value}"> ${listMapview.key}</a></li>

	</c:forEach>
</ul>

<hr>
=======
>>>>>>> stash
<a href="${pageContext.request.contextPath}/Admin/newCourse">Add
	Course</a>
	
	<link href="<c:url value='/styles/style.css'/>" rel="stylesheet"
    type="text/css" />
 

<body>
 
    <ul class="sidelist">
        <c:forEach var="listMapview" items="${sessionScope.USERSESSION.link}">
 
            <li><a
                href="${listMapview.value}">
                    ${listMapview.key}</a></li>
 
        </c:forEach>
    </ul>
 
    <hr>
	
<c:if test="${fn:length(courses) gt 0 }">
	<br />
	<br />	

	<table>
		<tr>
			<td>#</td>
			<td>Id</td>
			<td>Course Name</td>
			<td>Credit</td>
			<td>Room</td>
			<td>Start Date</td>
			<td>End Date</td>
			<td>Student Limit</td>
			<td>Current Enrollno</td>
			<td>Fees</td>
			<td>EDIT</td>
			<td>DELETE</td>
		</tr>
		<c:forEach items="${courses}" var="course" varStatus="index">
			<tr>
				<td >${index.index+1}</td>
				<td >${course.cid}</td>
				<td >${course.cname}</td>
				<td >${course.credit}</td>
				<td >${course.room}</td>
				<td >${course.startdate}</td>
				<td >${course.enddate}</td>
				<td >${course.studentlimit}</td>
				<td >${course.currentEnrollno}</td>
				<td >${course.fee}</td>
				<td><a
					href="${pageContext.request.contextPath}/Admin/editCourse/${course.cid}.html">Edit</a></td>
				<td><a
					href="${pageContext.request.contextPath}/Admin/deleteCourse/${course.cid}.html">Delete</a></td>
				<td><a
					href="${pageContext.request.contextPath}/Admin/addlecturer/${course.cid}.html">Add Lecturer</a></td>

			</tr>
		</c:forEach>
	</table>

</c:if>
