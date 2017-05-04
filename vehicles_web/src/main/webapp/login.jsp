<%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 2017/5/3
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="WEB-INF/jsp/commons/include.jsp"%>
<link rel="stylesheet" href="statics/css/login.css">
<script type="text/javascript" src="statics/js/login.js"></script>
<script type="text/javascript" src="statics/jquery/jquery.backstretch.min.js"></script>
<head>

    <title>login - Vehicles Management System</title>
</head>
<body>

    <div class="login-content">
        <div class="login-bg">
            <div class="container">
                <div class="row">
                    <div class="col-sm-8 col-sm-offset-2 text">
                        <h1><strong>Vehicles Management System</strong> Login</h1>
                        <div class="description">
                            车辆管理系统登陆
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-6 col-sm-offset-3 login-box">
                        <div class="box-top">
                            <div class="box-top-left">
                                <h3>Login to Vehicles MS</h3>
                                <p>请输入用户名和密码登录系统</p>
                            </div>
                            <div class="box-top-right">
                                <i class="fa fa-key"></i>
                            </div>
                        </div>
                        <div class="box-bottom">
                            <form role="form" action="" method="post" class="login-box">
                                <div class="form-group">
                                    <label class="sr-only" for="username">Username</label>
                                    <input type="text" name="username" placeholder="用户名" class="login-username form-control" id="username">
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="password">Password</label>
                                    <input type="text" name="password" placeholder="密码" class="login-password form-control" id="password">
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
</html>
