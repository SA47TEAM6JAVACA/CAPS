<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value='/css/style.css'/>" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<ul class="sidelist">
		<c:forEach var="listMapview" items="${sessionScope.USERSESSION.link}">

			<li><a
				href="${listMapview.value}">
					${listMapview.key}</a></li>

		</c:forEach>
	</ul>

	<hr>
<form:form method="POST" modelAttribute="Student"
	action="${pageContext.request.contextPath}/AdminStudent/newStudent.html">
		<center>
			<table cellpadding=4 cellspacing=2 border=0>
			<tr>
				   <td><s:message code="label.student.name" /> *</td>
				   <td><form:input path="sid"/></td>
				 </tr>
				<tr>
				   <td><s:message code="label.student.name" /> *</td>
				   <td><form:input path="firstmiddlename"/></td>
				 </tr>
				<tr>
				   <td><s:message code="label.student.nickName" /></td>
				   <td><form:input path="lastname"/></td>
				 </tr>	
				 <tr>			
				   <td><s:message code="label.student.email" /></td>
				   <td><form:input path="semail"/></td>
				 </tr>
				
				<tr>
				   <td><s:message code="label.student.password" /></td>
				   <td><form:input path="spassword"/></td>
				 </tr>
				 <tr>
				 <td><input type="submit" value="Submit"> </td>
				 <td><input type="reset" value="Reset"></td>
				 </tr>
		</table>
		</center>
	
	</form:form>
</body>
</html>