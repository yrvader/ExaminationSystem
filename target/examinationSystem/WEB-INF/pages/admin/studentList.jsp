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
<div class="container">
    <%--    需修改action--%>
    <form method="post" action="${appContext}/admin/addStudent" class="form-horizontal" role="form">
        <div class="form-group">
            <label for="studentnumberInput" class="col-sm-2 control-label">学号</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="studentnumberInput" name="stunumber" placeholder="请输入学号">
            </div>
            <span id="studentnumberTips" class="col-sm-3"></span>
        </div>
        <input type="hidden" name="password" value="123456">
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-block btn-primary">添加</button>
            </div>
        </div>
    </form>
</div>
<table class="table table-striped table-bordered table-hover">
    <thead>
    <tr class="bg-info">
        <th>序号#</th>
        <th>学号</th>
        <th>操作(删除)</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="student" varStatus="status">
        <tr>
            <th>${status.count}</th>
            <td>${student.stunumber}</td>
            <td><a class="btn btn-danger btn-sm" href="${appContext}/admin/delete?stuid=${student.stuid}">删除</a></td>
        </tr>
    </c:forEach>

    </tbody>
</table>
<script src="${appContext}/js/jquery-3.3.1.js"></script>
<script src="${appContext}/js/bootstrap.js"></script>
<script>
    $(document).ready(function(){});
    $(function () {
        var flag=false;

        //当在用户名输入框中触发键盘时做用户是否重名的验证
        $("#studentnumberInput").keyup(function () {
            $.get(
                // 需修改examination怎么传入
                "${appContext}/admin/studentExistAjax?studentnumber="+encodeURI($("#studentnumberInput").val()),
                function(result){
                    if(result=="恭喜您,该学号可添加"){
                        $("#studentnumberTips").addClass("danger").text(result);
                        $("#studentnumberTips").parent().addClass("has-error");
                        $("button").removeClass("disabled");
                        flag=true;
                    }else{
                        $("#studentnumberTips").addClass("success").text(result);
                        $("#studentnumberTips").parent().addClass("has-success");
                        $("button").addClass("disabled");

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

