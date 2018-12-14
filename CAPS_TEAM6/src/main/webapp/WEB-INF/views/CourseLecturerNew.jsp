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
	function addrow(lectid,fname,lname,email) {
		var tr = tb.insertRow();
		var td1 = tr.insertCell(0);
		var td2 = tr.insertCell(1);
		var td3 = tr.insertCell(2);
		var td4 = tr.insertCell(3);
		td1.innerText = lectid;
		td2.innerText = fname;
		td3.innerText = lname;
		td4.innerText = email;	
		tr.onclick = function(){
            var cell = this.getElementsByTagName("td")[0];
            var id = cell.innerHTML;
            alert("Remove lecturer from this course" + id);
            $('tr:last', this).remove();
        };


	}
</script>
<h1>This is the Course edit page</h1>
<form:form action="${pageContext.request.contextPath}/Admin/newCourse"
	mehtod="POST" modelAttribute="course">
  ID:<form:input path="cid" size="11" readonly="true" />
	<br />
  Name: <form:input path="cname" size="45" />
	<br />
	<table class="borderAll">
		<tr>
			<th><s:message code="label.course.index" /></th>
			<th><s:message code="label.course.id" /></th>
			<th><s:message code="label.course.name" /></th>
			<th><s:message code="label.course.credit" /></th>
			<th><s:message code="label.course.room" /></th>
		</tr>
		<c:forEach items="${llist}" var="lecturer" varStatus="index">
			<tr class="${index.index%2==0?'even':'odd'}">
				<td class="nowrap">${index.index+1}</td>
				<td class="nowrap">${lecturer.lid}</td>
				<td class="nowrap">${lecturer.firstmiddlename}</td>
				<td class="nowrap">${lecturer.lastname}</td>
				<td class="nowrap">${lecturer.lemail}</td>
				<td><a
					href="${pageContext.request.contextPath}/Admin/addlecturer/${course.cid}/${lecturer.lid}.html">
						<s:message code="label.course.delete" />
				</a></td>
			</tr>
		</c:forEach>
	</table>

</form:form>