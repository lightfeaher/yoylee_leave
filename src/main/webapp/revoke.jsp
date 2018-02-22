<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <title>请假撤销页面</title>
</head>
<body>
<div class="container contain_style">
    <div class="panel panel-default">
        <div class="panel-heading"  style="padding: 5px 0 5px 20px">
            <h4>个人请假信息列表：</h4>
        </div>
        <%--<div class="panel-body">
            <div class="row" style="margin-top: 20px;padding: 0 10px 0 10px">
--%>
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>姓名</th>
                        <th>出差时间</th>
                        <th>出差地点</th>
                        <th>联系方式</th>
                        <th>事由</th>
                        <th>是否撤销</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach var="leave" items="${requestScope.leaves}">
                        <tr>
                            <td>${leave.uTname}</td>
                            <td>${leave.leaveTime}</td>
                            <td>${leave.place}</td>
                            <td>${leave.phone}</td>
                            <td>${leave.reason}</td>
                            <td>
                                <button class="btn btn-danger" del_id = "${leave.id}" leave_time = ${leave.leaveTime}>
                                    <span class="glyphicon glyphicon-trash">撤销</span>
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

            <%--</div>
        </div>--%>
    </div>

    <div id="view">

    </div>
</div>
<script>
    $(".btn").click(function () {
        var delId = $(this).attr("del_id");
        var leaveTime = $(this).attr("leave_time");
        var thisBtn = $(this);
//        alert(delId);
        if(confirm("确定删除出差时间为:"+leaveTime+"的请假信息吗?")) {
            $.ajax({
                url: "revokeLeave",
                type: "POST",
                data: {"delId": delId},
                success: function (result) {
                    if (result.code == 200){
                        alert("请假信息撤回成功!")
                        thisBtn.parent().parent().remove();
                    }
                    else
                        alert("请假信息撤回失败!请刷新并重新尝试!")
                },
                fail: function () {
                    alert("系统发生错误!请稍后再试!");
                }
            })
        }
    })
</script>
</body>
</html>
