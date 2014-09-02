var vlag = false;
$(window).load(function() {
	$('.knop').button();
	$('#right').on("click", function() {
		vlag = true;
		$('#niet > option:selected').appendTo('#wel');
		controle();
	});
	$('#allright').on("click", function() {
		vlag = true;
		$('#niet > option').appendTo('#wel');
		controle();
	});
	$('#left').on("click", function() {
		$('#wel > option:selected').appendTo('#niet');
		if ($('#wel').children().length == 0) {
			vlag = false;
		}
		controle();
	});
	$('#allleft').on("click", function() {
		vlag = false;
		$('#wel > option').appendTo('#niet');
		controle();
	});
});

function controle(){
	if(!vlag){
		$("#afwaarderen").prop('disabled', true);
	}
	else{
		$("#afwaarderen").prop('disabled', false);
	}
}