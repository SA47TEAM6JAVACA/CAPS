<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>This is the user new form</h1>
  <form:form action="${pageContext.request.contextPath}/ManagementCourseController/new.html" mehtod="POST" modelAttribute="course">
  ID:<form:input path="cid" size="11"/><br/>
  Name: <form:input path="cname" size="45"/><br/>
  Credit:<form:input path="credit" size ="10"/><br/>
  Start Date:<form:input path="startdate" size ="20"/><br/>
  End Date:<form:input path="enddate" size="20"/><br/>
  Fee:<form:input path="fee" size="20"/><br/>
  Room:<form:input path="room" size="11"/><br/>
  Student limit:<form:input path="studentlimit" size="11"/><br/>
  <input type="submit" value="Submit" /><br/>
  <input type="reset" value="Cancel" /><br/>
  </form:form>
</body>
</html>