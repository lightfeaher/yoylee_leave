<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/index.css">
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <title>欢迎</title>
</head>

<body onload="showMsg()">
<div class="back">
    <img src="image/bg2.jpg" alt="">
</div>
<div class="login">
    <div class="img">
        <img src="image/zd.png" alt="">
    </div>
    <div class="nav">
        <div class="font1">
            <h2>登陆</h2>
        </div>

        <input id="username" class="input-1" type="text" name="username" placeholder="用户名">
        <input id="password" class="input-2" type="password" name="password" placeholder="密码">
        <input id="confirm" class="input-3" type="text" name="confirm" placeholder="验证码">

        <div class="div-1">
            <a id="changeConfirmCode"><img src="ConfirmCode" id="ConfirmCode" style="width: 100%;height: 100%" alt="验证码"/></a>
        </div>

        <div class="div-2">
            <button onclick="forgetpwd()">忘记密码</button>
        </div>
        <input class="button-1" type="submit" style="cursor:pointer;" value="登录"/>
        <input class="button-2" style="cursor:pointer;" type="reset" value="重置"/>
        <input type="hidden" id="msg" value="${message }"/>

    </div>
</div>

<script type="text/javascript">
    function check() {
        var account = document.getElementById("username").value;
        var pwd = document.getElementById("password").value;
        var ckcd = document.getElementById("confirm").value;
        if (account.replace(/^ +| +$/g, '') === "") {
            alert("用户名不能为空！");
            return false;
        }
        else if (pwd.replace(/^ +| +$/g, '') === "") {
            alert("密码不能为空！");
            return false;
        }
        else if (ckcd.replace(/^ +| +$/g, '') === "") {
            alert("请输入验证码！");
            return false;
        }
        else return true;
    }

    function showMsg() {
        var msg = document.getElementById("msg").value;
        if (msg === 1) alert("验证码错误！");
        else if (msg === 2) alert("用户不存在或者密码不正确！");
        else if (msg === 3) alert("用户不存在或者密码不正确！");
    }

    $(".button-1").click(function () {
        if (check()) {
            location.href = "managemain.jsp";
           /* var username = $('#username').val();
            var password = $('#password').val();
            var confirm = $('#confirm').val();
            $.ajax({
                url: "login",
                type: "POST",
                data: {username: username, password: password, confirm: confirm},
                dataType: "json",
                success: function (result) {
                    if (result.code === 200) {
                        location.href = "main.jsp";
                    } else if (result.code === 201) {
                        location.href = "managemain.jsp"
                    } else if (result.code === 100) {
                        alert("登录失败请检查用户名或者密码\n注意！输错5次密码，用户将被锁定10分钟！");
                        change();
                    } else if (result.code === 101) {
                        alert("验证码错误");
                        change();
                    } else if (result.code===102){
                        alert("输错密码次数过多，用户被锁定10分钟。");
                    }

                }
            });*/
        }
    });

    $("#changeConfirmCode").click(function () {
        change();
    });

    function change() {
        $("#ConfirmCode").attr("src", "ConfirmCode?t=" + new Date().getTime());
    }

    function forgetpwd() {
        alert("请联系管理员重置密码！")
    }
</script>
</body>

</html>