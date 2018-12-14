<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>

<script>
	$(document).ready(function() {
		$("#datepicker1").datepicker({
			dateFormat : "yy/dd/mm"

		});
	});
	$(document).ready(function() {
		$("#datepicker2").datepicker({
			dateFormat : "yy/dd/mm"
		});
	});
</script>
<ul class="sidelist">
	<c:forEach var="listMapview" items="${sessionScope.USERSESSION.link}">

		<li><a href="${listMapview.value}"> ${listMapview.key}</a></li>

	</c:forEach>
</ul>
<hr>
<style>
.firsttable {
	float: left;
}

#content {
	overflow: auto;
	width: 600px;
	background: gray;
}

#left {
	float: left;
	width: 20%;
}

#right {
	overflow: hidden;
	width: 80%;
}

.ui-datepicker {
	background: #333;
	border: 1px solid #555;
	color: #EEE;
}
</style>
<h1>This is the user new form</h1>
<div id="content">
	<form:form action="${pageContext.request.contextPath}/Admin/newCourse"
		mehtod="POST" modelAttribute="course">
		<div id="left">
			<div>ID:</div>
			<div>Name:</div>
			<div>Credit:</div>
			<div>Start Date:</div>
			<div>End Date:</div>
			<div>Fee:</div>
			<div>Room:</div>
			<div>Student limit:</div>
			<div>Student limit:</div>
		</div>

		<div id="right">
			<div>
				<form:input path="cid" size="11" />
			</div>
			<div>
				<form:input path="cname" size="45" />
			</div>
			<div>
				<form:input path="credit" size="10" />
			</div>
			<div>
				<fmt:formatDate value="${course.startdate}" pattern="yyyy/mm/dd"
					var="startd" />
				<form:input path="startdate" size="20" value="${startd}"
					id="datepicker1" />
			</div>
			<div>
				<fmt:formatDate value="${course.enddate}" pattern="yyyy/mm/dd"
					var="endd" />
				<form:input path="enddate" size="20"  value="${endd}" id="datepicker2" />
			</div>
			<div>
				<form:input path="fee" size="20" />
			</div>
			<div>
				<form:input path="room" size="11" />
			</div>
			<div>
				<form:input path="studentlimit" size="11" />
			</div>
		</div>
		<br />
		<input type="submit" value="Submit" />
		<input type="reset" value="Cancel" />
		<br />
	</form:form>
</div>