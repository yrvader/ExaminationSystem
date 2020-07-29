<%--
  Created by IntelliJ IDEA.
  User: 微软
  Date: 2020/7/27
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>提交试卷</title>
    <link rel="stylesheet" href="${appContext}/css/bootstrap.css" />
</head>
<body>
<%--此处最好展示考试名称，可修改--%>
<h4>科目：${test.subject}</h4>
    <a class="btn btn-success" href="${appContext}/stu/submit?testid=${test.testid}">提交</a>
    <div class="text-danger">提交后不可修改</div>
    <table class="table table-striped table-bordered table-hover">
    <thead>
    <tr class="bg-info">
        <th>序号</th>
        <th>图片</th>
        <th>修改</th>
        <th>删除</th>
    </tr>
    </thead>
    <tbody>
<%--    每张图片的循环--%>
    <c:forEach items="${paths}" var="path" varStatus="status">
       <tr>
           <td>${status.count}</td>
           <td><img src="${appContext}/${path}" width="100px" height="150px"> </td>
           <td>
               <form method="post" enctype="multipart/form-data" action="${appContext}/stu/uploadExam" class="form-horizontal" role="form">
                       <div class="col-sm-10">
                           <input type="file"  class="form-control" id="inputPhoto${status.count}" name="file" placeholder="photo">
                       </div>
                   <input type="hidden" value="${test.testid}" name="testid" />
                   <input type="hidden" value="${status.count}" name="i" />
                   <div class="form-group">
                       <div class="col-sm-10">
                           <button type="submit" class="btn btn btn-primary">确定修改</button>
                       </div>
                   </div>
               </form>
           </td>
<%--           <td><a class="btn btn-info btn-sm" href="${appCOntext}">删除</a></td>--%>
       </tr>
    </c:forEach>

    </tbody>
    </table>
<table/>
<%--多文件但按钮--%>
<%--    <form method="post" enctype="multipart/form-data" action="${appContext}/stu/uploadExam" class="form-horizontal" role="form">--%>
<%--            <div class="form-group">--%>
<%--                <label for="inputPhoto" class="col-sm-2 control-label">photo</label>--%>
<%--                <div class="col-sm-10">--%>
<%--&lt;%&ndash;                    <img id="userPhoto" src="${appContext}/${path}" style="width: 100px;height: 100px;" />&ndash;%&gt;--%>
<%--                    <input type="file" multiple="multiple" value=""  class="form-control" id="inputPhoto" name="file" placeholder="photo">--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <input type="hidden" value="${test.testid}" name="testid">--%>
<%--        <div class="form-group">--%>
<%--            <div class="col-sm-offset-2 col-sm-10">--%>
<%--                <button type="submit" class="btn btn-block btn-primary">修改</button>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </form>--%>

<%--</div>--%>
<script src="${appContext}/js/jquery-3.3.1.js"></script>
<script src="${appContext}/js/bootstrap.js"></script>
<%--<script>--%>
<%--    $(function(){--%>
<%--        //点击图片能够调用 文件域的点击事件--%>
<%--        $("#userPhoto").click(function () {--%>
<%--            $("#inputPhoto").click();--%>
<%--        });--%>
<%--        //文件域的值发生改变,将图片改变--%>
<%--        $("#inputPhoto").change(function (e) {--%>
<%--            var reader = new FileReader();--%>
<%--            reader.onload = (function () {--%>
<%--                return function (e) {--%>
<%--                    $("#userPhoto").attr('src',this.result);--%>
<%--                }--%>
<%--            })(e.target.files[0]);--%>
<%--            reader.readAsDataURL(e.target.files[0]);--%>
<%--        });--%>
<%--    });--%>
<%--</script>--%>
</body>
</html>

