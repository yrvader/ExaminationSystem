<%--
  Created by IntelliJ IDEA.
  User: 五五开
  Date: 2020/7/28
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <form method="post" action="${appContext}/stu/updatepassword" class="form-horizontal" role="form">
        <div class="form-group">
            <label class="col-sm-2 control-label">原密码:${sessionScope.stu.password}</label>
            <div class="col-sm-10">
                <input type="hidden" class="form-control" name="stuid" value="${sessionScope.stu.stuid}"/>
                <input type="hidden" class="form-control" name="stunumber" value="${sessionScope.stu.stunumber}"/>
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">新密码</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="password" name="password" placeholder="请输入密码">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-block btn-success">更新</button>
            </div>
        </div>

    </form>
</div>
</body>
</html>
