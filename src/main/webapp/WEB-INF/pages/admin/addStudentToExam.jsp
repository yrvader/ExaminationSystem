<%--
  Created by IntelliJ IDEA.
  User: 微软
  Date: 2020/7/28
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>添加考试学生</title>
    <link rel="stylesheet" href="${appContext}/css/bootstrap.css" />
</head>
<body>
<div class="container">
    <div class="row">
<%--        需更改为展示Exam.subject--%>
        考试管理 科目：${sessionScope.USER_SESSION.username}
    </div>
</div>
<%--spring的工作就是自动封装和扫描bean--%>
<div class="container">
    <%--    需修改action--%>
    <form method="post" action="${appContext}/user/add" class="form-horizontal" role="form">
        <div class="form-group">
            <label for="studentnumberInput" class="col-sm-2 control-label">学号</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="studentnumberInput" name="studentnumber" placeholder="请输入学号">
            </div>
            <span id="studentnumberTips" class="col-sm-3"></span>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-block btn-primary">添加</button>
            </div>
        </div>
    </form>
</div>
<script src="${appContext}/js/jquery-3.3.1.js"></script>
<script src="${appContext}/js/bootstrap.js"></script>
<script>
    $(document).ready(function(){});
    $(function () {
        var flag=false;

        //当在用户名输入框中触发键盘时做用户是否重名的验证
        $("#studentnumberInput").keyup(function () {
            $.get(
                // 需修改路径
                "${appContext}/user/userExistAjax?username="+encodeURI($("#studentnumberInput").val()),
                function(result){
                    if(result=="该用户已存在"){
                        $("#studentnumberTips").addClass("success").text(result);
                        $("#studentnumberTips").parent().addClass("has-success");
                        $("button").addClass("disabled");
                        flag=true;

                    }else{
                        $("#studentnumberTips").addClass("danger").text(result);
                        $("#studentnumberTips").parent().addClass("has-error");
                        $("button").removeClass("disabled");
                    }
                }
            );
        });

        //判断表单能否提交
        $("form").submit(function(){
                if(flag){
                    return true;
                } else
                    return false;
            }

        );
    });
</script>
</body>
</html>
