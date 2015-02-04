<%-- <head>
    <script src='<c:url value="/resources/js/jquery-1.11.2.min.js"/>'></script>
    <script src="<c:url value="/resources/scripts/Common.js"/>"></script>
       <script src='<c:url value="/resources/scripts/bootstrap.min.js"/>'></script>
       <script src='<c:url value="/resources/js/script.js"/>'></script>
       
   <link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/bootstrap.min.css"/>'>
   <link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/style.css"/>'>
<script>
 /*    $('.dropdown-toggle').click(){
    	alert('')
    }; */
    alert('t')
    $(document).ready(function(){
    	// $('.dropdown-toggle').dropdown();
    	alert('t')
  	  var url = '${pageContext.request.contextPath}/group/getGroups';
  	  alert(url)
    	 ajaxPost(url,{},successMethod,"application/json","GET",true);
    });
/*     $(".dropdown-menu li a").click(function(){
    	 var selText = $(this).text();
    	 $(this).parents('.btn-group').find('.dropdown-toggle').html(selText+'<span class="caret"></span>');
    	 alert('')
	
    }); */

    $('.dropdown-menu li').on('click', function(){
        alert('')
    	//$('#datebox').val($(this).text());
    });
    function successMethod(data){
    	if(data != null){
    		var success = data.success;
    		var groups = data.data;
    		//alert(groups);
    		var dropDownMenu = '';
    		for(var i=0;i<groups.length;i++){
    			var id = groups[i].groupId;
    			/* dropDownMenu +=  '<li role="presentation" id="'+id+'">'+
    			'<a role="menuitem" tabindex="-1" href="#">'+groups[i].groupName+'</a></li>'; */
    			dropDownMenu += '<option>'+groups[i].groupName+'</option>';
    			//alert(groups[i].groupId)
    		}
    		/* $('.dropdown-group').html(dropDownMenu); */
    		$('.dropdown').html(dropDownMenu);
    	}
    }
    function changeTabs(d){
    	var c = $('.a');
    	alert(d.class)
    }
    function addEmployee(){
    	$('#firstname').val();
    	$('#lastname').val();
    	var employeeId = $('#employeeId').val();
    	var emailId = $('#emailId').val();
    	var phoneNo = $('#phoneNo').val();
    	$('#').val();
    	$('#').val();
    	$('#').val();
    }
</script>
</head> --%>