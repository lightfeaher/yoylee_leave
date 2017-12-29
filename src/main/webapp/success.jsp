<%@ page import="java.util.List" %>
<%@ page import="com.qihang.model.Leave" %>
<%--
  Created by IntelliJ IDEA.
  User: 李洋洋
  Date: 2017/12/27
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        List<Leave> leaves = (List<Leave>) request.getAttribute("leaves");
        for (Leave leave:leaves){
            out.print(leave.toString());
        }
    %>
asdf
</body>
</html>
