$(function(){
	var index = 0;
	var source;

    $('#boards tr td').click(function() {
      	var position = $(this).attr('id');
      	var value = index % 2;
      	
      	if ( value == 0 ) {
      		source = position;
      	} else {
      		var queryString = 'source=' + source + '&target=' + position;
    		$.ajax({
	            type : 'get',
	            url : '/api/move',
	            data : queryString,
	            dataType : 'json',
	            error: function() {
	            	console.log('failure')
	            },
	            success : function(result) {
	            	var sourceSymbol = $('#' + result.source.charPosition).html();
	            	$('#' + result.target.charPosition).html(sourceSymbol);
	            	$('#' + result.source.charPosition).html('');
	            }
	        });
      	}
      	
      	index++;
      	return false;
    });
    
    
});