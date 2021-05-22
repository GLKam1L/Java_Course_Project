let wrapper = document.querySelector('.wrapper');

/*Looped*/
sliderPerView = new Swiper('.page', {
    wrapperClass: "page_wrapper",
    slideClass: "page_screen",

    //Вертикальный слайдер
    direction: 'vertical',

    //Количество слайдов для показа
    slidesPerView: 'auto',

    // Включаем параллакс
    parallax: true,

    //Управление клавиатурой
    keyboard: {
        //Включать\выключить
        enabled: true,
        //Включить\выключить
        //только когда слайдер
        //в пределах вьюпорта
        onlyInViewport: true,
        //Включить\выключить
        //Управление клавишами
        //pageUp,pageDown
        padeUpDown: true,
    },

    // Управление колесом мыши
    mousewheel: {
        // Чувствительность колеса мыши
        sensitivity: 1,
        //Класс объекта на котором будет срабатывать прокрутка мышью.
        //eventsTarget: ".image-slider"
    },

    // Отключение функционала
    // если слайдов меньше чем нужно
    watchOverflow: true,

    speed: 800,

    //Обновить свайпер
    //При изменении лементов слайдера
    observer: true,

    //Обновить свайпер
    //при изменении родительских элементов слайдера
    observeParents: true,

    //Обновить свайпер
    //при изменении дочерних элементов слайда
    observeSlideChildren: true,

    //Навигация
    //Буллеты, текущее положение, прогрессбар
    pagination: {
        el: '.page_pagination',
        type: 'bullets',
        clickable: true,
        bulletClass: "page_bullet",
        bulletActiveClass: "page_bullet_active",
    },
    // Скролл
    scrollbar: {
        el: '.page_scroll',
        dragClass: "page_drag-scroll",
        // Возможность перетаскивать скролл
        draggable: true
    },

    init: false,


    on: {
        init: function() {
            menuSlider();
            setScrollType();
            wrapper.classList.add('_loaded');
        },
        slideChange: function() {
            menuSliderRemove();
            menuLinks[sliderPerView.realIndex].classList.add('_active');
        },
        resize: function () {
            setScrollType();
        }
    },
});

let menuLinks = document.querySelectorAll('.sec_menu_link');

function menuSlider() {
    if (menuLinks.length > 0) {
        menuLinks[sliderPerView.realIndex].classList.add('_active');
        for (let index = 0; index < menuLinks.length; index++) {
            const menuLink = menuLinks[index];
            menuLink.addEventListener("click", function (e) {
                menuSliderRemove();
                sliderPerView.slideTo(index, 800);
                menuLink.classList.add('_active');
                e.preventDefault();
            });
        }
    }
}

function menuSliderRemove() {
    let menuLinkActive = document.querySelector('.sec_menu_link._active');
    if( menuLinkActive){
        menuLinkActive.classList.remove('_active');
    }
}

function setScrollType () {
    if (wrapper.classList.contains('_free')){
        wrapper.classList.remove('_free');
        sliderPerView.params.freeMode = false;
    }

    for (let index = 0; index < sliderPerView.slides.length; index++) {
        const slidePerView = sliderPerView.slides[index];
        const slidePerViewContent = slidePerView.querySelector('.screen_content');
        if (slidePerViewContent) {
            const slidePerViewContentHeight = slidePerViewContent.offsetHeight;
            if (slidePerViewContentHeight > window.innerHeight) {
                wrapper.classList.add('_free');
                sliderPerView.params.freeMode = true;
                break;
            }
        }
    }
}


sliderPerView.init();

new Swiper('.swiper-container-v', {
    direction: 'vertical',
    pagination: {
        el: '.swiper-pagination-v',
        clickable: true,
    },
    nested: true,
});