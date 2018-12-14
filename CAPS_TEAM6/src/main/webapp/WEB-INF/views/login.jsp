<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html><title>Insert title here</title>
<head>
<link href="<c:url value='/styles/style.css'/>" rel="stylesheet"
	type="text/css" />


</head> <body>
<div >
<form:form modelAttribute="user" method="post" action="${pageContext.request.contextPath}/common/authenticate/${user.role }" >
	<table class="framed" style="margin:auto;width:300px;display:block" >
		<tr>
			<td>
			Username:
			<td colspan="3"><form:input path="username" size="40" />
			<form:errors path="username"  /></td>
		</tr>
		<tr>
			<td>Password</td>
			<td colspan="3"><form:password path="pass" size="40" />
			<form:errors path="pass" />
			</td>
		</tr>
		<tr>
			<td colspan="4">&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>
			<form:button name="submit" type="submit" value="s">
					<img src="${pageContext.request.contextPath}/image/button_login.gif" alt="" align="middle">
				</form:button></td>
			<td>
			<form:button name="clear" type="reset" value="r">
					<img src="${pageContext.request.contextPath}/image/button_clear.gif" alt="" align="middle">
				</form:button>
				</td>
		</tr>
	</table>
	
</form:form>

</div></body>
</html>