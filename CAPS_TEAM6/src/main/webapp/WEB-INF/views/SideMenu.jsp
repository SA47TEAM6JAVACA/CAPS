<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<body><head>

	
</head>
<c:forEach var="listMapview" items="${sessionScope.USERSESSION.link}"> 

	 <a href="${pageContext.request.contextPath}/student/${listMapview.value}">
  	 ${listMapview.key}</a>
   
</c:forEach>

<%-- <c:forEach var="listMapview" items="${sessionScope.USERSESSION.link}">
 --%>			
					
				
					
<%-- </c:forEach> --%>

</ul>
</body>
</html>