<jsp:useBean id="sessionInfo" scope="request" type="com.cooltee.session.SessionInfo"/>
<%-- Created by Daniel on 2017/5/4 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="commons/includeStyle.jsp"%>
<head>
    <title>Vehicles Management System</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

</head>

<body class="nav-md footer_fixed">
<div class="container body">
    <div class="main_container">
        <div class="col-md-3 left_col menu_fixed">
            <div class="left_col scroll-view">
                <%@ include file="index/menu.jsp" %>
            </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
            <div class="nav_menu">
                <nav>
                    <div class="nav toggle">
                        <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                    </div>

                    <ul class="nav navbar-nav navbar-right">
                        <li class="">
                            <a href="javascript:" class="user-profile dropdown-toggle" data-toggle="dropdown"
                               aria-expanded="false">
                                <img src="${pageContext.request.contextPath}/assets/img/images.png" alt="">${sessionInfo.user.name}
                                <span class=" fa fa-angle-down"></span>
                            </a>
                            <ul class="dropdown-menu dropdown-usermenu pull-right">
                                <li><a href="javascript:"> Profile</a></li>
                                <li>
                                    <a href="javascript:">
                                        <span class="badge bg-red pull-right">50%</span>
                                        <span>Settings</span>
                                    </a>
                                </li>
                                <li><a href="javascript:">Help</a></li>
                                <li><a href="javascript:void(0)" onclick="signOut()"><i class="fa fa-sign-out pull-right"></i> 退出</a></li>
                            </ul>
                        </li>

                        <li role="presentation" class="dropdown">
                            <a href="javascript:" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                                <i class="fa fa-envelope-o"></i>
                                <span class="badge bg-green">1</span>
                            </a>
                            <ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu">
                                <li>
                                    <a>
                                        <span class="image"><img src="${pageContext.request.contextPath}/assets/img/images.png" alt="Profile Image" /></span>
                                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                                    </a>
                                </li>
                                <li>
                                    <div class="text-center">
                                        <a>
                                            <strong>See All Alerts</strong>
                                            <i class="fa fa-angle-right"></i>
                                        </a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h3>Plain Page</h3>
                    </div>

                    <div class="title_right">
                        <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Search for...">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button">Go!</button>
                                </span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="clearfix"></div>

                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="framer"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /page content -->


        <!-- footer content -->
        <footer>
            <div class="pull-right footer_fixed">
                Vehicles Management System - by <a href="#">Cooltee</a>
            </div>
            <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
    </div>
</div>

</body>
<%@include file="commons/includeScript.jsp"%>
<script type="text/javascript">

    function loadOnFrame(target) {
        $.get(target, function(data){
            $(".framer").html(data);
        })
    }

    $(function(){
        loadOnFrame("/page/welcome");

        $('.nav.child_menu>li>a').click(function(){
            loadOnFrame($(this).attr('href'));
        });
    });

</script>
</html>
