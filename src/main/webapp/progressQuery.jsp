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

    <title>进度查询页面</title>
</head>
<body>
<div class="container contain_style">
    <div class="panel panel-default">
        <div class="panel-heading"  style="padding: 5px 0 5px 20px">
            <h4>个人请假进度列表：</h4>
        </div>
        <div class="panel-body">
            <p><h4><b>注意:</b>中层领导和高层领导全部批准后才表示请假成功!</h4></p>
        </div>
        <%--<div class="panel-body">
            <div class="row" style="padding: 0 10px 0 10px">--%>
                <table class="table table-bordered table-hover" style="padding: 0 0 0 0">
                    <thead>
                    <tr>
                        <th>姓名</th>
                        <th>出差时间</th>
                        <th>出差地点</th>
                        <th>联系方式</th>
                        <th>事由</th>
                        <th>中层是否批准</th>
                        <th>高层是否批准</th>
                    </tr>
                    </thead>

                    <tbody>
                    <tr>
                        <td>李老师1</td>
                        <td>17.10.3</td>
                        <td>北京</td>
                        <td>188124123</td>
                        <td>研讨会</td>
                        <td style="color: red"><b>已批准</b></td>
                        <td style="color: red"><b>未批准</b></td>
                    </tr>
                    <tr>
                        <td>李老师1</td>
                        <td>17.10.3</td>
                        <td>北京</td>
                        <td>188124123</td>
                        <td>研讨会</td>
                        <td style="color: red"><b>已批准</b></td>
                        <td style="color: red"><b>处理中</b></td>
                    </tr>
                    <tr>
                        <td>李老师1</td>
                        <td>17.10.3</td>
                        <td>北京</td>
                        <td>188124123</td>
                        <td>研讨会</td>
                        <td style="color: red"><b>处理中</b></td>
                        <td style="color: red"><b>处理中</b></td>
                    </tr>
                    </tbody>
                </table>

         <%--   </div>
        </div>--%>
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
