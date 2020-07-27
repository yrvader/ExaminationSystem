<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>管理员页面<head>
<meta http-equiv=content-type content="text/html"; charset="utf-8">
<style>
body {
 margin: 0px
}
p {
 margin: 0px
}
body {
 color: #000; background-color: #fff
}
body {
 font-size: 12px; line-height: 150%; font-family: "verdana", "arial", "helvetica", "sans-serif"
}
table {
 font-size: 12px; line-height: 150%; font-family: "verdana", "arial", "helvetica", "sans-serif"
}
input {
 font-size: 12px; font-family: "verdana", "arial", "helvetica", "sans-serif"
}
select {
 font-size: 12px; font-family: "verdana", "arial", "helvetica", "sans-serif"
}
textarea {
 font-size: 12px; font-family: "verdana", "arial", "helvetica", "sans-serif"
}
a:link {
 color: #036; text-decoration: none
}
a:visited {
 color: #036; text-decoration: none
}
a:hover {
 color: #f60; text-decoration: underline
}
a.menuchild:link {
 color: #036; text-decoration: none
}
a.menuchild:visited {
 color: #036; text-decoration: none
}
a.menuchild:hover {
 color: #f60; text-decoration: underline
}
a.menuparent:link {
 color: #000; text-decoration: none
}
a.menuparent:visited {
 color: #000; text-decoration: none
}
a.menuparent:hover {
 color: #f60; text-decoration: none
}
table.position {
 width: 100%
}
tr.position {
 height: 25px; background-color: #f4f7fc
}
td.position {
 border-right: #adceff 1px solid; padding-left: 20px; border-bottom: #adceff 1px solid
}
table.listtable {
 width: 98%; background-color: #b1ceee
}
tr.listheadertr {
 font-weight: bold; height: 25px; background-color: #ebf4fd; text-align: center
}
tr.listtr {
 height: 25px; background-color: #fff; text-align: center
}
tr.listalternatingtr {
 height: 25px; background-color: #fffdf0; text-align: center
}
tr.listfootertr {
 height: 30px; background-color: #ebf4fd; text-align: center
}
table.edittable {
 width: 98%; background-color: #b1ceee
}
tr.editheadertr {
 height: 25px; background-color: #ebf4fd
}
td.editheadertd {
 padding-left: 50px; font-weight: bold
}
tr.edittr {
 height: 30px
}
td.editlefttd {
 width: 150px; background-color: #fffdf0; text-align: center
}
td.editrighttd {
 padding-left: 10px; background-color: #fff
}
tr.editfootertr {
 height: 40px; background-color: #ebf4fd
}
td.editfootertd {
 padding-left: 150px
}
</style>
<script language=javascript>
 function expand(el)
 {
  childobj = document.getelementbyid("child" + el);
  if (childobj.style.display == 'none')
  {
   childobj.style.display = 'block';
  }
  else
  {
   childobj.style.display = 'none';
  }
  return;
 }
</script>
</head>
<body>
<table height="100%" cellspacing=0 cellpadding=0 width=170 background=images/t.jpg border=0>
       <tr>
           <td valign=top align=middle>
                   <table cellspacing=0 cellpadding=0 width="100%" border=0>
                              <tr><td height=10></td></tr></table>
                   

<table cellspacing=0 cellpadding=0 width=150 border=0>
<tr height=22>
 <td style="padding-left: 30px" background=images/timg1.jpg><a 
 class=menuparent onclick=expand(1)
 href="javascript:void(0);">考试管理</a></td></tr>
 <tr height=4>
<td></td></tr></table>

 <table id=child1 style="display: none" cellspacing=0 cellpadding=0 
 width=150 border=0>
 
 <tr height=25>
  <td align=middle width=30><img height=9 
  src="images/t.jpg" width=9></td>
  <td><a class=menuchild 
  href="addstudent.html"
  target="view_frame">添加学生</a></td></tr>
 
<tr height=25>
  <td align=middle width=30><img height=9 
  src="images/t.jpg" width=9></td>
  <td><a class=menuchild 
  href="examroom.html"
  target="view_frame">分配考场</a></td></tr>
 </table>
 

<table cellspacing=0 cellpadding=0 width=150 border=0>
 <tr height=22>
  <td style="padding-left: 30px" background=images/timg1.jpg><a 
  class=menuparent onclick=expand(2) 
  href="javascript:void(0);">试卷管理</a></td></tr>
 <tr height=4>
  <td></td></tr></table>

 <table id=child2 style="display: none" cellspacing=0 cellpadding=0 
 width=150 border=0>
 
<tr height=25>
  <td align=middle width=30><img height=9 
  src="images/menu_icon.gif" width=9></td>
  <td><a class=menuchild 
  href="#"
  target="view_frame">收取试卷</a></td></tr>
 
<tr height=25>
  <td align=middle width=30><img height=9 
  src="images/menu_icon.gif" width=9></td>
  <td><a class=menuchild 
  href="#"
  target=main>评阅试卷</a></td></tr>
 <tr height=4>
  <td colspan=2></td></tr>
</table>

 <table cellspacing=0 cellpadding=0 width=150 border=0>
 <tr height=22>
  <td style="padding-left: 30px" background=images/timg1.jpg><a 
  class=menuparent onclick=expand(3) 
  href="javascript:void(0);">成绩管理</a></td></tr>
 <tr height=4>
  <td></td></tr></table>

 <table id=child3 style="display: none" cellspacing=0 cellpadding=0 
 width=150 border=0>
 
<tr height=25>
  <td align=middle width=30><img height=9 
  src="images/menu_icon.gif" width=9></td>
  <td><a class=menuchild 
  href="#"
  target=main>录入成绩</a></td></tr>
 
<tr height=25>
  <td align=middle width=30><img height=9 
  src="images/menu_icon.gif" width=9></td>
  <td><a class=menuchild 
  href="#"
  target=main>修改成绩</a></td></tr>
 <tr height=4>
  <td colspan=2></td></tr>
</table>

 <table cellspacing=0 cellpadding=0 width=150 border=0>
 <tr height=22>
  <td style="padding-left: 30px" background=images/timg1.jpg><a 
  class=menuparent onclick=expand(0) 
  href="javascript:void(0);">个人管理</a></td></tr>
 <tr height=4>
  <td></td></tr></table>

 <table id=child0 style="display: none" cellspacing=0 cellpadding=0 
 width=150 border=0>

 <tr height=25>
  <td align=middle width=30><img height=9 
  src="images/menu_icon.gif" width=9></td>
  <td><a class=menuchild 
  href="#"
  target=main>修改密码</a></td></tr>

 <tr height=25>
  <td align=middle width=30><img height=9 
  src="images/menu_icon.gif" width=9></td>
  <td><a class=menuchild 
  onclick="if (confirm('确定要退出吗？')) return true; else return false;"
  href="https://www.jb51.net"
  target=_top>退出系统</a></td></tr></table></td>
 <td width=1 bgcolor=#d1e6f7></td></tr>
</table>
</body>
</html>
