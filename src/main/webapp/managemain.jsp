<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link type="text/css"  rel="stylesheet" href="css/main.css">
    <script src="http://cdn.bootcss.com/jquery/1.9.0/jquery.min.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
    <title>动科请假系统首页</title>
</head>
<body>
<div class="nav">
    <div class="top">
        <div class="top1 img">
            <img src="image/zd.png" alt="">
        </div>
        <div class="top0 top3">
            <span id="logout" style="color: red;cursor:pointer">注销用户</span>
        </div>
        <div class="top2">
            <b>权限:</b><span>${sessionScope.user.post == 1?"教师":(sessionScope.user.post==2?"中级领导":(sessionScope.user.post==3?"高级领导":(sessionScope.user.post==4?"院办主任":"无权限")))}</span>
        </div>
        <div class="top2">
            <b>用户名:</b><span>${sessionScope.user.name}</span>
        </div>
    </div>
    <div class="nav2">
        <div class="nav2-0 nav2-1 nav-hover" title="leave">
            <center>请假</center>
        </div>
        <div class="nav2-0" title="getLeaveByUser">
            <center>批准</center>
        </div>

        <div class="nav2-0" title="progressQuery">
            <center>进度查询</center>
        </div>

        <div class="nav2-0"  title="getPrivateLeave">
            <center>请假撤销</center>
        </div>
        <div class="nav2-0"  title="summarySheet">
            <center>请假汇总表</center>
        </div>
        <div class="nav2-0 nav2-2"  title="passwordChange">
            <center>密码修改</center>
        </div>
     </div>
    </div>

    <div class="main">
        <div class="main0">
        <iframe scrolling="no" frameborder="0" class="a"></iframe>
    </div>

    <div class="bottom">
        <center><a href="http://www.sdau.edu.cn">农大主页</a> Copyright@2017
           <br> 山东农业大学动物科技学院 版权所有
        </center>
    </div>
</div>
<script type="text/javascript">
    $("#logout").click(function () {
        location.href="clearSession";
    })
</script>
</body>
</html>
