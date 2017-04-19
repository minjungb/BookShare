$(document).ready(function(){
	$('#createPost').click(function(e){
		var title = $('#book-title').val();
		var isbn = $('#isbn').val();
		var author = $('#author').val();
		var edition = $('#edition').val();
		var desc = $('#post-description').val();
		var contact = $('#contact-info').val();
		var funct = "create";

		$.ajax({
			type: 'POST',
			url: 'http://localhost:8080/BookShare/PostServlet',
			dataType: 'text',
			data: {
				title: title,
				isbn: isbn,
				author: author,
				edition: edition,
				desc: desc,
				contact: contact,
				funct: funct
			},
			success : function(result){
				$('#content').html(result);
			},
			error : function(jqXHR, status){
				console.log(status);
			}
		});
	});
});