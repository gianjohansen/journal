$('#contact-modal').easyModal({
  overlayOpacity : 0.6,
  overlayClose: true,
  overlayColor: "#000"
});
$('#open-contact-modal').click(function(e){
  $('#contact-success-modal').trigger('openModal');
  e.preventDefault();
});
$('#contact-success-modal').easyModal({
  overlayOpacity : 0.6,
  overlayClose: true,
  overlayColor: "#000"
});

$('#contact-form').submit(function(form) {
$.ajax({
          dataType: 'jsonp',
          url: "http://getsimpleform.com/messages/ajax?form_api_token=eca2adb05b1ade6f67db49e9bdab0822",
          data: $('#contact-form').serialize() 
        }).done(function() {
			$('#contact-success-modal').trigger('openModal');
        });
        return false; //to stop the form from submitting

});