$(document).ready(function (){
    if($('.mainSlider').length) {
        $('.topHeader').addClass('hasSlider');
        $('.mainSlider').slick({
            dots: true,
            arrows:false,
            slidesToShow: 1,

            parallax: true,

            autoplay: {
                delay:1000,
                stopOnLastSlide: false,
                disableOnInteraction: false,
                speed: 400
            },
        })

    }
})