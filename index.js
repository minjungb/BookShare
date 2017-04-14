$(document).ready(function(){
	$('#loginBtn').click(function(e){
		var username = $('#username').val();
		var password = $('#password').val();
		
		if(username == ""){
            $('#errorMessage').html("Please enter a Username");
            //alert("Username is required");
            return;
        }
        if(password == ""){
            $('#errorMessage').html("Please enter a Password");
            return;
        }
		
		$.ajax({
			type: 'POST',
			url: 'http://localhost:8080/WebApp/LoginServlet',
			dataType: 'text', 
			data : {
				username : username,
				password : password
			},
			success : function(result){
				console.log(result);
				//$('#errorMessage').html(result);
				$(location).attr('href', 'userpage.html')
			},
			error : function(jqXHR, status){
				console.log(status);
			}
		});
	});
});