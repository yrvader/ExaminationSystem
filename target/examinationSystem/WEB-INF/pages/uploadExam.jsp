<%--
  Created by IntelliJ IDEA.
  User: 微软
  Date: 2020/7/27
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>提交试卷</title>
    <link rel="stylesheet" href="${appContext}/css/bootstrap.css" />
</head>
<body>
<%--此处最好展示考试名称，可修改--%>
<h4>考试</h4>
<div class="container">
<%--    需修改，添加图片--%>
    <form method="post" action="${appContext}/user/loginCheck" class="form-horizontal" role="form">
        <div class="form-group">
            <div class="col-sm-12">
                <button type="submit" class="btn btn-block btn-success">添加</button>
            </div>
        </div>
    </form>
<%--需修改，上传结果--%>
    <form method="post" action="${appContext}/user/loginCheck" class="form-horizontal" role="form">
        <div class="form-group">
            <div class="col-sm-12">
                <button type="submit" class="btn btn-block btn-success">上传</button>
            </div>
        </div>

    </form>
</div>
<script src="${appContext}/js/jquery-3.3.1.js"></script>
<script src="${appContext}/js/bootstrap.js"></script>
</body>
</html>

