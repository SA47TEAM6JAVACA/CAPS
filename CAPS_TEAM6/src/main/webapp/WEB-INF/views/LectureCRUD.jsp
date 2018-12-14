<html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
<body>

<ul class="sidelist">
<c:forEach var="listMapview" items="${sessionScope.USERSESSION.link}"> 

	<li>
					 <a href="${listMapview.value}">
  					 ${listMapview.key}</a>
  					 
  	</li>							 
      
</c:forEach>
</ul>	
<hr>
<a href="${pageContext.request.contextPath}/lecturer/new">Add Lecturer</a>
  
  <table>
     <tr>
       <td>#</td>
       <td>Id</td>
       <td>FirstName</td>
       <td>LastName</td>
       <td>Password</td>
       <td>E-mail</td>
      <td>EDIT</td>
      <td>DELETE</td>
    </tr>
<c:forEach items="${lecturers}" var="lecturer" varStatus="index">
     <tr>
       <td>${index.index+1}</td>
       <td>${lecturer.lid}</td>
       <td>${lecturer.firstmiddlename}</td>
       <td>${lecturer.lastname}</td>
       <td>${lecturer.lpassword}</td>
       <td>${lecturer.lemail}</td>
       <td><a href="${pageContext.request.contextPath}/lecturer/edit/${lecturer.lid}">EDIT</a>></td>
       <td><a href="${pageContext.request.contextPath}/lecturer/delete/${lecturer.lid}">DELETE</a>></td>
      
    </tr>
</c:forEach>
</table>

</body>
</html>