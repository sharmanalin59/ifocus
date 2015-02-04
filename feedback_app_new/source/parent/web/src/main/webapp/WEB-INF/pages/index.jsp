<%-- <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<tiles:insertDefinition name="layout">
    <tiles:putAttribute name="body">
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<h1><fmt:message key="person.search.title"/></h1>

<table class="search">
    <tr>
        <th><fmt:message key="person.form.firstName"/></th>
        <th><fmt:message key="person.form.lastName"/></th>
    </tr>
<c:forEach var="person" items="${persons}" varStatus="status">
    <tr>
        <c:set var="personFormId" value="person${status.index}"/>

        <c:url var="editUrl" value="/person/form.html">
            <c:param name="id" value="${person.id}" />
        </c:url>
        <sec:authorize ifAllGranted="ROLE_ADMIN">
            <c:url var="deleteUrl" value="/person/delete.html"/>
            <form id="${personFormId}" action="${deleteUrl}" method="POST">
                <input id="id" name="id" type="hidden" value="${person.id}"/>
            </form>
        </sec:authorize>

        <td>${person.firstName}</td>
        <td>${person.lastName}</td> 
        <td>
            <a href='<c:out value="${editUrl}"/>'><fmt:message key="button.edit"/></a>
            <sec:authorize ifAllGranted="ROLE_ADMIN">
                <a href="javascript:document.forms['${personFormId}'].submit();"><fmt:message key="button.delete"/></a> 
            </sec:authorize>
        </td>
    </tr>
</c:forEach>
</table>
            
            
   <head>
       <script src='<c:url value="/resources/scripts/bootstrap.min.js"/>'></script>
   <link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/bootstrap.min.css"/>'>
    <style ref='<c:url value="/resources/css/bootstrap.min.css"/>'></style>
   <script type="text/javascript">
  /*   */ 
   $(document).ready(function(){
	  /*  alert('${success}'); */ 
  }); 
   </script>
   </head>
   <h1 align="center"> WELCOME TO APPRAISAL PORTAL </h1>
<div style="background-color:grey;z-index:-1;border-style:solid;border-width: 1px;">
	  <div style="margin: 13% 0% 0% 38%;width:auto;height:auto"> 
	   <form action="<c:url value='/j_spring_security_check' />" method="post">
	<table>
	<tr>
		<td style="padding-right:10px">Email Id</td>
	    <td><input id="username" type="text" name="username"><br></td>
	</tr>   
 
	<tr>
		<td style="padding-right:10px">Password</td>
	    <td><input type="password" name="password"><br></td>
	</tr> 
	<c:if test="${success == false}">
 	<tr>
 	<td></td><td style="color:red;">username and password don't match</td>
 	</tr>
 	</c:if>
	 </table>
	    <input type="submit" class="btn btn-success" value="login" style="margin-left:96px"><span style="margin-left:43px"><a href="<c:url value='/password/forgotten/page'/>"">forgot password</a></span><br>
	  
	   
	   </form>
      </div>    
      </div>   
   </tiles:putAttribute>
   </tiles:insertDefinition> --%>
   
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   
   <head>
   <script src='<c:url value="/resources/js/jquery-1.11.2.min.js"/>'></script>
    <script src="<c:url value="/resources/scripts/Common.js"/>"></script>
       <script src='<c:url value="/resources/scripts/bootstrap.min.js"/>'></script>
       <script src='<c:url value="/resources/js/script.js"/>'></script>
       
   <link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/bootstrap.min.css"/>'>
   <link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/style.css"/>'>
    <%-- <style ref='<c:url value="/resources/css/bootstrap.min.css"/>'></style> --%>
   <!-- <script type="text/javascript">
  /*   */ 
   $(document).ready(function(){
	  /*  alert('${success}'); */ 
  }); 
   </script> -->
   <script>
   function forgotPassword(){
		  var email = $('#recovery-email').val();
		  if(email == ""){
			  $('#message3').css("display","").delay(2000).fadeOut(1000);
		  	 $('#message1').css("display","none")
			  $('#message2').css("display","none")
		  }
			  else{
		  var url = '${pageContext.request.contextPath}/password/link?emailId='+email;
		  //alert(url)
		 ajaxPost(url,{},call,"application/json","GET",true);
			  }
		 //alert(email+'dd')
		
   }
   function call(data){
		  //alert(data.status)
		  var status = data.status;
		  var mess = data.message;
		  $('#message1').text(mess);
		  $('#message1').css("display","").delay(2000).fadeOut(1000);
		  $('#message3').css("display","none")
		  /* 
		  if(status == true){
			  $('#message1').css("display","").delay(2000).fadeOut(1000);
			  $('#message2').css("display","none")
			  $('#message3').css("display","none")
		  }
			  else{
				  $('#message3').css("display","none")
				  $('#message2').css("display","").delay(2000).fadeOut(1000);
				  $('#message1').css("display","none")
			  } */
	  }
   </script>
   </head>
   
   
   <section id="login">
    <div class="container">
    	<div class="row">
    	    <div class="col-xs-12">
        	    <div class="form-wrap">
                <h1>Log in with your email account</h1>
                    <form role="form" action="<c:url value='/j_spring_security_check' />" method="post" id="login-form" autocomplete="off">
                        <div class="form-group">
                            <label for="email" class="sr-only">Email</label>
                            <input type="email" name="username" id="email" class="form-control" placeholder="somebody@example.com">
                        </div>
                        <div class="form-group">
                            <label for="key" class="sr-only">Password</label>
                            <input type="password" name="password" id="key" class="form-control" placeholder="Password">
                        </div>
                        <div class="checkbox">
                            <span class="character-checkbox" onclick="showPassword()"></span>
                            <span class="label">Show password</span>
                        </div>
                        <input type="submit" id="btn-login" class="btn btn-custom btn-lg btn-block" value="Log in">
                    </form>
                    <a href="javascript:;" class="forget" data-toggle="modal" data-target=".forget-modal">Forgot your password?</a>
                    <hr>
        	    </div>
    		</div> <!-- /.col-xs-12 -->
    	</div> <!-- /.row -->
    </div> <!-- /.container -->
</section>

<div class="modal fade forget-modal" tabindex="-1" role="dialog" aria-labelledby="myForgetModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">×</span>
					<span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title">Recovery password</h4>
			</div>
			<div class="modal-body">
				<p>Type your email account</p>
				<input type="email" name="recovery-email" id="recovery-email" class="form-control" autocomplete="off">
				<p id="message1" style="color:red;display:none"></p>
				<!-- <p id="message2" style="color:red;display:none">email address doesn't exist</p> -->
				<p id="message3" style="color:red;display:none">please provide your email address</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
				<button type="button" class="btn btn-custom" onclick="forgotPassword()">Recovery</button>
			</div>
		</div> <!-- /.modal-content -->
	</div> <!-- /.modal-dialog -->
</div> <!-- /.modal -->

<footer id="footer">
    <div class="container">
        <div class="row">
            <div class="col-xs-12">
                <p>Page © - 2015</p>
                <p>Powered by <strong><a href="http://www.facebook.com/tavo.qiqe.lucero" target="_blank">IFocusSystec/a></strong></p>
            </div>
        </div>
    </div>
</footer>