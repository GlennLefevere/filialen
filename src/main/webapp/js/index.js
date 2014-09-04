$(window).load(function() {
	$.getJSON("filialen", function(data) {
		for (var i = 0; i < data.length; i++) {
			var $nieuw = $('<option>').attr("value", data[i].id.toString());
			$nieuw.text(data[i].naam);
			$('#niet').append($nieuw);
		}
	}).done(function() {
		/*
		 * $('option').dblclick(function (e){ if($(this).parent().attr('id') ===
		 * 'niet'){ $(this).appendTo('#wel'); } else{ $(this).appendTo('#niet'); }
		 * controle(); });
		 */
		$('select').dblclick(function(e) {
			if (this.id === 'niet') {
				$(this).find(':selected').appendTo('#wel');
			}
			else{
				$(this).find(':selected').appendTo('#niet');
			}
		});
	});

	/*
	 * $('select').on('dblclick','option', function (e){
	 * if($(this).parent().attr('id') === 'niet'){ $(this).appendTo('#wel'); }
	 * else{ $(this).appendTo('#niet'); } controle(); });
	 */

	$('.knop').button();
	$('#right').on("click", function() {
		$('#niet > option:selected').appendTo('#wel');
		controle();
	});
	$('#allright').on("click", function() {
		$('#niet > option').appendTo('#wel');
		controle();
	});
	$('#left').on("click", function() {
		$('#wel > option:selected').appendTo('#niet');
		if ($('#wel').children().length == 0) {
		}
		controle();
	});
	$('#allleft').on("click", function() {
		$('#wel > option').appendTo('#niet');
		controle();
	});

	$('#form').submit(function(e) {
		e.preventDefault();
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
			data : JSON.stringify(optVals),
			success : function(data, textStatus) {
				console.log(data);
			},
			error : function(xhr, textStatus, errorThrown) {
			},
			complete : function(data) {
				window.location.href = "bevestigen";
			}
		});
	});
});

function controle() {
	if ($('#wel > option').length === 0) {
		$("#afwaarderen").prop('disabled', true);
	} else {
		$("#afwaarderen").prop('disabled', false);
	}
}