<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<<<<<<< HEAD
<body>
  <form:form action="${pageContext.request.contextPath}/lecturer/list.html" method="POST" modelAttribute="lecturer">
     ID: <form:input path="lid" size="10" readonly="true"/> 
    FirstName: <form:input path="firstmiddlename" size="40"/> <form:errors path="firstmiddlename" cssStyle="color:red;"/><br/>
    LastName: <form:input path="lastname" size="40"/> <form:errors path="firstmiddlename" cssStyle="color:red;"/><br/>
    EMAIL: <form:input path="lemail" size="50" /><form:errors path="lemail" cssStyle="color:red;"/> <br/>
    PASSWORD: <form:input path="lpassword" size = "200"/><form:errors path="lpassword" cssStyle="color:red;"/> <br/>
=======
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

  <form:form action="${pageContext.request.contextPath}/lecturer/new.html" method="POST" modelAttribute="lecturer">
    ID: <form:input path="lid" size="10" readonly="true"/> <br/>
    Name: <form:input path="firstmiddlename" size="40"/> <br/>
    EMAIL: <form:input path="lemail" size="50" /> <br/>
    PASSWORD: <form:input path="lpassword" size = "200"/> <br/>
>>>>>>> stash
    <input type="submit" value ="Submit"/> <br/>
    <input type="reset" value ="Cancel"/> <br/>
  </form:form>

</body>
</html>