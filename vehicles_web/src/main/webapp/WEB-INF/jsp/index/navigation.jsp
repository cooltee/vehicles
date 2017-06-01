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
                    <li><a href="javascript:void(0)" data-toggle="modal" data-target=".modal-chgPass">修改密码</a></li>
                    <li><a href="javascript:void(0)" onclick="signOut()"><i class="fa fa-sign-out pull-right"></i> 退出</a></li>
                </ul>
            </li>

        </ul>


        <div class="modal fade modal-chgPass" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">

                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span>
                        </button>
                        <h4 class="modal-title" id="myModalLabel">修改密码</h4>
                    </div>
                    <div class="modal-body modal-form">
                        <form role="form" action="" method="post" class="chgPass-form" id="chgPassForm">
                            <div class="form-group">
                                <label class="sr-only" for="original">original</label>
                                <input type="password" name="original" id="original" placeholder="原密码" class="form-control original">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="new">new</label>
                                <input type="password" name="new" id="new" placeholder="新密码" class="form-control new">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="check">check</label>
                                <input type="password" name="check" id="check" placeholder="确认密码" class="form-control check">
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" onclick="changePass()">修改</button>
                    </div>

                </div>
            </div>
        </div>

    </nav>
</div>
<style type="text/css">
    input[type="password"] {
        height: 50px;
        margin: 0;
        padding: 0 20px;
        vertical-align: middle;
        background: #f8f8f8;
        border: 3px solid #ddd;
        font-family: 'Roboto', sans-serif;
        font-size: 16px;
        font-weight: 300;
        line-height: 50px;
        color: #888;
        -moz-border-radius: 4px;
        -webkit-border-radius: 4px;
        border-radius: 4px;
        -moz-box-shadow: none;
        -webkit-box-shadow: none;
        box-shadow: none;
        -o-transition: all .3s;
        -moz-transition: all .3s;
        -webkit-transition: all .3s;
        -ms-transition: all .3s;
        transition: all .3s;
    }
</style>
<script type="text/javascript">
    function changePass() {

    }
</script>