<%--
  Created by IntelliJ IDEA.
  User: 微软
  Date: 2020/7/27
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%--该文件尚未设计，拟用于学生自己修改学生个人信息用--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>修改用户信息</title>
    <link rel="stylesheet" href="${appContext}/css/bootstrap.css" />
</head>
<body>
<%--spring的工作就是自动封装和扫描bean--%>
<div class="container">
<%--    需修改action--%>
    <form method="post" action="${appContext}/user/update" class="form-horizontal" role="form">
        <div class="form-group">
            <label class="col-sm-2 control-label">用户名</label>
            <div class="col-sm-10">
                <p class="form-control-static">${user.username}</p>
                <input type="hidden" name="uid" value="${user.uid}" />
                <input type="hidden" name="username" value="${user.username}" />
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10">
                <input type="text" value="${user.password}"  class="form-control" id="password" name="password" placeholder="请输入密码">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-block btn-primary">修改</button>
            </div>
        </div>

    </form>
</div>
<script src="${appContext}/js/jquery-3.3.1.js"></script>
<script src="${appContext}/js/bootstrap.js"></script>
</body>
</html>
