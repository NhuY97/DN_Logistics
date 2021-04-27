var $ = jQuery.noConflict();

$(document).ready(function() {

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


    // language i18n
    var firstTimeDropDown = true;
    var lang = getCookie("org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE");
    var langVi = lang.toLocaleLowerCase() === 'vi';
    lang = langVi ? 'vi' : 'en';
    var btnIcon = langVi ? 'flag-icon-vn' : 'flag-icon-us';
    var btnIconSecond = langVi ? 'flag-icon-us' : 'flag-icon-vn';

    $('#btn-icon').removeClass().addClass('flag-icon ' + btnIcon);
    $('#btn-change-lang').click(
        function () {
            if (firstTimeDropDown) {
                $('#btn-icon-second').removeClass().addClass('flag-icon ' + btnIconSecond);
                $('#link-change-lang').attr('href', '?lang=' + (langVi ? 'en' : 'vi'));
                $('#link-change-lang').append(langVi ? ' English' : ' Vietnamese');
                firstTimeDropDown = false;
            }
        }
    );
});

function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i <ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}
