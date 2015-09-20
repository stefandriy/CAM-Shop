/* header background */
setInterval(function(){insertLine();}, 100);
function insertLine () {
  var headback = document.getElementById("headback");
  var str = headback.innerHTML;
  if (str.length > 1400) {
  		str = str.substring(0,1400);
  }
  headback.innerHTML = getOneLine() + str;
}
function getOneLine () {
  var line = " ";
  for (var i=0; i<100; i++) {
    line += Math.round(Math.random()) + ' ';
  }
  return line;
}

/* category dropdown */
jQuery(document).ready(function($) {
   $(document).ready(function(){
   	$.easing.def="easeInOutQuad";
   	$('li.button a').click(function(e){
   		var dropDown=$(this).parent().next();
   		//$('.dropdown').not(dropDown).slideUp('slow');
   		dropDown.slideToggle('slow');
   		e.preventDefault();
   		})
   	});
});