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
});
