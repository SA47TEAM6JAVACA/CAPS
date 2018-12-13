<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
</tr>



<c:forEach items="${enrolments}"  var="enrolment" varStatus="index">
<tr>
<td>${index.index+1}</td>
<td>${enrolment.student.firstmiddlename}</td>
<td>${enrolment.course.cname}</td>
<td>${enrolment.enrollDate}</td>
</tr>


</c:forEach>


</table>



</body>
</html>