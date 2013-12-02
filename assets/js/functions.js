$('#contact-modal').easyModal({
  overlayOpacity : 0.6,
  overlayClose: true,
  overlayColor: "#000"
});
$('#open-contact-modal').click(function(e){
  $('#contact-modal').trigger('openModal');
  e.preventDefault();
});

$('#contact-form').submit(function(form) {
	alert("submitting");
	$(form).ajaxSubmit({
		type:"POST",
		data: $(form).serialize(),
		url:"process.php",
		success: function() {
			alert("success");
		},
		error: function() {
			alert("error");
		}
	});
	return false;
});