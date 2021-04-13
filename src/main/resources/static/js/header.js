var $ = jQuery.noConflict();

$(document).ready(function() {
    jQuery('ul.sf-menu').superfish({
        animation: {
            height: 'show'
        },
        delay: 100
    });
    $("#toggle-btn").click(function() {
        $(".sf-menu").slideToggle("slow");
    });

    $('.toggle-subarrow').click(
        function() {
            $(this).parent().toggleClass("mob-drop");
        });

    $(this).find(".h4 i").each(function(){
        $(this).addClass("green");
    });
});
