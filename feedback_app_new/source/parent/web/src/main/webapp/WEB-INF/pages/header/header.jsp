<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
 <script src="<c:url value="/resources/scripts/Common.js"/>"></script>
    <script src='<c:url value="/resources/js/jquery-1.11.2.min.js"/>'></script>
    <script src="<c:url value="/resources/scripts/Common.js"/>"></script>
       <script src='<c:url value="/resources/scripts/bootstrap.min.js"/>'></script>
       <script src='<c:url value="/resources/js/script.js"/>'></script>
       
   <link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/bootstrap.min.css"/>'>
   <link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/style.css"/>'>
</head>


<nav class = "navbar navbar-inverse" role="navigation">
<h3 style="text-align: center;color:#9d9d9d">Appraisal Cycle</h3>
	<div style="float:right">
	<ul class="nav navbar-nav">
<!-- 	<li class="active"><a href="#">ios</a></li>
	<li><a href="#">ios</a></li> -->
	 <li class="dropdown">
	    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Employee <b class="caret"></b></a>
	    <ul class="dropdown-menu">
	    <li><a href="#">Manager</a></li>
	    <li><a href="#">Profile</a></li>
	    <li><a href="#">Settings</a></li>
	    <li><a href="<c:url value='/logout' />">Logout</a></li>
	    </ul>
	 </li>
	</ul>
	</div>
	<div style="float:right" class="navbar-header">
		<div class="navbar-brand" href="#">Welcome <strong><sec:authentication property="principal.username"/></strong></div>
	</div>

</nav>