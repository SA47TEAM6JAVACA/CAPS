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
<body>
<h2> Students taking course cid 1 :
 </h2>
  <c:if test="${fn:length(slist) gt 0}">
  <table>
     <tr> <th>NRIC</th> <th>FirstMiddleName</th> <th>LastName</th> </tr>
     <c:forEach items="${slist}" var="student">
     <tr> 
          <td> ${student.semail}  </td> 
          <td> ${student.firstmiddlename} </td></tr>
          <td> ${student.lastname} </td></tr>
     </c:forEach>
  </table>
 </c:if>
 
</body>
</html>