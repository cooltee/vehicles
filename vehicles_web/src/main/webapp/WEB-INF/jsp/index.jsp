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
            <%@ include file="index/content.jsp" %>
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
</html>
