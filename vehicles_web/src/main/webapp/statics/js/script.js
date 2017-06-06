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

var defaultDataTablesOption = {
    "lengthMenu": [5, 10, 20, 40],//定义在每页显示记录数的select中显示的选项
    "searching": true,//是否禁用搜索
    "lengthChange": true,//是否允许用户改变表格每页显示的记录数
    "paging": true,//开启表格分页
    "processing": true,//是否显示处理状态(排序的时候，数据很多耗费时间长的话，也会显示这个)
    "autoWidth": false,//是否自适应宽度
    "deferRender": true,//延迟渲染，可以提高初始化的速度
    "stateSave": true, //保存状态 - 在页面重新加载的时候恢复状态（页码等内容,如在第三页刷新页面，会自动到第一页
    "dom": '<l<\'#topPlugin\'>f>rt<ip><"clear">',//定义DataTables的组件元素的显示和显示顺序
    "ordering": true,//全局禁用排序
    "serverSide":false,//是否开启服务器模式
    "oLanguage": { // 国际化配置
        "sProcessing": "正在获取数据，请稍后...",
        "sLengthMenu": "显示 _MENU_ 条",
        "sZeroRecords": "没有找到数据",
        "sInfo": "第 _START_ ~ _END_ 条 / 共 _TOTAL_ 条记录",
        "sInfoEmpty": "记录数为0",
        "sInfoFiltered": "(全部记录数 _MAX_ 条)",
        "sInfoPostFix": "",
        "sSearch": "搜索",
        "sUrl": "",
        "oPaginate": {
            "sFirst": "第一页",
            "sPrevious": "上一页",
            "sNext": "下一页",
            "sLast": "最后一页"
        }
    }
};
