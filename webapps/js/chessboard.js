$(function(){
	var index = 0;
	var source;

    $('#boards tr td').click(function() {
      	var position = $(this).attr('id');
      	var value = index % 2;
      	
      	if ( value == 0 ) {
      		source = position;
      	} else {
      		$chessForm = $('#chessForm');
      		$chessForm.find('#source').val(source);
      		console.log($chessForm.find('#source').val());
      		$chessForm.find('#target').val(position);
      		console.log($chessForm.find('#target').val());
      		$chessForm.submit();
      	}
      	
      	index++;
      	return false;
    });
});