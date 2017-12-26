<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link rel="stylesheet" href="css/other.css">
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <title>请假页面</title>
</head>
<body>
<div class="container contain_style" >
    <div class="panel panel-default">
        <div class="panel-heading"  style="padding: 5px 0 5px 20px">
            <h4>请假信息填写：</h4>
        </div>
        <div class="panel-body" style="padding: 0px 0px 0px 30px">
            <p><h4><b>注意:</b>请正确填写相关信息!提交的请假信息可在未批准时进行撤销!</h4></p>
        </div>
        <div class="panel-body" style="padding: 10px 200px 10px 200px">
            <div class="row">
                <form id="huamingcefrom" method="post">
                    <div class="form-group">
                        <label>姓名：</label>
                        <input type="text" class="form-control" name="grade">
                    </div>
                    <div class="form-group">
                        <label>出差时间：</label>
                        <input type="text" class="form-control" name="grade">
                    </div>
                    <div class="form-group">
                        <label>出差地点：</label>
                        <input type="text" class="form-control" name="klass">
                    </div>
                    <div class="form-group">
                        <label>事由：</label>
                        <textarea class="form-control" name="klass"></textarea>
                    </div>
                    <div class="form-group">
                        <label>联系方式：</label>
                        <input type="text" class="form-control" name="klass">
                    </div>
                    <div class="form-group">
                        <label>选择中层领导：</label>
                        <select class="form-control" name="major">
                            <option value="020102">李老师</option>
                            <option value="110201">张老师</option>
                            <option value="110203">刘老师</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>选择高层领导：</label>
                        <select class="form-control" name="major">
                            <option value="020102">李老师</option>
                            <option value="110201">张老师</option>
                            <option value="110203">刘老师</option>
                        </select>
                    </div>
                    <button type="button" class="btn btn-default" onclick="subForm()">提交</button>
                </form>
            </div>
        </div>
    </div>

    <div id="view">

    </div>
</div>
<script>
    function subForm() {

        alert("提交成功!请联系相关领导批准!");


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
