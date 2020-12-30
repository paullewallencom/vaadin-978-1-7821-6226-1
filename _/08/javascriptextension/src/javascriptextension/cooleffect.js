javascriptextension_CoolEffect = function() {
  var connectorId = this.getParentId();
  var element = this.getElement(connectorId);
  
  $(element).animate({marginTop: '80px', opacity: 0.0}, 0);
  $(element).animate({marginTop: '0px', opacity: 1.0}, 900);
};
