<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value='/styles/style.css'/>" rel="stylesheet"
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
	<P>Select the course</P>
	<div style="width: 100%; height: 800px; float: left;">
		<form:form modelAttribute="studentcourse"
			action="${pageContext.request.contextPath}/student/enroll.html"
			method="post">

			<fieldset>

				<form:select path="course.cname" items="${courses}" />
				<input id="submit" type="submit"
					tabindex="5" value="Enroll course">

			</fieldset>
		</form:form>


		</span>
</body>
</html>



















