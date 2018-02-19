<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
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
    <script src="http://apps.bdimg.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
    <script src="http://apps.bdimg.com/libs/respond.js/1.4.2/respond.min.js"></script>
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
            <p><span class="span-sty">*出差时间格式: 2017.3.20-2017.11.5</span></p>
        </div>
        <div class="panel-body" style="padding: 10px 200px 10px 200px">
            <div>
                <form id="huamingcefrom" method="post" class="form-horizontal">
                    <div class="form-group">
                        <label class="input_wh">姓名：</label>
                        <input type="text"  class="input_wh2"  name="grade">
                        <span class="span-sty">*必填</span>
                    </div>
                    <div class="form-group">
                        <label class="input_wh">出差时间：</label>
                        <input type="text"  class="input_wh2"  name="grade">
                        <span class="span-sty">*必填</span>
                    </div>
                    <div class="form-group">
                        <label  class="input_wh">出差地点：</label>
                        <input type="text" class="input_wh2" name="klass">
                        <span class="span-sty">*必填</span>
                    </div>
                    <div class="form-group">
                        <label class="input_wh" >事由：</label>
                        <textarea  name="klass" style="width: 300px;height: 40px"></textarea>
                        <span class="span-sty">*必填</span>
                    </div>
                    <div class="form-group">
                        <label class="input_wh">联系方式：</label>
                        <input type="text" class="input_wh2"  name="klass">
                        <span class="span-sty">*必填</span>
                    </div>
                    <div class="form-group">
                        <label  class="input_wh">选择中层领导：</label>
                        <select  name="major">
                            <option value="020102">李老师</option>
                            <option value="110201">张老师</option>
                            <option value="110203">刘老师</option>
                        </select>
                        <span class="span-sty">*必选</span>
                    </div>
                    <div class="form-group">
                        <label  class="input_wh">选择高层领导：</label>
                        <select  name="major">
                            <option value="020102">李老师</option>
                            <option value="110201">张老师</option>
                            <option value="110203">刘老师</option>
                        </select>
                        <span class="span-sty">*必选</span>
                    </div>
                    <button type="button" class="btn btn-primary" onclick="subForm()" style="margin-right: 30px">提交</button>
                    <button type="reset" class="btn btn-warning">重置</button>
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
