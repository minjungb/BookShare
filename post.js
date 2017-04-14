$(document).ready(function(){
	var funct = "fill";
	$.ajax({
		type: 'POST',
		url: 'http://localhost:8080/WebApp/PostServlet',
		dataType: 'html/text',
		data : {
			funct: funct
		},
		success : function(result){
			var num = result;
			for(i = 0; i < num; i++) {
				var html= '<div class="post" id="div'+ (num-i) +'" />' +
					  			  '<h3>Book title</h3>' +
					  			  '<p>ISBN:</p>' +
					  			  '<p>Edition:</p>' +
					  			  '<p>Description</p>' +
					  		   '</div>';
				$('#postings').append(html);
			}
			
		},
		error : function(jqXHR, status){
			console.log(status);
		}
	});
});