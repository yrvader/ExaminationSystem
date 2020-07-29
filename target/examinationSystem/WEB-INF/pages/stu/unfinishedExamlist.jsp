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
<h4>未完成的考试信息</h4>
<%--    如何取得传递过来的数据,使用表达式直接访问对象--%>
<%--${users}--%>
<%--组装传递过来的数据--%>

<table class="table table-striped table-bordered table-hover">
    <thead>
    <tr class="bg-info">
        <th>考试名称</th>
        <th>开始时间</th>
        <th>结束时间</th>
        <th>提交试卷</th>
    </tr>
    </thead>
    <tbody>
    <%--    循环遍历输出数据,使用jstl--%>
<%--    需修改items var--%>
    <c:forEach items="${tests}" var="test" varStatus="status">
        <tr>
<%--            需修改为考试名称--%>
            <td>${test.subject}</td>
<%--            提交的时间段--%>
            <td type="date">${test.sdate}</td>
            <td type="date">${test.edate}</td>
<%--             <c:set var="start">--%>
<%--                <fmt:formatDate value="${test.sdate}" pattern="yyyy-MM-dd" type="date"/>--%>
<%--              </c:set>--%>
<%--            <c:set var="end">--%>
<%--                <fmt:formatDate value="${test.edate}" pattern="yyyy-MM-dd" type="date"/>--%>
<%--            </c:set>--%>
<%--            <c:set var="now">--%>
<%--                <fmt:formatDate value="${date}" pattern="yyyy-MM-dd" type="date"/>--%>
<%--            </c:set>--%>
            <td>${date}</td>
            <c:if test="${test.sdate <= now and test.edate>=now }">

            </c:if>
            <c:if test="${test.edate > date or test.edate<date }">

            </c:if>
            <c:choose>
                <c:when test="${test.sdate<date and test.edate>date}">
                    <td><a class="btn btn-info btn-sm" href="${appContext}/stu/touploadExam?testid=${test.testid}">提交试卷</a></td>
                </c:when>
                <c:otherwise>
                    <td><a class="btn btn-info btn-sm" >提交时间已过</a></td>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>

    </tbody>
</table>
<script src="${appContext}/js/jquery-3.3.1.js"></script>
<script src="${appContext}/js/bootstrap.js"></script>
</body>
</html>

