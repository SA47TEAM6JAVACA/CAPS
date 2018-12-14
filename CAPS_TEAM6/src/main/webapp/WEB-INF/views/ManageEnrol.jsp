<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<td>#</td>
<td>student</td>
<td>course</td>
<td>EnrollmentDate</td>
<td>score</td>
<td>attendance</td>
</tr>

<c:forEach items="enrolments"  var="enrolment" varStatus="index">
<tr>
<td>${index.index+1}</td>
<td>${StudentCourse.attendence}</td>
<td>${StudentCourse.enrollDate}</td>
<td>${StudentCourse.score}</td>
</tr>


</c:forEach>


</table>



</body>
</html>