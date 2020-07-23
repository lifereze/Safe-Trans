$(function() {
$(".btn").click(function() {
$(".form-signin").toggleClass("form-signin-left");
$(".form-signup").toggleClass("form-signup-left");
$(".frame").toggleClass("frame-long");
$(".signup-inactive").toggleClass("signup-active");
$(".signin-active").toggleClass("signin-inactive");
$(".forgot").toggleClass("forgot-left");
$(this).removeClass("idle").addClass("active");
});
});

$(function() {
$(".btn-signup").click(function() {
$(".nav").toggleClass("nav-up");
$(".form-signup-left").toggleClass("form-signup-down");
$(".success").toggleClass("success-left");
$(".frame").toggleClass("frame-short");
});
});

$(function() {
$(".btn-signin").click(function() {
$(".btn-animate").toggleClass("btn-animate-grow");
$(".welcome").toggleClass("welcome-left");
$(".cover-photo").toggleClass("cover-photo-down");
$(".frame").toggleClass("frame-short");
$(".profile-photo").toggleClass("profile-photo-down");
$(".btn-goback").toggleClass("btn-goback-up");
$(".forgot").toggleClass("forgot-fade");
});
});
function doSlide (slider) {
  var id, o = slider.querySelectorAll("input.slide"), last = o.length-1, current = slider.querySelector("input.slide:checked");
  for (var i=0; i<o.length; i++) if (o[i] === current) {id = i; break;}
  o[id >= last ? 0 : id + 1].click();
}
function onSlide (e) {
  var o = e.target.parentNode;
  clearTimeout(o.autoslider);
  o.autoslider = setTimeout(function(){doSlide(o);}, 7e3);
}
$(function(){
  $(document).on("click", "input.slide", onSlide);
  $(".slider").each(function(){doSlide(this)});
});
