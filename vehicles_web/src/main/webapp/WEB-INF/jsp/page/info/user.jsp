<%-- Created by Daniel on 2017/5/26 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="x_title">
    <h2>Data Tables of <small>Users</small></h2>
    <div class="clearfix"></div>
</div>
<div class="x_content">
    <p class="text-muted font-13 m-b-30"></p>
    <button type="button" class="btn" data-toggle="modal" data-target=".modal-addUser"><i class="glyphicon glyphicon-plus"></i>新增</button>
    <table id="datatable-fixed-header" class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>用户名</th>
        </tr>
        </thead>

    </table>
</div>

<div class="modal fade modal-addUser" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">用户信息录入</h4>
            </div>
            <div class="modal-body modal-form">
                <form role="form" method="post" class="addUser-form" id="addUserForm">
                    <div class="form-group">
                        <label for="name">original</label>
                        <input type="text" name="name" id="name" class="form-control original">
                    </div>
                    <div class="form-group">
                        <label for="username">new</label>
                        <input type="text" name="username" id="username" class="form-control new">
                    </div>
                    <p class="input-error"></p>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" onclick="add()">提交</button>
                    </div>
               </form>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript">

    function add() {
        $.ajax(contentPath + '/data/addUser',{
            data: $('#addUserForm').serialize(),
            type: "POST",
            success: function (result) {
                if (result === "success") {
                    new PNotify({
                        title: 'success',
                        text: '用户录入成功！',
                        type: 'success',
                        styling: 'bootstrap3'
                    })
                }
            }
        });
    }

    var dt = $('#datatable-fixed-header').DataTable({
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
        "ajax": {
            "url": contentPath + "/data/userInfo", //从一个ajax数据源读取数据给表格内容
            "dataSrc": "" //数据属性或操作表数据的方法
        },
        "columns": [{
            "data": "id",
            "orderable": true, // 启用排序
            "defaultContent": "",
            "width": "10%"
        }, {
            "data": "name",
            "orderable": true, // 启用排序
            "defaultContent": "",
            "width": "10%"
        }, {
            "data": "username",
            "orderable": true, // 启用排序
            "defaultContent": "",
            "width": "10%"
        }],
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

    });
    dt.draw(false);
</script>