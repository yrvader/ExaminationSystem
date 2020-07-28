<%--
  Created by IntelliJ IDEA.
  User: 微软
  Date: 2020/7/27
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>未完成的考试</title>
    <link rel="stylesheet" href="${appContext}/css/bootstrap.css" />
</head>
<body>
<h4>考试信息</h4>
<%--    如何取得传递过来的数据,使用表达式直接访问对象--%>
<%--${users}--%>
<%--组装传递过来的数据--%>
<table class="table table-striped table-bordered table-hover">
    <thead>
    <tr class="bg-info">
        <th>序号#</th>
        <th>考试名称</th>
        <th>提交试卷</th>
    </tr>
    </thead>
    <tbody>
    <%--    循环遍历输出数据,使用jstl--%>
<%--    需修改items var--%>
    <c:forEach items="${users}" var="user" varStatus="status">
        <tr>
            <th>${status.count}</th>
<%--            需修改为考试名称--%>
            <td>${user.uid}</td>
<%--            需修改路径为考试提交界面，修改user.uid为考试名--%>
            <td><a class="btn btn-info btn-sm" href="${appContext}/user/uploadExam?uid=${user.uid}">提交试卷</a></td>
        </tr>
    </c:forEach>

    </tbody>
</table>
<script src="${appContext}/js/jquery-3.3.1.js"></script>
<script src="${appContext}/js/bootstrap.js"></script>
</body>
</html>
