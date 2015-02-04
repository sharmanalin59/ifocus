<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
   <head>
   <script src="<c:url value="/resources/scripts/jquery-1.11.2.min.js" />"></script>
  <script type="text/javascript">
   </script>
   </head>
   <body>
    <div class="page">
        <tiles:insertAttribute name="header" />
        <div style="height:590px" class="content">
        <tiles:insertAttribute name="menu" />
            <tiles:insertAttribute name="body" />
        </div>
        <tiles:insertAttribute name="footer" />
    </div>
    </body>
</html>