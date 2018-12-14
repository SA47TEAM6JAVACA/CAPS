<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/css/style.css" var="ss"/>
<link rel="STYLESHEET" type="text/css"
	href="${ss}" />


<ul id="cmenu">

<li><a href="${pageContext.request.contextPath}/common/logout">Home</a></li>
<li><a href="${pageContext.request.contextPath}/common/login/admin">Admin Log In</a></li>
<li><a href="${pageContext.request.contextPath}/common/login/student">Student Log In</a></li>
<li><a href="${pageContext.request.contextPath}/common/login/lecturer">Lecturer Log In</a></li>
</ul>

