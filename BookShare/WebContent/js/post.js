$(document).ready(function(){
  for(i = 0; i < 4; i++) {
  	var html= '<div id="div'+ i +'" />' +
	  			  '<h3>Book title</h3>' +
	  			  '<p>ISBN:</p>' +
	  			  '<p>Edition:</p>' +
	  			  '<p>Description</p>' +
	  		   '</div>';
    $('#postings').append(html);
  }
});