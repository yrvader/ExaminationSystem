<%--
  Created by IntelliJ IDEA.
  User: 微软
  Date: 2020/7/29
  Time: 8:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>添加一门考试</title>
    <link rel="stylesheet" href="${appContext}/css/bootstrap.css" />
</head>
<body>
<%--spring的工作就是自动封装和扫描bean--%>
<div class="container">
    <%--    需修改action--%>
    <form method="post" action="${appContext}/admin/addExam" class="form-horizontal" role="form">
        <div class="form-group">
            <label for="subjectInput" class="col-sm-2 control-label">科目</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="subjectInput" name="subject" placeholder="请输入科目">
            </div>
            <span id="subjectTips" class="col-sm-3"></span>
        </div>
        <div class="form-group">
            <label for="pnumberInput" class="col-sm-2 control-label">答卷数量</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="pnumberInput" name="pn" placeholder="请输入答卷数量">
            </div>
            <div class="col-sm-3"></div>
        </div>
        <div class="form-group">
            <label for="snumberInput" class="col-sm-2 control-label">题数</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="snumberInput" name="sn" placeholder="请输入题数">
            </div>
        </div>
        <div class="form-group">
            <label for="sdateInput" class="col-sm-2 control-label">开始时间</label>
            <div class="col-sm-6">
                <input type="date" class="form-control" id="sdateInput" name="sdate" placeholder="请输入考试开始时间">
            </div>
        </div>
        <div class="form-group">
            <label for="edateInput" class="col-sm-2 control-label">结束时间</label>
            <div class="col-sm-6">
                <input type="date" class="form-control" id="edateInput" name="edate" placeholder="请输入考试结束时间">
            </div>
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
        $("#subjectInput").keyup(function () {
            $.get(
                // 需修改路径
                "${appContext}/admin/subjectExistAjax?subject="+encodeURI($("#subjectInput").val()),
                function(result){
                    if(result=="该科目考试已存在"){
                        $("#subjectTips").addClass("danger").text(result);
                        $("#subjectTips").parent().addClass("text-danger");
                        $("button").addClass("disabled");
                    }else{
                        $("#subjectTips").addClass("success").text(result);
                        $("#subjectTips").parent().addClass("text-success");
                        $("button").removeClass("disabled");
                        flag=true;
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
