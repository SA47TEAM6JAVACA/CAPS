<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
<script>
	$(document).ready(function() {
		$("#datepicker1").datepicker({
			dateFormat : "yy/mm/dd"
		});
	});
	$(document).ready(function() {
		$("#datepicker2").datepicker({
			dateFormat : "yy/mm/dd"
		});
	});
</script>
	<ul class="sidelist">
		<c:forEach var="listMapview" items="${sessionScope.USERSESSION.link}">

			<li><a
				href="${listMapview.value}">
					${listMapview.key}</a></li>

		</c:forEach>
	</ul>

	<hr>
<h1>This is the Course edit page</h1>
<form:form action="${pageContext.request.contextPath}/Admin/newCourse"
	mehtod="POST" modelAttribute="course">
  ID:<form:input path="cid" size="11" readonly="true" />
	<br />
  Name: <form:input path="cname" size="45" />
	<br />
  Credit:<form:input path="credit" size="10" />
	<br />
	<fmt:formatDate value="${course.startdate}" pattern="yyyy/mm/dd"
		var="startd" />
  Start Date:<form:input path="startdate" size="20" value="${startd}"
		id="datepicker1" />
	<br />
	<fmt:formatDate value="${course.enddate}" pattern="yyyy/mm/dd"
		var="endd" />
  End Date:<form:input path="enddate" size="20" value="${endd}"
		id="datepicker2" />
	<br />
  Fee:<form:input path="fee" size="20" />
	<br />
  Room:<form:input path="room" size="11" />
	<br />
  Student limit:<form:input path="studentlimit" size="11" />
	<br />
	<input type="submit" value="Submit" />
	<br />
	<input type="reset" value="Cancel" />
	<br />
</form:form>