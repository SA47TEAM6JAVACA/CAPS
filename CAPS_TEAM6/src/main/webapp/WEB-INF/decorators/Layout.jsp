<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<c:url value="/css/style.css" var="ss"/>
<link rel="STYLESHEET" type="text/css"
	href="${ss}" />
</head>
<body>
<div class="wrap">
<div class="logo">

<img src="file:///C:/Users/dodo/git/CAPS/CAPS_TEAM6/logo.jpeg" 	>
</div>
<div class="header"><%@include file="Menu.jsp"%>
</div>



<!-- ========= Body =========== -->

<div class="content">
<br><dec:body />
</div>


<!-- ======== Footer ======== -->

	<div class="footer" align="center">
				  <hr>
					<small> &copy; ISS NUS SA47 2018 </small>
				</div>
</div>
	
			
</body>
</html>
