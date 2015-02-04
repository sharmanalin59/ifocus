<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<tiles:insertDefinition name="layout">
    <tiles:putAttribute name="body">
   <head>
  <%--  <script src="<c:url value="/resources/scripts/Common.js"/>"></script> --%>
   <script type="text/javascript">
  /*   */ 
   $(document).ready(function(){
	   // alert('${success}'); 
  }); 
  function validate(){
	  var password = $('#password').val();
	  alert(password)
  }
   </script>
   </head>
   
   <h2 align="center"> </h2>
	  <div style="margin: 13% 0% 0% 38%;width:auto;height:auto"> 
	<%--    <form action="<c:url value='/password/forgotten/page' />" method="post"> --%>
	<table>
	<tr>
		<td style="padding-right:10px;color:red">Password Link has Expired please retry!!</td>
	</tr>   

	 </table>
	  
	   
	  <%--  </form> --%>
      </div>       
   </tiles:putAttribute>
   </tiles:insertDefinition>