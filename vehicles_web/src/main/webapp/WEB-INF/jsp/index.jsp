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
            <%@ include file="index/menu.jsp" %>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
            <%@ include file="index/navigation.jsp" %>
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
