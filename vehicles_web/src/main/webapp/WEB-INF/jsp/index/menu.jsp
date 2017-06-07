<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="left_col scroll-view">

    <div class="navbar nav_title" style="border: 0;">
        <a href="javascript:loadOnFrame('/page/welcome')" class="site_title"><i class="fa fa-home"></i><span> 车辆管理系统</span></a>
    </div>

    <div class="clearfix"></div>

    <br/>

    <!-- sidebar menu -->
    <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
        <div class="menu_section">
            <h3>MENU</h3>
            <ul class="nav side-menu">
                <li><a><i class="fa fa-car"></i> 基本信息 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                        <li><a href="javascript:loadOnFrame('/page/vehicleInfo')">车辆信息</a></li>
                        <li><a href="javascript:loadOnFrame('/page/driverInfo')">驾驶员信息</a></li>
                    </ul>
                </li>
                <li><a><i class="fa fa-calculator"></i> 车辆费用 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                        <li><a href="javascript:loadOnFrame('/page/repairCost')">维修费用</a></li>
                        <li><a href="javascript:loadOnFrame('/page/parkingCost')">停车费用</a></li>
                        <li><a href="javascript:loadOnFrame('/page/energyCost')">燃油费用</a></li>
                        <li><a href="javascript:loadOnFrame('/page/otherCost')">其他费用</a></li>
                    </ul>
                </li>
                <li><a><i class="fa fa-edit"></i> 记录管理 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                        <li><a href="javascript:loadOnFrame('/page/maintenanceRecord')">车辆保养</a></li>
                        <li><a href="javascript:loadOnFrame('/page/repairRecord')">车辆维修</a></li>
                        <li><a href="javascript:loadOnFrame('/page/reviewRecord')">车辆年审</a></li>
                    </ul>
                </li>
                <c:if test="${sessionInfo.permission == 1}">
                    <li><a><i class="fa fa-user"></i> 管理员功能 <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="javascript:loadOnFrame('/page/userInfo')">用户管理</a></li>
                        </ul>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>

</div>