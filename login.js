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
                                alert(result);
                                var res = client.responseText();
                                $('#errorMessage').html(res);
			},
			error : function(jqXHR, status){
				console.log(status);
			}
		});
	});
});