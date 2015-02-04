
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> --%>
<%-- <h1><fmt:message key="person.search.title"/></h1>

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
</table> --%>
            
            
   <html>
   <head>
   <script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
   <script type="text/javascript">
   alert('alive')
   </script>
   </head>
   
   <h1 align="center"> WELCOME TO APPRAISAL PORTAL </h1>
	  <div style="margin: 13% 0% 0% 38%;width:auto;height:auto"> 
	   <form action="<c:url value='j_spring_security_check' />" method="post">
	<table>
	<tr>
		<td style="padding-right:10px">Email Id</td>
	    <td><input type="text" name="username"><br></td>
	</tr>   
	<tr>
		<td style="padding-right:10px">password</td>
	    <td><input type="password" name="password"><br></td>
	</tr> 
	 </table>
	    
	    <input type="submit" value="login" style="margin-left:96px"><br>
	  
	   
	   </form>
      </div>
   </html>         