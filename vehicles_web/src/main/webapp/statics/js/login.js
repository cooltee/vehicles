/**
  * Created by Daniel on 2017/5/4.
  */
$(function() {

    //Fullscreen background
    $.backstretch('/assets/img/backgrounds/1.jpg');

    $('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea').on('focus', function() {
        $(this).removeClass('input-error');
    });

    //Form validation and submit
    $('.login-form').on('submit', function(e) {

        var flag = true;
        $(this).find('input[type="text"], input[type="password"], textarea').each(function(){
            if( $(this).val() === "" ) {
                e.preventDefault();
                $(this).addClass('input-error');
                flag = false;
            }
            else {
                $(this).removeClass('input-error');
            }
        });
        if (flag) {
            $.ajax("/sign/in",{
                data: $('#login-form').serialize(),
                type: "POST",
                success: function (result) {
                    if (result === "success") {
                        var redirectUrl = $('#redirectUrl').val();
                        window.location.href = redirectUrl ? redirectUrl : "/index";
                    } else {
                        var msg = $('.msg');
                        msg.addClass("msg-error");
                        msg[0].innerText = "用户名与密码不匹配，请重新输入！";
                        $('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea').each(function() {
                            $(this).addClass('input-error');
                        });
                    }
                }
            });
        } else {
            return false;
        }
    })

});