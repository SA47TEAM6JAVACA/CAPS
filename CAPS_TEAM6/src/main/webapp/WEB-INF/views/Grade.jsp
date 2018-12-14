<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/StudentCourse/edit/${studentcourse.scid}" method="POST" modelAttribute="studentcourse">
Student Course ID:<form:input path="scid" size="10" readonly="true"/><br/>
Student id:<form:input path="student.sid" size="10" readonly="true"/><br/> 
Course id:<form:input path="course.cid" size="10" readonly="true"/><br/> 
 Course Name:<form:input path="course.cname" size="10"  readonly="true"/><br/> 
  Credit:<form:input path="course.credit" size="10" readonly="true"/><br/> 
  
attendence<form:input path="attendence" size="10" /><br/> 
Score: <form:input path="score" size="50"  type="number" name="num" min="1" max="10"/><form:errors path="score" cssStyle="color:red;"/> <br/>
<input type="submit" value="Submit"/><br/>
<input type="reset" value="Cancel"/><br/>

</form:form>
</body>
</html>