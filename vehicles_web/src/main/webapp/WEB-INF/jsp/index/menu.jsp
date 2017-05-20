<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="navbar nav_title" style="border: 0;">
    <a href="#" class="site_title"><i class="fa fa-car"></i><span> 车辆管理系统</span></a>
</div>

<div class="clearfix"></div>

<!-- menu profile quick info -->
<div class="profile clearfix">
    <div class="profile_pic">
        <img src="${pageContext.request.contextPath}/assets/img/images.png" alt="..." class="img-circle profile_img">
    </div>
    <div class="profile_info">
        <span>Welcome,</span>
        <h2>${sessionInfo.user.name}</h2>
    </div>
</div>
<!-- /menu profile quick info -->

<br/>

<!-- sidebar menu -->
<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
    <div class="menu_section">
        <h3>General</h3>
        <ul class="nav side-menu">
            <li><a><i class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
                <ul class="nav child_menu">
                    <li><a href="#">Dashboard</a></li>
                    <li><a href="#">Dashboard2</a></li>
                    <li><a href="#">Dashboard3</a></li>
                </ul>
            </li>
            <li><a><i class="fa fa-edit"></i> Forms <span class="fa fa-chevron-down"></span></a>
                <ul class="nav child_menu">
                    <li><a href="#">General Form</a></li>
                    <li><a href="#">Advanced Components</a></li>
                    <li><a href="#">Form Validation</a></li>
                    <li><a href="#">Form Wizard</a></li>
                    <li><a href="#">Form Upload</a></li>
                    <li><a href="#">Form Buttons</a></li>
                </ul>
            </li>
            <li><a><i class="fa fa-desktop"></i> UI Elements <span
                    class="fa fa-chevron-down"></span></a>
                <ul class="nav child_menu">
                    <li><a href="#">General Elements</a></li>
                    <li><a href="#">Media Gallery</a></li>
                    <li><a href="#">Typography</a></li>
                    <li><a href="#">Icons</a></li>
                    <li><a href="#">Glyphicons</a></li>
                    <li><a href="#">Widgets</a></li>
                    <li><a href="#">Invoice</a></li>
                    <li><a href="#">Inbox</a></li>
                    <li><a href="#">Calendar</a></li>
                </ul>
            </li>
            <li><a><i class="fa fa-table"></i> Tables <span class="fa fa-chevron-down"></span></a>
                <ul class="nav child_menu">
                    <li><a href="#">Tables</a></li>
                    <li><a href="#">Table Dynamic</a></li>
                </ul>
            </li>
            <li><a><i class="fa fa-bar-chart-o"></i> Data Presentation <span
                    class="fa fa-chevron-down"></span></a>
                <ul class="nav child_menu">
                    <li><a href="#">Chart JS</a></li>
                    <li><a href="#">Chart JS2</a></li>
                    <li><a href="#">Moris JS</a></li>
                    <li><a href="#">ECharts</a></li>
                    <li><a href="#">Other Charts</a></li>
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
    <a data-toggle="tooltip" data-placement="top" title="Logout" href="#">
        <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
    </a>
</div>-->
<!-- /menu footer buttons -->

