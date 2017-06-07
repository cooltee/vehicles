<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Created by Daniel on 2017/5/19 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    你好，<%--@elvariable id="sessionInfo" type="com.cooltee.session.SessionInfo"--%>
    <c:if test="${sessionInfo.permission == 1}">管理员</c:if>
    <c:if test="${sessionInfo.permission != 1}">${sessionInfo.user.name}</c:if>！ <h2>欢迎使用<b>车辆管理系统</b></h2>
    您可以通过左侧功能菜单开始进行管理！
</div>