<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
                <table class="table table-bordered table-hover" id="leaveTable" style="padding: 0 0 0 0">
                    <thead>
                    <tr>
                        <th>提交时间</th>
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
                    <c:forEach var="leave" items="${requestScope.leaves}">
                        <tr>
                            <td>${leave.subTime}</td>
                            <td>${leave.uTname}</td>
                            <td>${leave.leaveTime}</td>
                            <td>${leave.place}</td>
                            <td>${leave.phone}</td>
                            <td>${leave.reason}</td>
                            <td style="color: red"><b>${(leave.leader1) == 1?"处理中":(leave.leader1 == 2 ? "已批准":"未批准") }</b></td>
                            <td style="color: red"><b>${(leave.leader2) == 1?"处理中":(leave.leader2 == 2 ? "已批准":"未批准") }</b></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
         <%--   </div>
        </div>--%>
    </div>

    <div id="view">

    </div>
    <!-- 显示分页信息 -->
    <div class="row">
        <!--分页文字信息  -->
        <div class="col-md-6" id="page_info_area"></div>
        <!-- 分页条信息 -->
        <div class="col-md-6" id="page_nav_area"></div>
    </div>
</div>
<script type="text/javascript">
    $(function(){
        //去首页
        to_page(1);
    });
    function to_page(pn){
        $.ajax({
            url:"getQueryLeave",
            data:{"pn":pn},
            type:"GET",
            success:function(result){
                //console.log(result);
                //1、解析并显示毕业数据
                build_leave_table(result);
                //2、解析并显示分页信息
                build_page_info(result);
                //3、解析显示分页条数据
                build_page_nav(result);
            }
        });
    }
    function build_leave_table(result){
        //清空table表格
        $("#leaveTable tbody").empty();
        var leaves = result.jsondata.pageInfo.list;
        $.each(leaves,function(index,item){
            var subTime = $("<td></td>").append(item.subTime);
            var uTname = $("<td></td>").append(item.uTname);
            var leaveTime = $("<td></td>").append(item.leaveTime);
            var place = $("<td></td>").append(item.place);
            var phone = $("<td></td>").append(item.phone);
            var reason = $("<td></td>").append(item.reason);
            var zhong = $("<td style='color: red'></td>").append((item.leader1) == 1?"处理中":(item.leader1 == 2 ? "已批准":"未批准"));
            var gao = $("<td style='color: red'></td>").append((item.leader2) == 1?"处理中":(item.leader2 == 2 ? "已批准":"未批准"));

            //append方法执行完成以后还是返回原来的元素
            $("<tr></tr>").append(subTime)
                .append(uTname)
                .append(leaveTime)
                .append(place)
                .append(phone)
                .append(reason)
                .append(zhong)
                .append(gao)
                .appendTo("#leaveTable tbody");
        });
    }


    //解析显示分页信息
    var totalRecord,currentPage;//保存总记录数和当前页码
    function build_page_info(result){
        $("#page_info_area").empty();
        $("#page_info_area").append("当前"+result.jsondata.pageInfo.pageNum+"页,总"+
            result.jsondata.pageInfo.pages+"页,总"+
            result.jsondata.pageInfo.total+"条记录");
        totalRecord = result.jsondata.pageInfo.total;
        currentPage = result.jsondata.pageInfo.pageNum;
    }

    //解析显示分页条，点击分页要能去下一页....
    function build_page_nav(result) {
        //page_nav_area
        $("#page_nav_area").empty();
        var ul = $("<ul></ul>").addClass("pagination");

        //构建元素
        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
        var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
        if (result.jsondata.pageInfo.hasPreviousPage === false) {//没有上一页将第一页和上一页设为不可用
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        } else {
            //为元素添加点击翻页的事件
            firstPageLi.click(function () {
                to_page(1);
            });
            prePageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum - 1);
            });
        }
        var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
        if(result.jsondata.pageInfo.hasNextPage === false){//没有下一页
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        }else{
            nextPageLi.click(function(){
                to_page(result.jsondata.pageInfo.pageNum +1);
            });
            lastPageLi.click(function(){
                to_page(result.jsondata.pageInfo.pages);
            });
        }

        //添加首页和前一页 的提示
        ul.append(firstPageLi).append(prePageLi);
        //1,2，3遍历给ul中添加页码提示
        $.each(result.jsondata.pageInfo.navigatepageNums,function(index,item){
            var numLi = $("<li></li>").append($("<a></a>").append(item));
            if(result.jsondata.pageInfo.pageNum === item){
                numLi.addClass("active");
            }
            numLi.click(function(){
                to_page(item);
            });
            ul.append(numLi);
        });
        //添加下一页和末页 的提示
        ul.append(nextPageLi).append(lastPageLi);

        //把ul加入到nav
        var navEle = $("<nav></nav>").append(ul);
        navEle.appendTo("#page_nav_area");
    }
</script>
</body>
</html>
