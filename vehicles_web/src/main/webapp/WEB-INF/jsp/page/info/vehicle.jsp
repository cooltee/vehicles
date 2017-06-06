<%-- Created by Daniel on 2017/5/26 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="x_title">
    <h2>Data Tables of <small>Vehicles</small></h2>
    <div class="clearfix"></div>
</div>
<div class="x_content">
    <p class="text-muted font-13 m-b-30"></p>
    <table id="datatable-vehicle" class="table table-striped table-bordered">
        <thead>
            <tr>
                <th>车牌号</th>
                <th>制造商</th>
                <th>型号</th>
                <th>车型</th>
                <th>用途</th>
                <th>档案编号</th>
            </tr>
        </thead>

    </table>
</div>

<script type="text/javascript">
    var dt = $('#datatable-vehicle').DataTable({
        "ajax": {
            "url": contentPath + "/data/vehicleInfo", //从一个ajax数据源读取数据给表格内容
            "dataSrc": "" //数据属性或操作表数据的方法
        },
        "columns": [{
            "data": "registration_plate",
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
            "data": "vehicleType",
            "orderable": true, // 启用排序
            "defaultContent": "",
            "width": "10%"
        }, {
            "data": "vehiclePurpose",
            "orderable": true, // 启用排序
            "defaultContent": "",
            "width": "10%"
        }, {
            "data": "archivesNo",
            "orderable": true, // 启用排序
            "defaultContent": "",
            "width": "10%"
        }]
    });
    dt.dataTable(defaultDataTablesOption);
    dt.draw(false);
</script>