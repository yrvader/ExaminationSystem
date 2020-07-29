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
        <h3>${test.student.stunumber}的${test.student}考卷</h3>
    </div>
</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-12 col-md-3">
            <form method="post" action="${appContext}/stu/updatepassword" class="form-horizontal" role="form">
                <c:forEach items="${scores}" var="score" varStatus="status">
                    <div>第${status.count}题原分数${score}</div>
                    <input type="text" name="score" pattern="([0-9]|[1-9][0-9])" required="required" />
                </c:forEach>

            </form>
            <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-block btn-primary">修改</button>
            </div>
        </div>
        <div class="col-sm-12 col-md-9">

        </div>
    </div>
</div>


<script src="${appContext}/js/jquery-3.3.1.js"></script>
<script src="${appContext}/js/bootstrap.js"></script>
</body>
</html>

