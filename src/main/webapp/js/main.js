$(function(){
    var a = $('.nav2-1').attr("title");
    $('.a').attr("src",a);
    $('.nav2-0').click(function () {
        $(this).addClass('nav-hover').siblings().removeClass('nav-hover');
        var a = $(this).attr("title");
        document.body.scrollTop = document.documentElement.scrollTop = 0;
        $('.a').attr("src",a);
    });
})
