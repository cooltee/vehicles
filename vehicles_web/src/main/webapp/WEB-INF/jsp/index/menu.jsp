<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="left_col scroll-view">

    <div class="navbar nav_title" style="border: 0;">
        <a href="javascript:loadOnFrame('/page/welcome')" class="site_title"><i class="fa fa-car"></i><span> 车辆管理系统</span></a>
    </div>

    <div class="clearfix"></div>

    <br/>

    <!-- sidebar menu -->
    <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
        <div class="menu_section">
            <h3>MENU</h3>
            <ul class="nav side-menu">
                <li><a><i class="fa fa-home"></i> 基本信息 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                        <li><a href="javascript:loadOnFrame('/page/userInfo')">用户信息</a></li>
                        <li><a href="javascript:loadOnFrame('/page/vehicleInfo')">车辆信息</a></li>
                        <li><a href="javascript:loadOnFrame('/page/driverInfo')">驾驶员信息</a></li>
                    </ul>
                </li>
                <li><a><i class="fa fa-edit"></i> 车辆费用 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                        <li><a href="javascript:loadOnFrame('/page/repairCost')">维修费用</a></li>
                        <li><a href="javascript:loadOnFrame('/page/parkingCost')">停车费用</a></li>
                        <li><a href="javascript:loadOnFrame('/page/energyCost')">能源费用</a></li>
                        <li><a href="javascript:loadOnFrame('/page/otherCost')">其他费用</a></li>
                    </ul>
                </li>
                <li><a><i class="fa fa-desktop"></i> 维修管理 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                        <li><a href="javascript:void(0)">车辆保养</a></li>
                        <li><a href="javascript:void(0)">车辆维修</a></li>
                        <li><a href="javascript:void(0)">车辆年审</a></li>
                    </ul>
                </li>
                <li><a><i class="fa fa-bar-chart-o"></i> 报表展示 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                        <li><a href="javascript:void(0)">Chart JS</a></li>
                        <li><a href="javascript:void(0)">ECharts</a></li>
                        <li><a href="javascript:void(0)">Other Charts</a></li>
                    </ul>
                </li>

            </ul>
        </div>
    </div>

</div>