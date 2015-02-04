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
	  var confirmPassword = $('#confirmPassword').val();
	  alert('${token}')
	  var url = '${pageContext.request.contextPath}/password/update/pass';
	  var passwordDTO = {};
	  passwordDTO.password = confirmPassword;
	  passwordDTO.userId = '${userId}';
	  passwordDTO.appendedString = '${token}';
		 ajaxPost(url,JSON.stringify(passwordDTO),isChanged,"application/json","POST",false);
  }
  function isChanged(data){
	  if(data != null){
			  $('#message').text(data.message)
			  $('#message').delay(3000).fadeOut(1000);
			  $('#password').val('');
			  $('#confirmPassword').val('');
	  }
  } 
   </script>
   </head>
   
   <h2 align="center"> </h2>
	<%--   <div style="margin: 13% 0% 0% 38%;width:auto;height:auto"> 
	   <form action="<c:url value='/password/forgotten/page' />" method="post">
	<table>
	<p>Please enter your new password</p>
	<tr>
		<td style="padding-right:10px">Password</td>
	    <td><input id="password" type="password" ><br></td>
	  <tr>
	  </tr>    
	    <td style="padding-right:10px">Confirm Password</td>
	    <td><input id="confirmPassword" type="password" ><br></td>
	</tr>   

	 </table>
	    <input type="button" value="submit" style="margin:0px 10px 0px 164px;color:red" onclick="validate()"><!-- <span id="message"></span> -->
	  
	   
	   </form>
      </div> --%>     
      
      
      
      
      <div class="panel-body">
<form style="margin :100px 0 200px 350px;width:500px" class="form-horizontal" role="form">
<div class="form-group">
	<label style="float:left" for="firstname" class="cl-sm-4 control-label">Password</label>
	<div style="float:right" class="col-sm-9">
	<input type="password" class="form-control" id="password" placeholder="enter a password">
	</div>
</div>

<div class="form-group">
	<label style="float:left" for="lastname" class="cl-sm-2 control-label">Confirm Password</label>
	<div style="float:right" class="col-sm-9">
	<input type="password" class="form-control" id="confirmPassword" placeholder="confirm password">
	</div>
</div>
<button type="button" class="btn btn-primary" onclick="validate()">Change</button><span style="margin-left:20px;color:red" id="message"></span>
</form>

</div>
        
   </tiles:putAttribute>
   </tiles:insertDefinition>