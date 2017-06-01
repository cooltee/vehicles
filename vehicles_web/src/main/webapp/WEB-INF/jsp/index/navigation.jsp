<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="nav_menu">
    <nav>
        <div class="nav toggle">
            <a id="menu_toggle"><i class="fa fa-bars"></i></a>
        </div>

        <ul class="nav navbar-nav navbar-right">
            <li class="">
                <a href="javascript:" class="user-profile dropdown-toggle" data-toggle="dropdown"
                   aria-expanded="false">
                    <img src="${pageContext.request.contextPath}/assets/img/images.png" alt=""> ${sessionInfo.user.name}
                    <span class=" fa fa-angle-down"></span>
                </a>
                <ul class="dropdown-menu dropdown-usermenu pull-right">
                    <li><a href="javascript:void(0)" onclick="$.ajax(contentPath + '/chgPass')">修改密码</a></li>
                    <li><a href="javascript:void(0)" onclick="signOut()"><i class="fa fa-sign-out pull-right"></i> 退出</a></li>
                </ul>
            </li>

        </ul>
    </nav>
</div>