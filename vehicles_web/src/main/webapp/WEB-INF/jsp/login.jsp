<%-- Created by Daniel on 2017/5/3 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%-- bootstrap --%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/statics/bootstrap/css/bootstrap.min.css">
<%-- font-awesome --%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/statics/font-awesome/css/font-awesome.min.css">

<link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/login.css">

<link rel="icon" href="${pageContext.request.contextPath}/assets/icon/favicon.ico">
<head>
    <title>login - Vehicles Management System</title>
</head>
<body>
    <div class="login-content">
        <div class="login-bg">
            <div class="container">
                <div class="row">
                    <div class="col-sm-8 col-sm-offset-2 text">
                        <h1><strong>Vehicles Management System</strong> | Login</h1>

                        <div class="description"> 车辆管理系统登陆 </div>
                        <input type="hidden" id="redirectUrl" value="${requestScope.redirectUrl}">
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-6 col-sm-offset-3 login-box">
                        <div class="box-top">
                            <div class="box-top-left">
                                <h3>Login to Vehicles MS</h3>
                                <p class="msg">请输入用户名和密码登录系统</p>
                            </div>
                            <div class="box-top-right">
                                <i class="fa fa-key"></i>
                            </div>
                        </div>
                        <div class="box-bottom">
                            <form role="form" action="" method="post" class="login-form" id="login-form">
                                <div class="form-group">
                                    <label class="sr-only" for="username">Username</label>
                                    <input type="text" name="username" placeholder="用户名" class="login-username form-control" id="username">
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="password">Password</label>
                                    <input type="password" name="password" placeholder="密码" class="login-password form-control" id="password">
                                </div>
                                <button type="submit" class="login-btn">登录</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

<%-- include jquery--%>
<script type="text/javascript" src= "${pageContext.request.contextPath}/statics/jquery/jquery-3.1.1.js"></script>
<%-- bootstrap --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/login.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/jquery/jquery.backstretch.min.js"></script>
</html>
