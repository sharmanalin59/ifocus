<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tiles:insertDefinition name="layout">
	<tiles:putAttribute name="body">
		<head>
<script>
	/*    $('.dropdown-toggle').click(){
	   	alert('')
	   }; */
	var radioInternal = '';
	   var groupId = '';
	$(document).ready(function() {
		// $('.dropdown-toggle').dropdown();
		/* alert('dd') */
		var url1 = '${pageContext.request.contextPath}/group/getGroups';
		ajaxPost(url1, {}, successMethod, "application/json", "GET", true);

		var url2 = '${pageContext.request.contextPath}/admin/get-users/4';
		ajaxPost(url2, {}, successManagers, "application/json", "GET", true);

		var url3 = '${pageContext.request.contextPath}/admin/get-users/2';
		ajaxPost(url3, {}, successApprovers, "application/json", "GET", true);

		var url4 = '${pageContext.request.contextPath}/admin/get-roles';
		ajaxPost(url4, {}, successRoles, "application/json", "GET", true);
		
		var feedbackFrequencyType = 1;
		var groupId = -1;
		var appraisalFrequencyType = 1;
		var url5 = '${pageContext.request.contextPath}/admin/getFeedbackFrequencyType/'+feedbackFrequencyType+'/groupId/'+groupId;
		ajaxPost(url5, {}, successFeedback, "application/json","GET", true);
		var url5 = '${pageContext.request.contextPath}/admin/getAppraisalFrequencyType/'+appraisalFrequencyType+'/groupId/'+groupId;
		ajaxPost(url5, {}, successAppraisal, "application/json","GET", true);

	});
	
	function successAppraisal(data) {
		if(data != null){
			var af = data.data.appraisalFrequency;
			$('#af').val(af)
		}
	}
	
	function successFeedback(data) {
				if(data != null){
					var ff = data.data.feedbackFrequency;
					$('#ff').val(ff)
				}
			}

	
	function successRoles(data) {
		if (data != null) {
			if (data.status) {
				var dropDownMenu = "";
				var roles = data.data;
				if (roles != null) {
					for (var i = 0; i < roles.length; i++) {
						var role = roles[i];
						dropDownMenu += '<option value="'+role.roleId+'">'
								+ role.roleDescription + '</option>';
					}
					$('.dropdown-roles').html(dropDownMenu);
				}

			}
		}
	}
	function successApprovers(data) {
		var dropDownMenu = "";
		var approvers = data.data;
		for (var i = 0; i < approvers.length; i++) {
			var approver = approvers[i];
			dropDownMenu += '<option value="'+approver.userId+'">'
					+ approver.firstName + ' ' + approver.lastName
					+ '</option>';
		}
		$('.dropdown-approvers').html(dropDownMenu);
	}
	function successManagers(data) {
		var dropDownMenu = "";
		var managers = data.data;
		for (var i = 0; i < managers.length; i++) {
			var manager = managers[i];
			dropDownMenu += '<option value="'+manager.userId+'">'
					+ manager.firstName + ' ' + manager.lastName + '</option>';
		}
		$('.dropdown-managers').html(dropDownMenu);
	}
	/*     $(".dropdown-menu li a").click(function(){
	 var selText = $(this).text();
	 $(this).parents('.btn-group').find('.dropdown-toggle').html(selText+'<span class="caret"></span>');
	 alert('')
	
	 }); */
	/* 
	 $('.dropdown-menu li').on('click', function(){
	 alert('')
	 //$('#datebox').val($(this).text());
	 }); */
	function successMethod(data) {
		if (data != null) {
			var success = data.success;
			var groups = data.data;
			//alert(groups);
			var dropDownMenu = '';
			for (var i = 0; i < groups.length; i++) {
				var id = groups[i].groupId;
				/* dropDownMenu +=  '<li role="presentation" id="'+id+'">'+
				'<a role="menuitem" tabindex="-1" href="#">'+groups[i].groupName+'</a></li>'; */
				dropDownMenu += '<option id="'+id+'">' + groups[i].groupName
						+ '</option>';
				//alert(groups[i].groupId)
			}
			/* $('.dropdown-group').html(dropDownMenu); */
			//alert(dropDownMenu);
			$('.dropdown-group').html(dropDownMenu);
		}
	}
	/*     function changeTabs(d){
	 var c = $('.a');
	 alert('d.class')
	 } */
	/* 
	 $('input:radio[name="internal"]').change(
	 function(){
	 if ($(this).is(':checked') && $(this).val() == 'Yes') {
	 // append goes here
	 alert('')
	 }
	 });  */
	function onRadioChange(data) {
		if (data != null) {
			radioInternal = data.id;
			alert(radioInternal)
		}
	}
	 
	 function appraisalType(obj){
		 alert(obj.id)
	 }
	 
	function addEmployee() {
		var user = {};
		user.userId = null;
		user.firstName = $('#firstName').val();
		user.lastName = $('#lastName').val();
		user.employeeId = $('#employeeId').val();
		user.photo = 'dsfgsfgfdzghgdhdfz';
		user.gender = $('.dropdown-gender').val();
		user.emailAddress = $('#emailId').val();
		user.phoneNumber = JSON.parse($('#phoneNo').val());
		user.groupId = 1;//$('.dropdown-group').val();

		var managers = $('.dropdown-managers').val();
		var approvers = $('.dropdown-approvers').val();
		user.password = 'xyz';
		var roles = $('.dropdown-roles').val();
		user.roleIds = JSON.parse("[" + roles + "]");
		user.experience = 13.4;
		user.skillset = $('#skills').val();
		user.ctc = JSON.parse($('#ctc').val());
		user.approverId = JSON.parse(approvers);
		user.approverType = 5;
		//alert()
		user.managerIds = JSON.parse("[" + managers + "]");//[1,2];
		user.feedbackFrequencyType = 1;
		user.appraisalFrequencyType = 14;
		user.lastHikePercentage = 27;
		user.feedbackFrequency = 5;
		user.appraisalFrequency = 5;
		alert('radioInternal  : ' + radioInternal)
		if (radioInternal == '') {
			alert('select internal')
		} else if (radioInternal == 'radio-internal-yes')
			user.isInternal = true;
		else if (radioInternal == 'radio-internal-no')
			user.isInternal = false;
		var url = '${pageContext.request.contextPath}/admin/createUser';
		//alert(JSON.stringify(user));
		ajaxPost(url, JSON.stringify(user), successCreate, "application/json",
				"POST", true);
	}
	function successCreate(data) {
		/* alert(data.status+'ddd') */
		$('#addedMessage').css("display", "");
		if (!data.status)
			$('#addedMessage').text('could not save!!');
		$('#addedMessage').delay(3000).fadeOut(1000);
	}
	function appraisalType(obj){
		$('#af').attr("Readonly","Readonly");
		var appraisalFrequencyType = obj.id;
		var appraisalFrequencyTypeVal = '';
		var gId = -1;
		if('radio-aft-group' == appraisalFrequencyType)
			appraisalFrequencyTypeVal = 2;
		else if('radio-aft-system' == appraisalFrequencyType)
			appraisalFrequencyTypeVal = 1;
		else if('radio-aft-other' == appraisalFrequencyType){
			$('#af').removeAttr("Readonly");
			$('#af').val('');
			return -1;
		}
		if(appraisalFrequencyTypeVal == 1)//system defaults
		 var url = '${pageContext.request.contextPath}/admin/getAppraisalFrequencyType/'+appraisalFrequencyTypeVal+'/groupId/'+gId;
		 if(appraisalFrequencyTypeVal == 2) {//group
			  groupId = $('.dropdown-group option:selected').attr('id');
			 if(groupId == ''){
				 alert('choose a group first!')
				 return -1;
			 }
			 url = '${pageContext.request.contextPath}/admin/getAppraisalFrequencyType/'+appraisalFrequencyTypeVal+'/groupId/'+groupId; 
		 }
		ajaxPost(url, {}, successAppraisal, "application/json","GET", true);
	}
	function selectedGroup(obj){
		groupId = obj.id;
		//if group is selected on feedback or appraisal then change its value to new group
		 var fId = $('#radio-fft-group').attr('checked');
		 var aId = $('#radio-aft-group').attr('id');
		 alert(fId)
		if(fId == 'radio-fft-group'){
			var url = '${pageContext.request.contextPath}/admin/getFeedbackFrequencyType/'+feedbackFrequencyTypeVal+'/groupId/'+groupId;	
			ajaxPost(url, {}, successFeedback, "application/json","GET", true);
			$('#ff')
		}
		if(aId == 'radio-fft-group'){
			var url = '${pageContext.request.contextPath}/admin/getFeedbackFrequencyType/'+feedbackFrequencyTypeVal+'/groupId/'+groupId;	
			ajaxPost(url, {}, successFeedback, "application/json","GET", true);
			$('#ff')
		}
	}
	function feedbackType(obj){
		$('#ff').attr("Readonly","Readonly");
		var feedbackFrequencyType = obj.id;
		var feedbackFrequencyTypeVal = '';
		var gId = -1;
		if('radio-fft-group' == feedbackFrequencyType)
			feedbackFrequencyTypeVal = 2;
		else if('radio-fft-system' == feedbackFrequencyType)
			feedbackFrequencyTypeVal = 1;
		else if('radio-fft-other' == feedbackFrequencyType){
			$('#ff').removeAttr("Readonly");
			$('#ff').val('');
			return -1;
		}
		if(feedbackFrequencyTypeVal == 1)//system defaults
		 var url = '${pageContext.request.contextPath}/admin/getFeedbackFrequencyType/'+feedbackFrequencyTypeVal+'/groupId/'+gId;
		 if(feedbackFrequencyTypeVal == 2) {//group
			  groupId = $('.dropdown-group option:selected').attr('id');
			 if(groupId == ''){
				 alert('choose a group first!')
				 return -1;
			 }
			 url = '${pageContext.request.contextPath}/admin/getFeedbackFrequencyType/'+feedbackFrequencyTypeVal+'/groupId/'+groupId; 
		 }
		ajaxPost(url, {}, successFeedback, "application/json","GET", true);
	}
