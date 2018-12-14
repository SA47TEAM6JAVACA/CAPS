<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>

<body>
<table>
<td><form:select path="lecturer.firstmiddlename" items="${eidlist}" /></td>
<td><form:select path="course.cname" items="${cname}" /></td>
</table>
</body>
</html>