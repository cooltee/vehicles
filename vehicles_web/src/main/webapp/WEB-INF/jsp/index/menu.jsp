<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="navbar nav_title" style="border: 0;">
    <a href="javascript:void(0)" class="site_title"><i class="fa fa-car"></i><span> 车辆管理系统</span></a>
</div>

<div class="clearfix"></div>

<!-- menu profile quick info -->
<div class="profile clearfix">
    <div class="profile_pic">
        <img src="${pageContext.request.contextPath}/assets/img/images.png" alt="..." class="img-circle profile_img">
    </div>
    <div class="profile_info">
        <h2>${sessionInfo.user.name}</h2>
        <span>你好！</span>
    </div>
</div>
<!-- /menu profile quick info -->

<br/>

<!-- sidebar menu -->
<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
    <div class="menu_section">
        <h3>General</h3>
        <ul class="nav side-menu">
            <li><a><i class="fa fa-home"></i> 基本信息 <span class="fa fa-chevron-down"></span></a>
                <ul class="nav child_menu">
                    <li><a href="javascript:void(0)">用户信息</a></li>
                    <li><a href="javascript:void(0)">车辆信息</a></li>
                    <li><a href="javascript:void(0)">驾驶员信息</a></li>
                </ul>
            </li>
            <li><a><i class="fa fa-edit"></i> 车辆费用 <span class="fa fa-chevron-down"></span></a>
                <ul class="nav child_menu">
                    <li><a href="javascript:void(0)">维修费用</a></li>
                    <li><a href="javascript:void(0)">路桥费用</a></li>
                    <li><a href="javascript:void(0)">停车费用</a></li>
                    <li><a href="javascript:void(0)">其他费用</a></li>
                    <li><a href="javascript:void(0)">Form Upload</a></li>
                    <li><a href="javascript:void(0)">Form Upl</a></li>
                    <li><a href="javascript:void(0)">Form Buttons</a></li>
                </ul>
            </li>
            <li><a><i class="fa fa-desktop"></i> 维修管理 <span
                    class="fa fa-chevron-down"></span></a>
                <ul class="nav child_menu">
                    <li><a href="javascript:void(0)">车辆保养</a></li>
                    <li><a href="javascript:void(0)">车辆维修</a></li>
                    <li><a href="javascript:void(0)">车辆年审</a></li>
                    <li><a href="javascript:void(0)">Icons</a></li>
                    <li><a href="javascript:void(0)">Glyphicons</a></li>
                    <li><a href="javascript:void(0)">Widgets</a></li>
                    <li><a href="javascript:void(0)">Invoice</a></li>
                    <li><a href="javascript:void(0)">Inbox</a></li>
                    <li><a href="javascript:void(0)">Calendar</a></li>
                </ul>
            </li>
            <li><a><i class="fa fa-table"></i> 报表展示 <span class="fa fa-chevron-down"></span></a>
                <ul class="nav child_menu">
                    <li><a href="javascript:void(0)">Tables</a></li>
                    <li><a href="javascript:void(0)">Table Dynamic</a></li>
                </ul>
            </li>
            <li><a><i class="fa fa-bar-chart-o"></i>  <span
                    class="fa fa-chevron-down"></span></a>
                <ul class="nav child_menu">
                    <li><a href="javascript:void(0)">Chart JS</a></li>
                    <li><a href="javascript:void(0)">Chart JS2</a></li>
                    <li><a href="javascript:void(0)">Moris JS</a></li>
                    <li><a href="javascript:void(0)">ECharts</a></li>
                    <li><a href="javascript:void(0)">Other Charts</a></li>
                </ul>
            </li>

        </ul>
    </div>


</div>
<!-- /sidebar menu -->

<!-- /menu footer buttons
<div class="sidebar-footer hidden-small">
    <a data-toggle="tooltip" data-placement="top" title="Settings">
        <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
    </a>
    <a data-toggle="tooltip" data-placement="top" title="FullScreen">
        <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
    </a>
    <a data-toggle="tooltip" data-placement="top" title="Lock">
        <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
    </a>
    <a data-toggle="tooltip" data-placement="top" title="Logout" href="javascript:void(0)">
        <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
    </a>
</div>-->
<!-- /menu footer buttons -->

