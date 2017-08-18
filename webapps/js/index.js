$(function(){
	var index = 0;

    $('#boards tr td').click(function() {
      	var position = $(this).attr('id');
      	var value = index % 2; 
      	if ( value == 0 ) {
      		$('#source').val(position);
      	} else {
      		$('#target').val(position);
      		
	    	var source = $('#source').val();
	    	if (source == '') {
	    		alert("이동할 말을 선택해 주세요.");
	    		$('#source').focus();
	    		return false;
	    	}
	    	var target = $('#target').val();
	     	if (target == '') {
	    		alert("이동할 지점을 입력해 주세요.");
	    		$('#target').focus();
	    		return false;
	    	}
	    	   	
	    	var moveUrl = "/move?source=" + source + "&target=" + target;
	    	$(location).attr('href',moveUrl);
      	}
      	
      	index++;
      	return false;
    });
});