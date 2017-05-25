/**
 * external javascript functions
 * Created by Daniel on 2017/5/5.
 */
function signOut() {
    //TODO confirm
    $.ajax("/sign/out",{
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
    loadOnFrame("/page/welcome");

    $('.nav.child_menu>li>a').click(function(){
        loadOnFrame($(this).attr('href'));
    });
});
