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
  function submitEmail(){
	  var email = $('#username').val();
	  alert(email)
	  var url = '${pageContext.request.contextPath}/password/link?emailId='+email;
	 ajaxPost(url,{},call,"application/json","GET",false);
  }
  function call(data){
	  alert(data)
  }
   </script>
   </head>
   
   <h2 align="center"> </h2>
	  <div style="margin: 13% 0% 0% 38%;width:auto;height:auto"> 
	<%--    <form action="<c:url value='/password/forgotten/page' />" method="post"> --%>
	<table>
	<tr>
		<td style="padding-right:10px">Email Id</td>
	    <td><input id="username" type="text" name="username"><br></td>
	</tr>   

	 </table>
	    <input type="button" value="submit" style="margin-left:84px" onclick="submitEmail()">
	    	<c:if test="${success == false}">
  
 	
	    <span style="margin-left:33px;color:red;">Email not found</span>
	    
	    </c:if>
	    <c:if test="${success==true}">
	    
	    <span style="margin-left:33px;color:red;">a link has been sent to your mail</span>
	    
	    </c:if>
	    
	    
	    <br>
	  
	   
	  <%--  </form> --%>
      </div>       
   </tiles:putAttribute>
   </tiles:insertDefinition>