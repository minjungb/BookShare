$(document).ready(function(){
	$('#loginBtn').click(function(e){
		var username = $('#username').val();
		var password = $('#password').val();
		$.ajax({
			type: 'POST',
			url: 'http://localhost:8080/BookShare/LoginServlet',
			dataType: 'text', 
			data : {
				username : username,
				password : password
			},
			success : function(result){
				$('#errorMessage').html(result);
			},
			error : function(jqXHR, status){
				console.log(status);
			}
		});
	});
});