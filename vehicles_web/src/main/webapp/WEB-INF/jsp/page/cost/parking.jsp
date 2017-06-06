<%-- Created by Daniel on 2017/5/26 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="x_title">
    <h2>用户信息管理</h2>
    <div class="clearfix"></div>
</div>

<div class="function">
    <button type="button" class="btn" data-toggle="modal" data-target=".modal-addUser"><i class="glyphicon glyphicon-plus"></i>新增</button>
    <button type="button" class="btn" onclick="edit()"><i class="glyphicon glyphicon-pencil"></i>修改</button>
    <button type="button" class="btn" onclick="del()"><i class="glyphicon glyphicon-minus"></i>删除</button>
</div>
<div class="x_content">
    <p class="text-muted font-13 m-b-30"></p>
    <table id="datatable-user" class="table table-striped table-bordered">
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
                        <label for="name">姓名</label>
                        <input type="text" name="name" id="name" class="form-control original">
                    </div>
                    <div class="form-group">
                        <label for="username">用户名</label>
                        <input type="text" name="username" id="username" class="form-control new">
                    </div>
                    <p class="input-error"></p>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal"><i class="glyphicon glyphicon-remove"></i>关闭</button>
                        <button type="button" class="btn btn-primary" onclick="add()"><i class="glyphicon glyphicon-ok"></i>提交</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript">

    function add() {
        $.ajax(contentPath + '/data/addUser', {
            data: $('#addUserForm').serialize(),
            type: "POST",
            success: function (result) {
                if (result === "success") {
                    $('.modal-addUser').modal('hide');
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

    function edit() {

    }

    function del() {

    }
    var dt = $('#datatable-user').DataTable($.extend({}, defaultDataTablesOption, {
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
        }]
    }));
    dt.draw(false);

</script>