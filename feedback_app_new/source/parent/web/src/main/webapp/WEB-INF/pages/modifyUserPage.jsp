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
	   var presentGroupId = '';
	   var presentApproverId = '';
	   var presentManagerIds = [];
	   var presentRoleIds = [];
	   var userId = '';
	   var feedbackFrequency = '';
	   var appraisalFrequency = '';
	   var groupId = '';
	   $(document).ready(function() {
		// $('.dropdown-toggle').dropdown();
		userId = "${userId}";
		console.log(userId)
		 var url1 = '${pageContext.request.contextPath}/admin/get-user/'+userId;
		ajaxPost(url1, {}, getUser, "application/json", "GET", true);
		
	/*
		var url2 = '${pageContext.request.contextPath}/admin/get-users/4';
		ajaxPost(url2, {}, successManagers, "application/json", "GET", true);

		*/

	});
	function getUser(data){
		console.log(data)
		if(data != null){
			var user = data.data;
			if(user != null){
				if(user.firstName != "")
				$('#firstName').val(user.firstName);
				else
					$('#firstName').val("");
				if(user.lastName != "")
					$('#lastName').val(user.lastName);
					else
						$('#lastName').val("");
				
				if(user.employeeId != "")
					$('#employeeId').val(user.employeeId);
					else
						$('#employeeId').val("");
				
				if(user.emailAddress != "")
					$('#emailId').val(user.emailAddress);
					else
						$('#emailId').val("");
				
				if(user.phoneNumber != "")
					$('#phoneNo').val(user.phoneNumber);
					else
						$('#phoneNo').val("");
				
				if(user.skillset != "")
					$('#skills').val(user.skillset);
					else
						$('#skills').val("");
				
				if(user.ctc != "")
					$('#ctc').val(user.ctc);
					else
						$('#ctc').val("");
				
				if(user.appraisalFrequency != ""){
					$('#af').val(user.appraisalFrequency);
					appraisalFrequency = user.appraisalFrequency; 
				}
					else
						$('#af').val("");
				
				if(user.feedbackFrequency != ""){
					$('#ff').val(user.feedbackFrequency);
					feedbackFrequency = user.feedbackFrequency;
				}
					else
						$('#ff').val("");
				
				if(user.groupId != ""){
					presentGroupId = user.groupId;
					console.log('presentGroupId '+presentGroupId)
					}
				
				console.log('user.isInternal '+user.isInternal)
				//if(user.isInternal != ""){
					var status = user.isInternal;
					console.log('isInternal '+status)
					if(status){
					$('#radio-internal-yes').attr("checked","checked");
					radioInternal = 'radio-internal-yes';
					}
					else{
						$('#radio-internal-no').attr("checked","checked");
						radioInternal = 'radio-internal-no';
					}
					
					//}
				
				var url1 = '${pageContext.request.contextPath}/group/getGroups';
				ajaxPost(url1, {}, successGroups, "application/json", "GET", true);
				
				/* if(user.gender != "")
					$('#gender').val(user.gender);
					else
						$('#gender').val("");
			 */
			// console.log(user.managerIds);
				if(user.managerIds != null){
					presentManagerIds = user.managerIds;
					console.log('presentManagerIds '+presentManagerIds);
				}
				var url2 = '${pageContext.request.contextPath}/admin/get-users/4';
				ajaxPost(url2, {}, successManagers, "application/json", "GET", true);
				
				if(user.roleIds != null){
					presentRoleIds = user.roleIds;
					console.log('presentRoleIds '+presentRoleIds);
				}
				
				var url4 = '${pageContext.request.contextPath}/admin/get-roles';
				ajaxPost(url4, {}, successRoles, "application/json", "GET", true); 
				
				if(user.approverId != null){
					presentApproverId = user.approverId; 
					console.log('presentApproverId '+presentApproverId);
				}
				
				var url3 = '${pageContext.request.contextPath}/admin/get-users/2';
				ajaxPost(url3, {}, successApprovers, "application/json", "GET", true);
			
			}
		}

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
			$('#af').val(appraisalFrequency);
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
			$('#ff').val(feedbackFrequency);
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
	
	function successApprovers(data) {
		/* var dropDownMenu = "";
		var approvers = data.data;
		for (var i = 0; i < approvers.length; i++) {
			var approver = approvers[i];
			dropDownMenu += '<option value="'+approver.userId+'">'
					+ approver.firstName + ' ' + approver.lastName
					+ '</option>';
		}
		$('.dropdown-approvers').html(dropDownMenu); */
		
		
		
		
		if (data != null) {
			var success = data.success;
			var approvers = data.data;
			console.log('approvers '+approvers.length)
			//alert(groups);
			var dropDownMenu = '';
			for (var i = 0; i < approvers.length; i++) {
				var approver = approvers[i];
				var id = approver.userId;
				console.log('approver '+approver+' '+id)
				console.log('id '+id+' , '+'presentApproverId '+presentApproverId)
				if(presentApproverId == id){
					dropDownMenu += '<option id="'+id+'" selected>' + approver.firstName+' '+approver.lastName
					+ '</option>';
				}
				else{
					dropDownMenu += '<option id="'+id+'">' + approver.firstName+' '+approver.lastName
					+ '</option>';
				}
			}
			console.log(dropDownMenu)
			$('.dropdown-approvers').html(dropDownMenu);
		}
	}
	
	function successRoles(data) {

		var dropDownMenu = "";
		var roles = data.data;
		if(roles != null){
		for (var i = 0; i < roles.length; i++) {
			var role = roles[i];
			var roleId = role.roleId;
			var isRole = false;
			console.log('length '+roles.length)
			for(var j=0;j<presentRoleIds.length;j++){
				console.log('roleId '+roleId+'presentRoleIds[j] '+presentRoleIds[j])
					if(presentRoleIds[j] == roleId){
						isRole = true;
						break;
					}
			}
			if(isRole){
				console.log('isRole '+isRole)
				dropDownMenu += '<option value="'+role.roleId+'" selected>'
				+ role.roleDescription + '</option>';
			}
			else{
				dropDownMenu += '<option value="'+role.roleId+'">'
				+ role.roleDescription + '</option>';
			}
		
				
			}
		} 		
		$('.dropdown-roles').html(dropDownMenu);

	}
	
	function successManagers(data) {
		var dropDownMenu = "";
		var managers = data.data;
		if(managers != null){
		for (var i = 0; i < managers.length; i++) {
			var manager = managers[i];
			var managerId = manager.userId;
			var isManager = false;
			console.log(managers.length)
			for(var j=0;j<presentManagerIds.length;j++){
				//console.log('managerId '+managerId+'presentManagerIds[j] '+presentManagerIds[j])
					if(presentManagerIds[j] == managerId){
						isManager = true;
						break;
					}
			}
			if(isManager){
				console.log(isManager)
				dropDownMenu += '<option value="'+manager.userId+'" selected>'
				+ manager.firstName + ' ' + manager.lastName + '</option>';
			}
			else{
				dropDownMenu += '<option value="'+manager.userId+'">'
				+ manager.firstName + ' ' + manager.lastName + '</option>';
			}
		
				
			}
		}	
		$('.dropdown-managers').html(dropDownMenu);
	}
	
	function successGroups(data) {
		if (data != null) {
			var success = data.success;
			var groups = data.data;
			//alert(groups);
			var dropDownMenu = '';
			for (var i = 0; i < groups.length; i++) {
				var id = groups[i].groupId;
				if(presentGroupId == id){
					console.log('id '+id+' , '+'presentGroupId '+presentGroupId)
					dropDownMenu += '<option id="'+id+'" selected>' + groups[i].groupName
					+ '</option>';
				}
				else{
					dropDownMenu += '<option id="'+id+'">' + groups[i].groupName
					+ '</option>';
				}
			}
			$('.dropdown-group').html(dropDownMenu);
		}
	}

	function onRadioChange(data) {
		if (data != null) {
			radioInternal = data.id;
			alert(radioInternal)
		}
	}
	function modifyEmployee() {
		var user = {};
		user.userId = userId;
		user.firstName = $('#firstName').val();
		user.lastName = $('#lastName').val();
		user.employeeId = $('#employeeId').val();
		user.photo = 'dsfgsfgfdzghgdhdfz';
		user.gender = $('.dropdown-gender').val();
		user.emailAddress = $('#emailId').val();
		user.phoneNumber = JSON.parse($('#phoneNo').val());
		user.groupId = 1;//$('.dropdown-group').val();
		
		//var managers = $('.dropdown-managers').val();
		var managerIds = [];
		$('.dropdown-managers option:selected').each(function(){
			 //alert($(this).text() + ' ' + $(this).val());
			 var managerId = $(this).val();
			 managerIds.push(managerId)
			 
		});
		//var approver = $('.dropdown-approvers').val();
		var approverId = $('.dropdown-approvers option:selected').attr('id');
		
		user.password = 'xyz';
		//var roles = $('.dropdown-roles').val();
		
		var roleIds = [];
		$('.dropdown-roles option:selected').each(function(){
			 alert($(this).text() + ' ' + $(this).val());
			 var roleId = $(this).val();
			 roleIds.push(roleId)
			 
		});
		
		if(roleIds != null)
		user.roleIds = JSON.parse("[" + roleIds + "]");
		else
			user.roleIds = JSON.parse("[]");
		
		user.experience = 13.4;
		user.skillset = $('#skills').val();
		
		user.ctc = JSON.parse($('#ctc').val());
		
		user.approverId = approverId;
		alert(approverId)
		user.approverType = 5;
		
		user.managerIds = JSON.parse("[" + managerIds + "]");//[1,2];
		user.feedbackFrequencyType = 1;
		user.appraisalFrequencyType = 14;
		var app = $('.appraisal option:selected').val();
		alert(app)
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
		var url = '${pageContext.request.contextPath}/admin/updateUser';
		alert(JSON.stringify(user));
		ajaxPost(url, JSON.stringify(user), successModify, "application/json",
				"POST", true);
	}
	function successModify(data) {
		/* alert(data.status+'ddd') */
		$('#addedMessage').css("display", "");
		if (!data.status)
			$('#addedMessage').text('could not modify!!');
		$('#addedMessage').delay(3000).fadeOut(1000);
	}
	function selectedGroup(obj){
		groupId = obj.id;
	}
</script>
		</head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>GO TO JSP</title>
		<%-- <h3 align="center">welcome <strong><sec:authentication property="principal.username"/></strong></h3> --%>

		<div style="mrgin-left: 50px">

			<ul class="nav nav-tabs">
				<li class=" a" onclick=""><a
					href="<c:url value='/welcome/goto' />">Add User</a></li>
				<li class="active" onclick="changeTabs(this)"><a
					href="<c:url value='/welcome/modify-user' />">Modify User</a></li>
				<li class="" onclick="changeTabs(this)"><a href="<c:url value='/welcome/delete-user' />">View/Delete
						User</a></li>
			</ul>
		</div>
		<div style="margin: 50px 0 0 250px; width: 800px"
			class="panel panel-danger">
			<div style="align: center" class="panel-heading">
				<h3 class="panel-title" style="margin-left: 255px">Modify User</h3>
			</div>
			<div class="panel-body">
				<form style="margin-left: 155px; width: 500px"
					class="form-horizontal" role="form">
					<div class="form-group">
						<label style="float: left" for="firstname"
							class="cl-sm-4 control-label">first name</label>
						<div style="float: right" class="col-sm-8">
							<input type="text" class="form-control" id="firstName">
						</div>
					</div>

					<div class="form-group">
						<label style="float: left" for="lastname"
							class="cl-sm-2 control-label">last name</label>
						<div style="float: right" class="col-sm-8">
							<input type="text" class="form-control" id="lastName">
						</div>
					</div>

					<div class="form-group">
						<label style="float: left" for="lastname"
							class="cl-sm-2 control-label">employee id</label>
						<div style="float: right" class="col-sm-8">
							<input type="text" class="form-control" id="employeeId">
						</div>
					</div>

					<div class="form-group">
						<label style="float: left" for="lastname"
							class="cl-sm-2 control-label">email id</label>
						<div style="float: right" class="col-sm-8">
							<input type="email" class="form-control" id="emailId">
						</div>
					</div>

					<div class="form-group">
						<label style="float: left" for="lastname"
							class="cl-sm-2 control-label">phone number</label>
						<div style="float: right" class="col-sm-8">
							<input type="text" class="form-control" id="phoneNo">
						</div>
					</div>

					<div class="form-group">
						<label style="float: left" for="lastname"
							class="cl-sm-2 control-label">skills</label>
						<div style="float: right" class="col-sm-8">
							<input type="text" class="form-control" id="skills">
						</div>
					</div>
					<div class="form-group">
						<label style="float: left" for="lastname"
							class="cl-sm-2 control-label">ctc</label>
						<div style="float: right" class="col-sm-8">
							<input type="text" class="form-control" id="ctc">
						</div>
					</div>
						<div class="form-group">
						<label style="float: left" for="lastname"
							class="cl-sm-2 control-label">appraisal frequency type</label>
						<div style="float: right; width: 336px; float: right" class="appraisal">
							<label class="radio-inline"> <input type="radio"
								name="aft" id="radio-aft-system"
								onClick="appraisalType(this)">system
							</label> 
							<label class="radio-inline"> <input type="radio"
								name="aft" id="radio-aft-group"
								onClick="appraisalType(this)">group
							</label>
							<label class="radio-inline"> <input type="radio"
								name="aft" id="radio-aft-other"
								onClick="appraisalType(this)"  checked="checked" >other
							</label>
						</div>
					</div>
					<div class="form-group">
						<label style="float: left" for="lastname"
							class="cl-sm-2 control-label">appraisal frequency</label>
						<div style="float: right" class="col-sm-8">
							<input type="text" class="form-control" id="af">
						</div>
					</div>
						<div class="form-group">
						<label style="float: left" for="lastname"
							class="cl-sm-2 control-label">feedback frequency type</label>
						<div style="float: right; width: 336px; float: right" class="feedback">
							<label class="radio-inline"> <input type="radio"
								name="fft" id="radio-fft-system"
								onClick="feedbackType(this)" >system
							</label> 
							<label class="radio-inline"> <input type="radio"
								name="fft" id="radio-fft-group"
								onClick="feedbackType(this)">group
							</label>
							<label class="radio-inline"> <input type="radio"
								name="fft" id="radio-fft-other"
								onClick="feedbackType(this)" checked="checked" >other
							</label>
						</div>
					</div>
					<div class="form-group">
						<label style="float: left" for="lastname"
							class="cl-sm-2 control-label">feedback frequency</label>
						<div style="float: right" class="col-sm-8">
							<input type="text" class="form-control" id="ff" >
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
						onClick="modifyEmployee()">Modify</button>
					<span id="addedMessage"
						style="margin-left: 15px; display: none; color: red">modified
						successfully!!</span>
						</form>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
