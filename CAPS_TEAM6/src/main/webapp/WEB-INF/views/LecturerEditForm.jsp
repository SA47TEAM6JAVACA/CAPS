<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <form:form action="${pageContext.request.contextPath}/lecturer/new.html" method="POST" modelAttribute="lecturer">
    ID: <form:input path="lid" size="10" readonly="true"/> <br/>
    Name: <form:input path="firstmiddlename" size="40"/> <br/>
    EMAIL: <form:input path="lemail" size="50" /> <br/>
    PASSWORD: <form:input path="lpassword" size = "200"/> <br/>
    <input type="submit" value ="Submit"/> <br/>
    <input type="reset" value ="Cancel"/> <br/>
  </form:form>
</body>
</html>