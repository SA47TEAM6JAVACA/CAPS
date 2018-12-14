<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<ul class="sidelist">
		<c:forEach var="listMapview" items="${sessionScope.USERSESSION.link}">

			<li><a
				href="${listMapview.value}">
					${listMapview.key}</a></li>

		</c:forEach>
	</ul>

	<hr>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/StudentCourse/listgrade" method="POST" modelAttribute="studentcourse">
Student Course ID:<form:input path="scid" size="10" readonly="true"/><br/>
Student id:<form:input path="student.sid" size="10" readonly="true"/><br/> 
Course id:<form:input path="course.cid" size="10" readonly="true"/><br/> 
 Course Name:<form:input path="course.cname" size="10"  readonly="true"/><br/> 
  Credit:<form:input path="course.credit" size="10" readonly="true"/><br/> 
  
attendence<form:input path="attendence" size="10" /><br/> 
Score: <form:input path="score" size="50"  /><form:errors path="score" cssStyle="color:red;"/> <br/>
<input type="submit" value="Submit"/><br/>
<input type="reset" value="Cancel"/><br/>

</form:form>
</body>
</html>