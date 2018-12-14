<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
 
<body>


  <h2> Student grades for cid 1 :
 </h2>
 <c:if test="${fn:length(elist) gt 0}">
  <table>
     <tr> <th>Student Name</th> <th>Course Name</th> <th>Credit</th> <th>Score</th> <th>Delete</th> </tr>
     <c:forEach items="${elist}" var="enrolment">
     <tr> 
          <td> ${enrolment.student.firstmiddlename}  </td> 
          <td> ${enrolment.course.cname}  </td> 
          <td> ${enrolment.course.credit}  </td> 
          <td> ${enrolment.score}  </td>
          <td><a href="${pageContext.request.contextPath}/StudentCourse/Manageenrol/delete/${enrolment.scid}">Delete</a></td>
         
          </tr>
     </c:forEach>
  </table>
 </c:if>


</body>
</html>