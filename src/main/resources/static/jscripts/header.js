$(document).ready(function() {
    $('.headerm_burger').click(function(event){
        $('.headerm_burger,.header_menu').toggleClass('active');
        $('body').toggleClass('lock');
    });
});