$('#contact-modal').easyModal({
  overlayOpacity : 0.6,
  overlayClose: true,
  overlayColor: "#000"
});
$('#open-contact-modal').click(function(e){
  $('#contact-modal').trigger('openModal');
  e.preventDefault();
});