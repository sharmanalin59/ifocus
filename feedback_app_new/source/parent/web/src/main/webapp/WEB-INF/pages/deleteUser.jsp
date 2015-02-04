<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tiles:insertDefinition name="layout">
    <tiles:putAttribute name="body">
    <head>
    
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/dataTables.jqueryui.css'/>">
<script type="text/javascript" charset="utf8" src="<c:url value='/resources/scripts/jquery.dataTables.min.js'/>"></script>
<script type="text/javascript" charset="utf8" src="<c:url value='/resources/scripts/dataTables.bootstrap.js'/>"></script>
<script type="text/javascript">
    $(document).ready(function() {
    	var name = '${user.firstName}'+' '+'${user.lastName}';
    	console.log(name)
    	if(name != ' '){
    		//name = '<strong>'+name+'</strong>';
    		$('#deletedUser').text('user with name '+name+' has been successfully deleted!')
    		$('#deletedUser').css("display","");
    		
    	}
		var url = '${pageContext.request.contextPath}/admin/get-users';
		ajaxPost(url, {}, successUsers, "application/json", "GET", true);
    	
 
    } );
    function successUsers(data){
    	//alert( )
    	//var json = JSON.stringify(data.data[1]);
  /*   	delete json.userId;
    	delete json.lastName;
    	
    	var j = {
    		"Name" : "Rajiv",
    		"EmployeeId" : "rrr"
    	}
    	var son = JSON.stringify(j)
    	alert() */
    	var table = $('#example').DataTable( {
    		//"sAjaxSource": "${pageContext.request.contextPath}/admin/get-users",
    		   // "sAjaxDataProp": "data",
    		   aaData: data.data,
    		/*     "columns": [
    		                { "data": "firstName" },
    		                { "data": "lastName" },
    		            ], */
    		            
           "aoColumns": [
                         {   "sClass": "center",
                             "fnRender": function( oObj ) {
                            	// alert(JSON.stringify(oObj))
                            	 //var json = oObj;
                            	 //json
                            	 var userId = oObj.aData.userId;
                            	 var name = oObj.aData.firstName +' '+oObj.aData.lastName; 
                                 return '<a href="${pageContext.request.contextPath}/welcome/delete-user/userId/' + userId + '">' + name +'</a>';
                             } 
                         },
                         
                         {   "sClass": "center",
                             "fnRender": function( oObj ) {	
                            	 var userId = oObj.aData.userId;
                            	 var empId = oObj.aData.employeeId; 
                                 return '<a href="${pageContext.request.contextPath}/welcome/delete-user/userId/' + userId + '">' + empId +'</a>';
                             } 
                         },
                         ]
    	} );
    	 
    	//table.ajax.url( data.data ).load();
    	//table.api().ajax.reload();
    }
    </script>
     </head>
<div style="mrgin-left:50px">

<ul class="nav nav-tabs">
<li class="add-user" onclick="changeTabs(this)"><a href="<c:url value='/welcome/goto' />">Add User</a></li>
<li class="modify-user" onclick="changeTabs(this)"><a href="<c:url value='/welcome/modify-user' />">Modify User</a></li>
<li class="active remove-user" onclick="changeTabs(this)"><a href="<c:url value='/welcome/delete-user' />">View/Delete User</a></li>
</ul>
</div>
<!-- deleted user message -->
<div class="bs-example">
    <div class="alert alert-success">
        <a href="#" class="close" data-dismiss="alert">&times;</a>
        <p id="deletedUser" style="display:none"><strong>Success!</strong> User with Name successfully.</p>
    </div>
</div>

<div style="margin: 50px 0 0 250px; width: 800px"
			class="panel panel-danger">
			<div style="align: center" class="panel-heading">
				<h3 class="panel-title" style="margin-left: 255px">Delete User</h3>
			</div>
			<div class="panel-body">
				<form style="margin-left: 155px; width: 500px"
					class="form-horizontal" role="form">
			
					</form>
					
					<table id="example" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>Name</th>
                <th>Employee Id</th>

            </tr>
        </thead>
 
        <tfoot>
            <tr>
                  <th>Name</th>
                <th>Employee Id</th>
            </tr>
        </tfoot>

    </table>
			</div>
		</div>			



</tiles:putAttribute>
</tiles:insertDefinition>