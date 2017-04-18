$(document).ready(function(){
	$('#createPost').click(function(e){
		var title = $('#book-title').val();
		var isbn = $('#isbn').val();
		var author = $('#author').val();
		var edition = $('#edition').val();
		var desc = $('#post-description').val();
		var funct = "create";
		//var className
		//var user
		$.ajax({
			type: 'POST',
			url: 'http://localhost:8080/BookShare/PostServlet',
			//dataType: 'text',
			data: {
				title: title,
				isbn: isbn,
				author: author,
				edition: edition,
				desc: desc,
				funct: funct
			},
			success : function(result){
				alert(result);
			},
			error : function(jqXHR, status){
				console.log(status);
			}
		});
	});
});