<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2> Students taking course cid 1 :
 </h2>
  <c:if test="${fn:length(slist) gt 0}">
  <table>
     <tr> <th>NRIC</th> <th>Name</th> <th>Nick Name</th></tr>
     <c:forEach items="${slist}" var="student">
     <tr> 
          <td> ${student.semail}  </td> 
          <td> ${student.firstmiddlename} </td></tr>
     </c:forEach>
  </table>
 </c:if>
  <h2> Student grades for cid 1 :
 </h2>
 <c:if test="${fn:length(elist) gt 0}">
  <table>
     <tr> <th>Course Name</th> <th>Student Name</th> <th>Grade</th> <th>Mark</th></tr>
     <c:forEach items="${elist}" var="enrolment">
     <tr> <td> ${enrolment.course.cname} </td> 
          <td> ${enrolment.student.firstmiddlename}  </td> 
          <td> ${enrolment.score} </td>
          </tr>
     </c:forEach>
  </table>
 </c:if>
 


</body>
</html>