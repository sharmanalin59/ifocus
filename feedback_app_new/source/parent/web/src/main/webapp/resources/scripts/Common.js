function add(){
	alert('ss')
}
function ajaxPost(callingUrl, request, successCallback, contentType,
		methodType, syncType) {

	$.ajaxSetup({
		// Disable caching of AJAX responses
		cache : false
	});

	var ajaxRequest = {
		url : callingUrl,
		dataType : "json",
		type : methodType,
		data : request,
		async : syncType,
		success : function(data) {
			successCallback(data);
		}
	};
	if (contentType != null) {
		ajaxRequest.contentType = contentType;
	}
	$.ajax(ajaxRequest);
};