//javascript for postings.html
$(document).ready(function(){
	var funct = "fill";
	$.ajax({
		type: 'POST',
		url: 'http://localhost:8080/BookShare/PostServlet',
		dataType: 'json',
		data : {
			funct: funct
		},
		success : function(result){
			var json =  result;
			var num = json.count;
			for(i = 0; i < num; i++) {
				var html= '<div class="post">' +
					  			  '<h3 id="title'+(num-i)+'">Book title</h3>' +
					  			  '<p>ISBN: <span id="isbn'+(num-i)+'"></span></p>' +
					  			  '<p>Author: <span id="author'+(num-i)+'"></span></p>' +
					  			  '<p>Edition: <span id="edition'+(num-i)+'"></span></p>' +
					  			  '<p>Description: <span id="desc'+(num-i)+'"></span></p>' +
					  	  '</div>';
				$('#postings').append(html);
			}
			var posts = json.posts;
	
			for(i=0; i < num; i++){
				var title = '#title' + (num-i);
				var isbn = '#isbn' + (num-i);
				var author = '#author' + (num-i);
				var edition = '#edition' + (num-i);
				var desc = '#desc' + (num-i);
				
				$(title).html(posts[i].title.toString());
				$(isbn).html(posts[i].isbn.toString());
				$(author).html(posts[i].author.toString());
				$(edition).html(posts[i].edition.toString());
				$(desc).html(posts[i].description.toString());
			}
			
		},
		error : function(jqXHR, status){
			console.log(status);
		}
	});
}); 