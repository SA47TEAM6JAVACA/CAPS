<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
=======

>>>>>>> refs/remotes/origin/master
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<<<<<<< HEAD
	<c:forEach var="listMapview" items="${sessionScope.USERSESSION.link}">
=======
<table>
<tr>
<td>#</td>
<td>student</td>
<td>course</td>
<td>EnrollmentDate</td>
</tr>
>>>>>>> refs/remotes/origin/master

<<<<<<< HEAD
		<li><a
			href="${listMapview.value}">
				${listMapview.key}</a></li>

	</c:forEach>
	</ul>

	<hr>
	<table>
		<tr>
			<td>#</td>
			<td>student</td>
			<td>course</td>
			<td>EnrollmentDate</td>
			<td>score</td>
			<td>attendance</td>
		</tr>

		<c:forEach items="enrolments" var="enrolment" varStatus="index">
			<tr>
				<td>${index.index+1}</td>
				<td>${StudentCourse.attendence}</td>
				<td>${StudentCourse.enrollDate}</td>
				<td>${StudentCourse.score}</td>
			</tr>
=======


<c:forEach items="${enrolments}"  var="enrolment" varStatus="index">
<tr>
<td>${index.index+1}</td>
<td>${enrolment.student.firstmiddlename}</td>
<td>${enrolment.course.cname}</td>
<td>${enrolment.enrollDate}</td>
</tr>
>>>>>>> refs/remotes/origin/master


		</c:forEach>


	</table>



</body>
</html>