<%--
  Created by IntelliJ IDEA.
  User: 微软
  Date: 2020/7/27
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>后台管理</title>
    <link rel="stylesheet" href="${appContext}/css/bootstrap.css" />
    <base target="mainF" />
</head>
<body>
<div class="container-fluid">
    <div class="row col-12">
        <h3>学生考试试题提交系统    欢迎您:${sessionScope.stu.stunumber}</h3>
        <%--        这三条路径需按项目结构修改--%>
        <a href="${appContext}/stu/toupdatepassword">修改密码</a>
        <a target="_self" href="${appContext}/stu/logout">退出登录</a>
    </div>
</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-12 col-md-3">
            <ul>
                <li>考试管理</li>
                <ul>
                    <%--                    路径需修改--%>
                    <li><a href="${appContext}/stu/tounfinishedlist?stuid=${sessionScope.stu.stuid}">查看未完成考试</a></li>
                    <li><a href="${appContext}/stu/tocheckscore">查看考试成绩</a></li>
                </ul>
            </ul>
        </div>
        <div class="col-sm-12 col-md-9">
            <iframe name="mainF" width="100%" height="500" frameborder="0"></iframe>
        </div>
    </div>
</div>


<script src="${appContext}/js/jquery-3.3.1.js"></script>
<script src="${appContext}/js/bootstrap.js"></script>
</body>
</html>

