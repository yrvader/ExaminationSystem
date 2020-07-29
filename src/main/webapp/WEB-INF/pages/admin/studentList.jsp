<%--
  Created by IntelliJ IDEA.
  User: 微软
  Date: 2020/7/28
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>学生列表</title>
    <link rel="stylesheet" href="${appContext}/css/bootstrap.css" />
</head>
<body>
<h4>学生信息</h4>
<%--    如何取得传递过来的数据,使用表达式直接访问对象--%>
<%--${users}--%>
<%--组装传递过来的数据--%>
<table class="table table-striped table-bordered table-hover">
    <thead>
    <tr class="bg-info">
        <th>序号#</th>
        <th>学号</th>
        <th>操作(删除)</th>
    </tr>
    </thead>
    <tbody>
    <%--    循环遍历输出数据,使用jstl--%>
    <jsp:useBean id="users" scope="request" type="java.util.List"/>
<%--    需修改--%>
    <c:forEach items="${students}" var="student" varStatus="status">
        <tr>
            <th>${status.count}</th>
            <td>${student.stunumber}</td>
            <td><a class="btn btn-danger btn-sm" href="${appContext}/admin/delete?stuid=${student.uid}">删除</a></td>
        </tr>
    </c:forEach>

    </tbody>
</table>
<div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-3">
            <ul>
                <li><a href="${appContext}/admin/addStudent">添加学生</a></li>
            </ul>
        </div>
    </div>
</div>
<script src="${appContext}/js/jquery-3.3.1.js"></script>
<script src="${appContext}/js/bootstrap.js"></script>
</body>
</html>

