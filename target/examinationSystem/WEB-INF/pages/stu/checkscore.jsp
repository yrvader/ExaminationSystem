<%--
  Created by IntelliJ IDEA.
  User: 五五开
  Date: 2020/7/28
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${appContext}/css/bootstrap.css" />
</head>
<body>
<table class="table table-striped table-bordered table-hover">
    <thead>
    <tr class="bg-info">
        <th>考试名称</th>
        <th>总分</th>
<%--        <th>结束时间</th>--%>
<%--        <th>提交试卷</th>--%>
    </tr>
    </thead>
    <tbody>
    <%--    循环遍历输出数据,使用jstl--%>
    <%--    需修改items var--%>
    <c:forEach items="${tests}" var="test"   varStatus="status">
        <tr>

            <td>${test.subject}</td>
            <td>${scores.get(status.count-1)}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>
<script src="${appContext}/js/jquery-3.3.1.js"></script>
<script src="${appContext}/js/bootstrap.js"></script>
</body>
</html>
