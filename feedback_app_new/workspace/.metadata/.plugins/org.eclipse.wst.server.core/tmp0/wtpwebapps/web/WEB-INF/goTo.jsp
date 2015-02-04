<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GO TO JSP</title>
<h1 align="center">welcome <sec:authentication property="principal.username"/></h1>
</head>
<body>
<p align="center">GO TO JSP</p>
</body>
</html>