</script>
		</head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>GO TO JSP</title>
		<%-- <h3 align="center">welcome <strong><sec:authentication property="principal.username"/></strong></h3> --%>

		<div style="mrgin-left: 50px">

			<ul class="nav nav-tabs">
				<li class="active a" onclick="changeTabs(this)"><a
					href="<c:url value='/welcome/goto' />">Add User</a></li>
				<li class="" onclick="changeTabs(this)"><a
					href="<c:url value='/welcome/modify-user' />">Modify User</a></li>
				<li class="" onclick="changeTabs(this)"><a href="<c:url value='/welcome/delete-user' />">View/Delete
						User</a></li>
			</ul>
		</div>
		<div style="margin: 50px 0 0 250px; width: 800px"
			class="panel panel-danger">
			<div style="align: center" class="panel-heading">
				<h3 class="panel-title" style="margin-left: 255px">Add a User</h3>
			</div>
			<div class="panel-body">
				<form style="margin-left: 155px; width: 500px"
					class="form-horizontal" role="form">
					<div class="form-group">
						<label style="float: left" for="firstname"
							class="cl-sm-4 control-label">first name</label>
						<div style="float: right" class="col-sm-8">
							<input type="text" class="form-control" id="firstName"
								placeholder="enter employee first name">
						</div>
					</div>

					<div class="form-group">
						<label style="float: left" for="lastname"
							class="cl-sm-2 control-label">last name</label>
						<div style="float: right" class="col-sm-8">
							<input type="text" class="form-control" id="lastName"
								placeholder="enter employee last name" >
						</div>
					</div>

					<div class="form-group">
						<label style="float: left" for="lastname"
							class="cl-sm-2 control-label">employee id</label>
						<div style="float: right" class="col-sm-8">
							<input type="text" class="form-control" id="employeeId"
								placeholder="enter employee's id">
						</div>
					</div>

					<div class="form-group">
						<label style="float: left" for="lastname"
							class="cl-sm-2 control-label">email id</label>
						<div style="float: right" class="col-sm-8">
							<input type="email" class="form-control" id="emailId"
								placeholder="enter employee's email id">
						</div>
					</div>

					<div class="form-group">
						<label style="float: left" for="lastname"
							class="cl-sm-2 control-label">phone number</label>
						<div style="float: right" class="col-sm-8">
							<input type="text" class="form-control" id="phoneNo"
								placeholder="enter employee's phone number">
						</div>
					</div>

					<div class="form-group">
						<label style="float: left" for="lastname"
							class="cl-sm-2 control-label">skills</label>
						<div style="float: right" class="col-sm-8">
							<input type="text" class="form-control" id="skills"
								placeholder="enter employee's skills">
						</div>
					</div>
					<div class="form-group">
						<label style="float: left" for="lastname"
							class="cl-sm-2 control-label">ctc</label>
						<div style="float: right" class="col-sm-8">
							<input type="text" class="form-control" id="ctc"
								placeholder="enter employee's ctc">
						</div>
					</div>
						<div class="form-group">
						<label style="float: left" for="lastname"
							class="cl-sm-2 control-label">appraisal frequency type</label>
						<div style="float: right; width: 336px; float: right" class="">
							<label class="radio-inline"> <input type="radio"
								name="aft" id="radio-aft-system" checked="checked"
								onClick="appraisalType(this)">system
							</label> 
							<label class="radio-inline"> <input type="radio"
								name="aft" id="radio-aft-group"
								onClick="appraisalType(this)">group
							</label>
							<label class="radio-inline"> <input type="radio"
								name="aft" id="radio-aft-other"
								onClick="appraisalType(this)">other
							</label>
						</div>
					</div>
	
					<div class="form-group">
						<label style="float: left" for="lastname"
							class="cl-sm-2 control-label">appraisal frequency</label>
						<div style="float: right" class="col-sm-8">
							<input type="text" class="form-control" id="af"
								placeholder="enter employee's Appraisal Frequency" readonly="readonly">
						</div>
					</div>
					
					<div class="form-group">
						<label style="float: left" for="lastname"
							class="cl-sm-2 control-label">feedback frequency type</label>
						<div style="float: right; width: 336px; float: right" class="">
							<label class="radio-inline"> <input type="radio"
								name="fft" id="radio-fft-system" checked="checked"
								onClick="feedbackType(this)" >system
							</label> 
							<label class="radio-inline"> <input type="radio"
								name="fft" id="radio-fft-group"
								onClick="feedbackType(this)">group
							</label>
							<label class="radio-inline"> <input type="radio"
								name="fft" id="radio-fft-other"
								onClick="feedbackType(this)">other
							</label>
						</div>
					</div>

					<div class="form-group">
						<label style="float: left" for="lastname"
							class="cl-sm-2 control-label">feedback frequency</label>
						<div style="float: right" class="col-sm-8">
							<input type="text" class="form-control" id="ff"
								placeholder="enter employee's Feedback Frequency" readonly="readonly">
						</div>
					</div>

					<div class="form-group">
						<label style="float: left" for="lastname"
							class="cl-sm-2 control-label">employee group</label>
						<div style="float: right; width: 336px" class="">
							<!--  <div class="dropdown">
        <button style="" class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown">Default 	Group
        <span class="caret"></span></button>
        <ul class="dropdown-menu dropdown-group" role="menu" aria-labelledby="menu1">
          <li role="presentation"><a role="menuitem" tabindex="-1" href="#">CSS</a></li>
          <li role="presentation"><a role="menuitem" tabindex="-1" href="#">JavaScript</a></li>
          <li role="presentation" class="divider"></li>
          <li role="presentation"><a role="menuitem" tabindex="-1" href="#">About Us</a></li>
        </ul>
 </div> -->
							<select style="width: 322px; height: 35px" class="dropdown-group" onchange="selectedGroup(this)">

							</select>


						</div>
					</div>


					<div class="form-group">
						<label style="float: left" for="lastname"
							class="cl-sm-2 control-label">Gender</label>
						<div style="float: right; width: 336px; float: right" class="">
							<select style="width: 322px; height: 35px"
								class="dropdown-gender">
								<option>Male</option>
								<option>Female</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label style="float: left" for="lastname"
							class="cl-sm-2 control-label">Managers</label>
						<div style="float: right; width: 336px; float: right" class="">
							<select style="width: 322px; height: 100px"
								class="dropdown-managers" multiple>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label style="float: left" for="lastname"
							class="cl-sm-2 control-label">Role</label>
						<div style="float: right; width: 336px; float: right" class="">
							<select style="width: 322px; height: 100px"
								class="dropdown-roles" multiple>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label style="float: left" for="lastname"
							class="cl-sm-2 control-label">Approvers</label>
						<div style="float: right; width: 336px; float: right" class="">
							<select style="width: 322px; height: 35px"
								class="dropdown-approvers">
							</select>
						</div>
					</div>

					<div class="form-group">
						<label style="float: left" for="lastname"
							class="cl-sm-2 control-label">Internal</label>
						<div style="float: right; width: 336px; float: right" class="">
							<label class="radio-inline"> <input type="radio"
								name="internal" id="radio-internal-yes"
								onClick="onRadioChange(this)">yes
							</label> <label class="radio-inline"> <input type="radio"
								name="internal" id="radio-internal-no"
								onClick="onRadioChange(this)">no
							</label>
						</div>
					</div>
					<div class="form-group">
						<label style="float: left" for="inputfile">upload photo</label>
						<div style="float: right">
							<input type="file" id="inputfile">
						</div>
					</div>
					<button type="button" class="btn btn-primary"
						onClick="addEmployee()">Add</button>
					<span id="addedMessage"
						style="margin-left: 15px; display: none; color: red">saved
						successfully!!</span>
			</div>
			</form>
		</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
>
