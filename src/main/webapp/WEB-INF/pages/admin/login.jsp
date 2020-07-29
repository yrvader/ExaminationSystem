<%--
  Created by IntelliJ IDEA.
  User: 微软
  Date: 2020/7/27
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String appPath = request.getContextPath();//通过该方法拿到的应用路径是以 / 开头的绝对路径  /hitssm
    request.getSession().setAttribute("appContext", appPath);
%>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录</title>
    <link rel="stylesheet" href="${appContext}/css/bootstrap.css"/>
</head>
<body>
<h4>管理员登录界面</h4>
<a href="${appContext}/stu/login">学生登录</a>
    <div class="container">
        <form method="post" action="${appContext}/admin/loginCheck" class="form-horizontal" role="form">
            <div class="form-group">
                <label class="col-sm-2 control-label">用户名</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="stunumber" placeholder="用户名"/>
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="password" name="password" placeholder="请输入密码">
                </div>
            </div>
            ${msg}
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-block btn-success">登录</button>
                </div>
            </div>

        </form>
    </div>
<script src="${appContext}/js/jquery-3.3.1.js"></script>
<script src="${appContext}/js/bootstrap.js"></script>
</body>
</html>
