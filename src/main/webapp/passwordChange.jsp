<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%--<script src="js/jquery-3.2.1.min.js"></script>--%>
    <script src="http://cdn.bootcss.com/jquery/1.9.0/jquery.min.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link rel="stylesheet" href="css/other.css">
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <title>密码修改页面</title>
</head>
<body>
<div class="container contain_style" >
    <div class="panel panel-default">
        <div class="panel-heading"  style="padding: 5px 0 5px 20px">
            <h4>个人密码修改：</h4>
        </div>
        <div class="panel-body" style="padding: 0px 0px 0px 30px">
            <p><h4><b>注意:</b>请谨记您修改的密码!密码忘记可找相关管理员重置!</h4></p>
        </div>
        <div class="panel-body" style="padding: 30px 200px 30px 200px">
            <div class="row">
                <form id="huamingcefrom" method="post">
                    <div class="form-group">
                        <label  class="input_wh">姓名：</label>
                        <input type="text" class="input_wh2" name="name" id="name" value="${sessionScope.user.name}" readonly>
                    </div>
                    <div class="form-group">
                        <label  class="input_wh">原密码：</label>
                        <input type="password" class="input_wh2" name="oldpass" id="oldpass">
                    </div>
                    <div class="form-group">
                        <label  class="input_wh">新密码：</label>
                        <input type="password" class="input_wh2" name="newpass1" id="newpass1">
                    </div>
                    <div class="form-group">
                        <label  class="input_wh">重复新密码：</label>
                        <input type="password" class="input_wh2" name="newpass2" id="newpass2">
                    </div>
                    <button type="button" class="btn btn-primary">修改</button>
                </form>
            </div>
        </div>
        <div class="panel-footer" style="color: red">
            <span id="message"></span>
        </div>
    </div>

    <div id="view">

    </div>
</div>
<script>
    function checkForm(){
        var oldpass = $("#oldpass").val();
        var newpass1 = $("#newpass1").val();
        var newpass2 = $("#newpass2").val();
        if (oldpass.replace(/^ +| +$/g, '') === "") {
            alert("密码不能为空！");
            return false;
        }
        else if (newpass1.replace(/^ +| +$/g, '') === "") {
            alert("新密码不能为空！");
            return false;
        }
        else if (newpass2.replace(/^ +| +$/g, '') === "") {
            alert("重复密码不能为空！");
            return false;
        }else if (newpass1 !== newpass2){
            alert("新密码两次输入不相同,请重新输入!");
            return false;
        }
        else return true;
    }
    $(function () {
        $(".btn").click(function () {
            if(checkForm()){
                $(".btn").attr({"disabled": "disabled"}).val("修改中..");
                var oldpass = $("#oldpass").val();
                var newpass1 = $("#newpass1").val();
                var newpass2 = $("#newpass2").val();
                $.ajax({
                    url:"changePassword",
                    type:"POST",
                    data:{"oldpass":oldpass,"newpass1":newpass1,"newpass2":newpass2},
                    success:function (result) {
                        $("#message").html(result.msg);
                        $(".btn").removeAttr("disabled").html("修改");
                    },
                    fail:function () {
                        alert("系统出现错误,请稍后重试!");
                    }
                })
            }
        })
    })
</script>
</body>
</html>
