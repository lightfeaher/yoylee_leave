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
                        <label>姓名：</label>
                        <input type="text" class="form-control" name="grade">
                    </div>
                    <div class="form-group">
                        <label>原密码：</label>
                        <input type="password" class="form-control" name="grade">
                    </div>
                    <div class="form-group">
                        <label>新密码：</label>
                        <input type="password" class="form-control" name="klass">
                    </div>
                    <div class="form-group">
                        <label>重复新密码：</label>
                        <input type="password" class="form-control" name="klass">
                    </div>
                    <button type="button" class="btn btn-default" onclick="subForm()">修改</button>
                </form>
            </div>
        </div>
        <div class="panel-footer" style="color: red">修改成功!新密码为:***</div>
    </div>

    <div id="view">

    </div>
</div>
<script>
    function subForm() {

        alert("修改成功!新密码为:*****,请谨记!");


        /*$.ajax({
            url: "tableView/exportRosterView",
            type: "POST",
            dataType: "html",
            data: $("#huamingcefrom").serialize(),
            success: function (data) {
                $("#view").html(data);
            }
        });*/
    }
</script>
</body>
</html>
