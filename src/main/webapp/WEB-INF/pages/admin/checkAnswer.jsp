<%--
  Created by IntelliJ IDEA.
  User: 微软
  Date: 2020/7/28
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>考生答卷</title>
    <link rel="stylesheet" href="${appContext}/css/bootstrap.css"/>
</head>
<body>
<div class="container">
    <div class="row">
        <%--        需更改为展示Exam.subject--%>
        试卷批阅 科目：${sessionScope.USER_SESSION.username}
    </div>
</div>
<%--    如何取得传递过来的数据,使用表达式直接访问对象--%>
<%--${users}--%>
<%--组装传递过来的数据--%>
<table class="table table-striped table-bordered table-hover">
    <thead>
    <tr class="bg-info">
        <th>序号#</th>
        <th>学生学号</th>
        <th>答卷</th>
        <th>评分</th>
        <th>提交</th>
    </tr>
    </thead>
    <tbody>
    <%--    循环遍历输出数据,使用jstl--%>
    <%--    需修改--%>
    <c:forEach items="${users}" var="user" varStatus="status">
        <tr>
            <th>${status.count}</th>
            <td>${user.stunumber}</td>
                <%--        这个list如何遍历不太确定--%>
            <c:forEach items="${users}" var="user" varStatus="status">
                <th>${user.tests}</th>
            </c:forEach>
            <td><input type="text" class="form-control" id="password" name="password" placeholder="请输入分数"></td>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-block btn-success">提交评分</button>
                </div>
            </div>
            <td><a class="btn btn-danger btn-sm" href="${appContext}/user/delete?uid=${user.id}">删除</a></td>
        </tr>
    </c:forEach>

    </tbody>
</table>
<script src="${appContext}/js/jquery-3.3.1.js"></script>
<script src="${appContext}/js/bootstrap.js"></script>
</body>
</html>
