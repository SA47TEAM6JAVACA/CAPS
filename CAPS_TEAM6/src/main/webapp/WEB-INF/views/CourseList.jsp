<html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<a href="${pageContext.request.contextPath}/student/enroll">Enroll new course</a>
  
  <table>
     <tr>
       <td>#</td>
       <th>Course Name</th>
       <th>Course Credit</th>
       <th>Start Date</th>
       <th>End Date</th>
       <th>Fee</th>
       
   
    </tr>
<c:forEach items="${courses}" var="course" varStatus="index">
     <tr>
       <td>${index.index+1}</td>
       <td>${course.cname}</td>
       <td>${course.credit}</td>
       <td>${course.startdate}</td>
       <td>${course.enddate}</td>
       <td>${course.fee}</td>
       
    </tr>
</c:forEach>
</table>

</body>
</html>