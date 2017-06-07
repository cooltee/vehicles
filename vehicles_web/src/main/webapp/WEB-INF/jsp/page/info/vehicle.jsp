<%-- Created by Daniel on 2017/5/26 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="x_title">
    <h2>车辆信息管理</h2>
    <div class="clearfix"></div>
</div>
<div class="function">
    <button type="button" class="btn" data-toggle="modal" data-target=".modal-addVehicle">
        <i class="glyphicon glyphicon-plus"></i>新增</button>
    <button type="button" class="btn" onclick="edit()"><i class="glyphicon glyphicon-pencil"></i>修改</button>
    <button type="button" class="btn" onclick="del()"><i class="glyphicon glyphicon-minus"></i>删除</button>
</div>
<div class="x_content">
    <table id="datatable-vehicle" class="table table-striped table-bordered">
        <thead>
            <tr>
                <th>车牌号</th>
                <th>制造商</th>
                <th>型号</th>
                <th>部门</th>
                <th>购入价格</th>
                <th>购入日期</th>
            </tr>
        </thead>

    </table>
</div>

<div class="modal fade modal-addVehicle" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">车辆信息录入</h4>
            </div>
            <div class="modal-body modal-form">
                <form role="form" method="post" class="addVehicle-form form-horizontal form-label-left" id="addVehicleForm">
                    <div class="form-group modal-form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="registrationPlate">车牌号 <span class="required">*</span></label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <input type="text" name="registrationPlate" id="registrationPlate" class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>
                    <div class="form-group modal-form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="manufacturers">制造商 <span class="required">*</span></label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <input type="text" name="manufacturers" id="manufacturers" class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>
                    <div class="form-group modal-form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="models">型号 <span class="required">*</span></label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <input type="text" name="models" id="models" class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>
                    <div class="form-group modal-form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="purchaseDept">部门 <span class="required">*</span></label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <input type="text" name="purchaseDept" id="purchaseDept" class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>
                    <input type="hidden" name="vehicleType" value="0">
                    <input type="hidden" name="vehiclePurpose" value="0">
                    <div class="form-group modal-form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="purchasePrice">购入价格 <span class="required">*</span></label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <input type="text" name="purchasePrice" id="purchasePrice" class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>
                    <div class="form-group modal-form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="purchaseDate">购入日期 <span class="required">*</span></label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <fieldset>
                                <div class="xdisplay_inputx has-feedback">
                                    <input type="text" name="purchaseDate" id="purchaseDate" class="form-control has-feedback-left col-md-7 col-xs-12" aria-describedby="inputSuccess">
                                    <span class="fa fa-calendar-o form-control-feedback left" aria-hidden="true"></span>
                                    <span id="inputSuccess" class="sr-only">(success)</span>
                                </div>
                            </fieldset>
                        </div>
                    </div>
                    <input type="hidden" name="archivesNo">
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
        $.ajax(contentPath + '/data/addVehicle', {
            data: $('#addVehicleForm').serialize(),
            type: "POST",
            success: function (result) {
                if (result === "success") {
                    $('.modal-addVehicle').modal('hide');
                    new PNotify({
                        title: 'success',
                        text: '车辆录入成功！',
                        type: 'success',
                        styling: 'bootstrap3'
                    })
                }
            }
        });
    }

    $('input[name="allowDate"]').daterangepicker({
        singleDatePicker: true,
        showDropdowns: true,
        locale: {
            format: 'YYYY-MM-DD'
        }
    });

    var dt = $('#datatable-vehicle').DataTable($.extend({}, defaultDataTablesOption, {
        "ajax": {
            "url": contentPath + "/data/vehicleInfo", //从一个ajax数据源读取数据给表格内容
            "dataSrc": "" //数据属性或操作表数据的方法
        },
        "columns": [{
            "data": "registrationPlate",
            "orderable": true, // 启用排序
            "defaultContent": "",
            "width": "10%"
        }, {
            "data": "manufacturers",
            "orderable": true, // 启用排序
            "defaultContent": "",
            "width": "10%"
        }, {
            "data": "models",
            "orderable": true, // 启用排序
            "defaultContent": "",
            "width": "10%"
        }, {
            "data": "purchaseDept",
            "orderable": true, // 启用排序
            "defaultContent": "",
            "width": "10%"
        }, {
            "data": "purchasePrice",
            "orderable": true, // 启用排序
            "defaultContent": "",
            "width": "10%"
        }, {
            "data": "purchaseDate",
            "orderable": true, // 启用排序
            "defaultContent": "",
            "width": "10%"
        }]
    }));
    dt.draw(false);
</script>