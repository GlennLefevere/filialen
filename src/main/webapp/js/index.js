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

	$('#form').submit(function(e) {
		e.preventDefault();
		var form = $(this);
		var url = form.attr('action');
		var optVals = [];
		$('#wel > option').each(function() {
			optVals.push({
				id : $(this).val()
			});
		});
		console.log(JSON.stringify(optVals));
		$.ajax({
			type : 'POST',
			dataType : 'json',
			contentType : 'application/json',
			url : url,
			data : JSON.stringify(optVals),
			success : function(data, textStatus) {
				console.log(data);
				// alert("success");
			},
			error : function(xhr, textStatus, errorThrown) {
				// alert('request failed'+errorThrown);
			}
		});
	});
});

function controle() {
	if (!vlag) {
		$("#afwaarderen").prop('disabled', true);
	} else {
		$("#afwaarderen").prop('disabled', false);
	}
}