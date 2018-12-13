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
<form:form action="${pageContext.request.contextPath}/StudentCourse/listgrade/edit.html" method="POST" modelAttribute="elist">
  Student Name:<form:input path="student.firstmiddlename" size="10" readonly="true"/><br/>
  Course Name:<form:input path="course.cname" size="10"  readonly="true"/><br/>
  Credit:<form:input path="course.credit" size="10" readonly="true"/><br/>
  Score:<form:input path="StudentCourse.score " size="10" /><br/>
<input type="submit" value="Submit"/><br/>
<input type="reset" value="Cancel"/><br/>

</form:form>
</body>
</html>