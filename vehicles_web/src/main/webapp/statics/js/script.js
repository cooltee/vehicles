/**
 * external javascript functions
 * Created by Daniel on 2017/5/5.
 */

var contentPath = $('#contentPath').val();

function signOut() {
    //TODO confirm
    $.ajax(contentPath + "/sign/out",{
        success: function (result) {
            if (result === "success") {
                window.location.href = "/index";
            }
        }
    });
}

function loadOnFrame(target) {
    $.get(target, function(data){
        $(".framer").html(data);
    })
}

$(function () {
    loadOnFrame(contentPath + "/page/welcome");

    $('.chgPass-form input[type="text"], .chgPass-form input[type="password"], .chgPass-form textarea').on('focus', function() {
        $(this).removeClass('input-error');
    });

    //Form validation and submit
    $('.chgPass-form').on('submit', function(e) {

        var flag = true;
        $(this).find('input[type="password"]').each(function(){
            if( $(this).val() === "" ) {
                e.preventDefault();
                $(this).addClass('input-error');
                var msg = $('.msg');
                msg.addClass("msg-error");
                msg[0].innerText = "两次密码输入不相同，请重新输入！";
                flag = false;
            }
            else {
                $(this).removeClass('input-error');
            }
        });
        if (flag) {
            $.ajax(contentPath + "/chgPass",{
                data: $('#chgPassForm').serialize(),
                type: "POST",
                success: function (result) {
                    if (result === "success") {
                        $('.modal-chgPass').modal('hide');
                        new PNotify({
                            title: 'Success',
                            text: '密码修改成功！',
                            type: 'success',
                            styling: 'bootstrap3'
                        });
                    } else {

                    }
                }
            });
        }
        return false;
    })

});
