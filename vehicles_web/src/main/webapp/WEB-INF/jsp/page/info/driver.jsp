<%-- Created by Daniel on 2017/5/26 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="x_title">
    <h2>驾驶员信息管理</h2>
    <div class="clearfix"></div>
</div>

<div class="function">
    <button type="button" class="btn" data-toggle="modal" data-target=".modal-addDriver">
        <i class="glyphicon glyphicon-plus"></i>新增</button>
    <button type="button" class="btn" onclick="edit()"><i class="glyphicon glyphicon-pencil"></i>修改</button>
    <button type="button" class="btn" onclick="del()"><i class="glyphicon glyphicon-minus"></i>删除</button>
</div>
<div class="x_content">
    <p class="text-muted font-13 m-b-30"></p>
    <table id="datatable-driver" class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>姓名</th>
            <th>性别</th>
            <th>身份证号</th>
            <th>电话</th>
            <th>部门</th>
            <th>准驾日期（驾证）</th>
            <th>准驾车型</th>
        </tr>
        </thead>
    </table>
</div>

<div class="modal fade modal-addDriver" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">驾驶员信息录入</h4>
            </div>
            <div class="modal-body modal-form">
                <form role="form" method="post" data-parsley-validate class="addDriver-form form-horizontal form-label-left" id="addDriverForm">
                    <div class="form-group modal-form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">姓名 <span class="required">*</span></label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <input type="text" name="name" id="name" class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>
                    <div class="form-group modal-form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="gender">性别 <span class="required">*</span></label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <div id="gender" class="btn-group" data-toggle="buttons">
                                <label class="btn btn-default" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                    <input type="radio" name="gender" value="1"> &nbsp; 男 &nbsp;
                                </label>
                                <label class="btn btn-primary" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                    <input type="radio" name="gender" value="0"> &nbsp; 女 &nbsp;
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group modal-form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="idCard">身份证号 <span class="required">*</span></label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <input type="text" name="idCard" id="idCard" class="form-control col-md-7 col-xs-12">
                        </div>
                    </div><div class="form-group modal-form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="telephone">电话号码 <span class="required">*</span></label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <input type="text" name="telephone" id="telephone" class="form-control col-md-7 col-xs-12">
                        </div>
                    </div><div class="form-group modal-form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="dept">部门 <span class="required">*</span></label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <input type="text" name="dept" id="dept" class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>
                    <div class="form-group modal-form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="allowDate">准驾日期 <span class="required">*</span></label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <fieldset>
                                <div class="xdisplay_inputx has-feedback">
                                    <input type="text" name="allowDate" class="form-control has-feedback-left col-md-7 col-xs-12" id="allowDate" aria-describedby="inputSuccess">
                                    <span class="fa fa-calendar-o form-control-feedback left" aria-hidden="true"></span>
                                    <span id="inputSuccess" class="sr-only">(success)</span>
                                </div>
                            </fieldset>
                        </div>
                    </div>
                    <div class="form-group modal-form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="allowType">准驾车型 <span class="required">*</span></label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <input type="text" name="allowType" id="allowType" class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>
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
        $.ajax(contentPath + '/data/addDriver', {
            data: $('#addUserForm').serialize(),
            type: "POST",
            success: function (result) {
                if (result === "success") {
                    $('.modal-addDriver').modal('hide');
                    new PNotify({
                        title: 'success',
                        text: '用户录入成功！',
                        type: 'success',
                        styling: 'bootstrap3'
                    })
                } else {
                    new PNotify({
                        title: 'error',
                        text: result,
                        type: 'error',
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

    $('input[name="allowDate"]').daterangepicker({
        singleDatePicker: true,
        showDropdowns: true,
        locale: {
            format: 'YYYY-MM-DD'
        }
    });

    var $datatableDriver = $('#datatable-driver');
    var dt = $datatableDriver.DataTable($.extend({}, defaultDataTablesOption, {
        "ajax": {
            "url": contentPath + "/data/driverInfo", //从一个ajax数据源读取数据给表格内容
            "dataSrc": "" //数据属性或操作表数据的方法
        },
        "columns": [{
            "data": "name",
            "orderable": true, // 启用排序
            "defaultContent": "",
            "width": "10%"
        }, {
            "data": "gender",
            "orderable": true, // 启用排序
            "defaultContent": "",
            "width": "10%"
        }, {
            "data": "id_card",
            "orderable": true, // 启用排序
            "defaultContent": "",
            "width": "10%"
        }, {
            "data": "telephone",
            "orderable": true, // 启用排序
            "defaultContent": "",
            "width": "10%"
        }, {
            "data": "dept",
            "orderable": true, // 启用排序
            "defaultContent": "",
            "width": "10%"
        }, {
            "data": "allow_date",
            "orderable": true, // 启用排序
            "defaultContent": "",
            "width": "10%"
        }, {
            "data": "allow_type",
            "orderable": true, // 启用排序
            "defaultContent": "",
            "width": "10%"
        }]
    }));
    dt.draw(false);

    $datatableDriver.find('tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
            dt.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    } );

</script>