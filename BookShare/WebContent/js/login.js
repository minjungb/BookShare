$("#loginBtn").click(function(){
	var username = $("#username").val();
	var password = $("#password").val();
	jQuery.ajax({
		type: "POST",
		url: loginServlet,
		contentType: "text/plain",
		dataType: "text",
		data : {
			username : username,
			password : password
		},
		success : function(result){
			$("#errorMessage").html(data);
		},
		error : function(jqXHR, status){
			console.log(status);
		}
	 
	});
});