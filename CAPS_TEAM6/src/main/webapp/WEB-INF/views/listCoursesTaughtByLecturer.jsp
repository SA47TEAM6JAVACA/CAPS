<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<ul class="sidelist">
		<c:forEach var="listMapview" items="${sessionScope.USERSESSION.link}">

<<<<<<< HEAD
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
=======
<link href="<c:url value='/styles/style.css'/>" rel="stylesheet"
    type="text/css" />
 
>>>>>>> stash
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


 
  <c:if test="${fn:length(clist) gt 0}">
  <table>
     <tr> <th>Name</th> <th>Credit</th> <th>Start Date</th> <th>End Date</th> <th>Room</th></tr>
     <c:forEach items="${clist}" var="course">
     <tr> <td> ${course.cname} </td> 
          <td> ${course.credit} </td> 
          <td> ${course.startdate} </td> 
          <td> ${course.enddate} </td> 
          <td> ${course.room} </td> 
     </c:forEach>
  </table>
 </c:if>
 


</body>
</html>