<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<HTML>管理员页面
<HEAD>
    <META http-equiv=Content-Type content="text/html" ; charset="utf-8">
    <title>学生管理</title>
    <base target="mainF" />
    <style>
        BODY {
            MARGIN: 0px
        }

        P {
            MARGIN: 0px
        }

        BODY {
            COLOR: #000;
            BACKGROUND-COLOR: #fff
        }

        BODY {
            FONT-SIZE: 12px;
            LINE-HEIGHT: 150%;
            FONT-FAMILY: "Verdana", "Arial", "Helvetica", "sans-serif"
        }

        TABLE {
            FONT-SIZE: 12px;
            LINE-HEIGHT: 150%;
            FONT-FAMILY: "Verdana", "Arial", "Helvetica", "sans-serif"
        }

        INPUT {
            FONT-SIZE: 12px;
            FONT-FAMILY: "Verdana", "Arial", "Helvetica", "sans-serif"
        }

        SELECT {
            FONT-SIZE: 12px;
            FONT-FAMILY: "Verdana", "Arial", "Helvetica", "sans-serif"
        }

        TEXTAREA {
            FONT-SIZE: 12px;
            FONT-FAMILY: "Verdana", "Arial", "Helvetica", "sans-serif"
        }

        A:link {
            COLOR: #036;
            TEXT-DECORATION: none
        }

        A:visited {
            COLOR: #036;
            TEXT-DECORATION: none
        }

        A:hover {
            COLOR: #f60;
            TEXT-DECORATION: underline
        }

        A.menuChild:link {
            COLOR: #036;
            TEXT-DECORATION: none
        }

        A.menuChild:visited {
            COLOR: #036;
            TEXT-DECORATION: none
        }

        A.menuChild:hover {
            COLOR: #f60;
            TEXT-DECORATION: underline
        }

        A.menuParent:link {
            COLOR: #000;
            TEXT-DECORATION: none
        }

        A.menuParent:visited {
            COLOR: #000;
            TEXT-DECORATION: none
        }

        A.menuParent:hover {
            COLOR: #f60;
            TEXT-DECORATION: none
        }

        TABLE.position {
            WIDTH: 100%
        }

        TR.position {
            HEIGHT: 25px;
            BACKGROUND-COLOR: #f4f7fc
        }

        TD.position {
            BORDER-RIGHT: #adceff 1px solid;
            PADDING-LEFT: 20px;
            BORDER-BOTTOM: #adceff 1px solid
        }

        TABLE.listTable {
            WIDTH: 98%;
            BACKGROUND-COLOR: #b1ceee
        }

        TR.listHeaderTr {
            FONT-WEIGHT: bold;
            HEIGHT: 25px;
            BACKGROUND-COLOR: #ebf4fd;
            TEXT-ALIGN: center
        }

        TR.listTr {
            HEIGHT: 25px;
            BACKGROUND-COLOR: #fff;
            TEXT-ALIGN: center
        }

        TR.listAlternatingTr {
            HEIGHT: 25px;
            BACKGROUND-COLOR: #fffdf0;
            TEXT-ALIGN: center
        }

        TR.listFooterTr {
            HEIGHT: 30px;
            BACKGROUND-COLOR: #ebf4fd;
            TEXT-ALIGN: center
        }

        TABLE.editTable {
            WIDTH: 98%;
            BACKGROUND-COLOR: #b1ceee
        }

        TR.editHeaderTr {
            HEIGHT: 25px;
            BACKGROUND-COLOR: #ebf4fd
        }

        TD.editHeaderTd {
            PADDING-LEFT: 50px;
            FONT-WEIGHT: bold
        }

        TR.editTr {
            HEIGHT: 30px
        }

        TD.editLeftTd {
            WIDTH: 150px;
            BACKGROUND-COLOR: #fffdf0;
            TEXT-ALIGN: center
        }

        TD.editRightTd {
            PADDING-LEFT: 10px;
            BACKGROUND-COLOR: #fff
        }

        TR.editFooterTr {
            HEIGHT: 40px;
            BACKGROUND-COLOR: #ebf4fd
        }

        TD.editFooterTd {
            PADDING-LEFT: 150px
        }
    </style>
    <SCRIPT language=javascript>
        function expand(el) {
            childObj = document.getElementById("child" + el);
            if (childObj.style.display == 'none') {
                childObj.style.display = 'block';
            } else {
                childObj.style.display = 'none';
            }
            return;
        }
    </SCRIPT>
</HEAD>
<BODY>
<div class="container-fluid">
    <div class="row">
        学生考试管理系统    欢迎您:${sessionScope.USER_SESSION.username}
