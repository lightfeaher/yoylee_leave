<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="css/global_color.css">
    <%--<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>--%>
    <%--<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">--%>
    <script src="http://cdn.bootcss.com/jquery/1.9.0/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script src="http://apps.bdimg.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
    <script src="http://apps.bdimg.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <title>动科请假系统</title>
</head>
<body class="index">
<div class="login_box">
    <table>
        <tr>
            <td class="login_info">账号：</td>
            <td colspan="2"><input name="username" type="text" class="width150" /></td>
            <td class="login_error_info"><span class="required">不低于3长度的字母、数字或下划线</span></td>
        </tr>
        <tr><br></tr>
        <tr>
            <td class="login_info">密码：</td>
            <td colspan="2"><input name="password" type="password" class="width150" /></td>
            <td><span class="required">不低于6长度的字母、数字或下划线</span></td>
        </tr>
        <tr>
            <td></td>
            <td class="login_button" colspan="3">
                <input type="button" style="cursor:pointer;" value=" 登 录 " onclick="location.href=''" class="button3" >
                <input type="reset" style="cursor:pointer;" value=" 清 空 " class="button3">
            </td>
            <td><span class="required"></span></td>
        </tr>
        <tr><td colspan="4" class="msg login_info"></td></tr>
    </table>
</div>
<script type="text/javascript">

</script>
</body>

</html>