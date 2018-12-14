<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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



<fieldset>  
<form:form modelAttribute="studentcourse" action="${pageContext.request.contextPath}/StudentCourse/Manageenrol/${courseid}" method="get">

<form:select path="course.cname"
items="${courses}" />


 
<input id="submit" type="submit" tabindex="5"
value="Select course">
 </fieldset>

</form:form> 

</body>
</html>