<%--        需修改href--%>
        <a target="_self" href="${appContext}/user/logout">退出登录</a>
    </div>
</div>
<TABLE height="100%" cellSpacing=0 cellPadding=0 width=170 background=images/t.jpg border=0>
    <TR>
        <TD vAlign=top align=middle>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                <TR>
                    <TD height=10></TD>
                </TR>
            </TABLE>


            <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
                <TR height=22>
                    <TD style="PADDING-LEFT: 30px" background=images/timg1.jpg><A
                            class=menuParent onclick=expand(1)
                            href="javascript:void(0);">考试管理</A></TD>
                </TR>
                <TR height=4>
                    <TD></TD>
                </TR>
            </TABLE>

            <TABLE id=child1 style="DISPLAY: none" cellSpacing=0 cellPadding=0
                   width=150 border=0>

                <TR height=25>
                    <TD align=middle width=30><IMG height=9
                                                   src="images/t.jpg" width=9></TD>
                    <TD><A class=menuChild
                           href="addstudent.html"
                           target="view_frame">添加学生</A></TD>
                </TR>

                <TR height=25>
                    <TD align=middle width=30><IMG height=9
                                                   src="images/t.jpg" width=9></TD>
                    <TD><A class=menuChild
                           href="${appContext}/admin/addStudent"
                           target="view_frame">分配考场</A></TD>
                </TR>
            </TABLE>


            <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
                <TR height=22>
                    <TD style="PADDING-LEFT: 30px" background=images/timg1.jpg><A
                            class=menuParent onclick=expand(2)
                            href="javascript:void(0);">试卷管理</A></TD>
                </TR>
                <TR height=4>
                    <TD></TD>
                </TR>
            </TABLE>

            <TABLE id=child2 style="DISPLAY: none" cellSpacing=0 cellPadding=0
                   width=150 border=0>

                <TR height=25>
                    <TD align=middle width=30><IMG height=9
                                                   src="images/menu_icon.gif" width=9></TD>
                    <TD><A class=menuChild
                           href="#"
                           target="view_frame">收取试卷</A></TD>
                </TR>

                <TR height=25>
                    <TD align=middle width=30><IMG height=9
                                                   src="images/menu_icon.gif" width=9></TD>
                    <TD><A class=menuChild
                           href="#"
                           target=main>评阅试卷</A></TD>
                </TR>
                <TR height=4>
                    <TD colSpan=2></TD>
                </TR>
            </TABLE>

            <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
                <TR height=22>
                    <TD style="PADDING-LEFT: 30px" background=images/timg1.jpg><A
                            class=menuParent onclick=expand(3)
                            href="javascript:void(0);">成绩管理</A></TD>
                </TR>
                <TR height=4>
                    <TD></TD>
                </TR>
            </TABLE>

            <TABLE id=child3 style="DISPLAY: none" cellSpacing=0 cellPadding=0
                   width=150 border=0>

                <TR height=25>
                    <TD align=middle width=30><IMG height=9
                                                   src="images/menu_icon.gif" width=9></TD>
                    <TD><A class=menuChild
                           href="#"
                           target=main>录入成绩</A></TD>
                </TR>

                <TR height=25>
                    <TD align=middle width=30><IMG height=9
                                                   src="images/menu_icon.gif" width=9></TD>
                    <TD><A class=menuChild
                           href="#"
                           target=main>修改成绩</A></TD>
                </TR>
                <TR height=4>
                    <TD colSpan=2></TD>
                </TR>
            </TABLE>

            <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
                <TR height=22>
                    <TD style="PADDING-LEFT: 30px" background=images/timg1.jpg><A
                            class=menuParent onclick=expand(0)
                            href="javascript:void(0);">个人管理</A></TD>
                </TR>
                <TR height=4>
                    <TD></TD>
                </TR>
            </TABLE>

            <TABLE id=child0 style="DISPLAY: none" cellSpacing=0 cellPadding=0
                   width=150 border=0>

                <TR height=25>
                    <TD align=middle width=30><IMG height=9
                                                   src="images/menu_icon.gif" width=9></TD>
                    <TD><A class=menuChild
                           href="#"
                           target=main>修改密码</A></TD>
                </TR>

                <TR height=25>
                    <TD align=middle width=30><IMG height=9
                                                   src="images/menu_icon.gif" width=9></TD>
                    <TD><A class=menuChild
                           onclick="if (confirm('确定要退出吗？')) return true; else return false;"
                           href="https://www.jb51.net"
                           target=_top>退出系统</A></TD>
                </TR>
            </TABLE>
        </TD>
        <TD width=1 bgColor=#d1e6f7></TD>
    </TR>
</TABLE>
</BODY>
</HTML>
