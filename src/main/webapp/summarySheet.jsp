<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%--<script src="js/jquery-3.2.1.min.js"></script>--%>
    <script src="http://cdn.bootcss.com/jquery/1.9.1/jquery.min.js"></script>

    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link rel="stylesheet" href="css/other.css">
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->

    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <title>请假信息汇总表页面</title>
</head>
<body>

<div  class="modal fade"  id="leaveDails" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="margin-left: 25%;width:50%">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h5 class="modal-title">请假详细信息</h5>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="input_wh">姓名:</label>
                        <div class="col-sm-5">
                            <span id="name"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="input_wh">院系:</label>
                        <div class="col-sm-5">
                            <span id="sys"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="input_wh">出差时间:</label>
                        <div class="col-sm-5">
                            <span id="leaveTime"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="input_wh">出差地点:</label>
                        <div class="col-sm-5">
                            <span id="place"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="input_wh">联系电话:</label>
                        <div class="col-sm-5">
                            <span id="phone"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="input_wh">事由:</label>
                        <div class="col-sm-5">
                            <span id="reason"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="input_wh">选择中层领导:</label>
                        <div class="col-sm-5">
                            <span id="ulname1"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="input_wh">选择高层领导:</label>
                        <div class="col-sm-5">
                            <span id="ulname2"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="input_wh">中层是否批准:</label>
                        <div class="col-sm-5">
                            <span id="leader1"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="input_wh">高层是否批准:</label>
                        <div class="col-sm-5">
                            <span id="leader2"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="input_wh">提交时间:</label>
                        <div class="col-sm-5">
                            <span id="subTime"></span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn-wh" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>

<div class="container contain_style">
    <div class="panel panel-default">
        <div class="panel-heading"  style="padding: 5px 0 5px 20px">
            <h5>请假信息汇总表：<span style="color: red">教师只能查询自己的,中层领导可以查询本系的,高层领导和院办主任可以查询所有的!</span></h5>
                是否批准:
                <select name = "orApprove" id="orApprove">
                    <option value="0">不限</option>
                    <option value="1">批准</option>
                    <option value="2">未批准</option>
                </select>
                院系:
                <select name = "systemId" id="systemId">
                    <%--<option value="0">不限</option>--%>
                    <%--<option value="1">1系</option>--%>
                    <%--<option value="2">2系</option>--%>
                    <%--<option value="3">3系</option>--%>
                </select>
                姓名:<input type="text" name="name" id="nameId">
                <button style="margin-left:20px " class = "btn_select">查询</button>
        </div>
        <%--<div class="panel-body">
            <div class="row" style="margin-top: 20px;padding: 0 10px 0 10px">--%>

                <table class="table table-bordered table-hover" id="leaveTable">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>姓名</th>
                        <th>出差时间</th>
                        <th>出差地点</th>
                        <th>联系方式</th>
                        <th>事由</th>
                        <th>操作</th>
                    </tr>
                    </thead>

                    <tbody>

                    </tbody>
                </table>

           <%-- </div>
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
<script>
    $(function(){
        //去首页
        to_page(1);
        $.ajax({
            url:"getSystem",
            type:"GET",
            dataType:"json",
            success:function(result){
                var majors = result.jsondata.systems;
                $.each(majors,function (index,item) {
                    $("#systemId").append($("<option></option>").attr("value",item.id).text(item.system));
                });
            }
        });
    });
    function to_page(pn){
        $.ajax({
            url:"getAllLeave",
            data:{"pn":pn},
            type:"GET",
            success:function(result){
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
            var id = $("<td></td>").append(item.id);
            var uTname = $("<td></td>").append(item.uTname);
            var leaveTime = $("<td></td>").append(item.leaveTime);
            var place = $("<td></td>").append(item.place);
            var phone = $("<td></td>").append(item.phone);
            var reason = $("<td></td>").append(item.reason);
            //添加详情按钮
            var seeBtn = $("<td></td>").append($("<button></button>").addClass("btn-wh see_btn").append("详情"));
            // 为按钮添加一个自定义的属性，来表示当前请假信息的id
            seeBtn.attr("see-id",item.id);

            //append方法执行完成以后还是返回原来的元素
            $("<tr></tr>").append(id)
                .append(uTname)
                .append(leaveTime)
                .append(place)
                .append(phone)
                .append(reason)
                .append(seeBtn)
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

    //模糊查询
    $(".btn_select").click(function () {
        to_selectpage(1);
    });
    function to_selectpage(pn){
        var orApprove = $("#orApprove").val();
        var systemId = $("#systemId").val();
        var nameId = $("#nameId").val();
        $.ajax({
            url:"getLeaveByLike",
            type:"GET",
            data:{"orApprove":orApprove,"systemId":systemId,"nameId":nameId,"pn":pn},
            success:function (result) {
                //1、解析并显示毕业数据
                build_leave_table(result);
                //2、解析并显示分页信息
                build_page_info(result);
                //3、解析显示分页条数据
                build_page_nav(result);
            },
            fail:function () {
                alert("服务器出现错误,请稍后重试!")
            }
        })
    }

    //查询详情模态框
    //点击编辑弹出详情模态框
    $(document).on("click",".see_btn",function(){
        //2、查出信息显示在模态框
        xiangqing($(this).parent().attr("see-id"));
        $("#leaveDails").modal({
            backdrop:"static"
        });
    });
    function xiangqing(id) {
        $.ajax({
            url: "getSingleLeave/" + id,
            type: "GET",
            dataType: "json",
            success: function (result) {
                var leave = result.jsondata.singleLeave;
                $("#name").html(leave.uTname);
                $("#sys").html(leave.system.system);
                $("#leaveTime").html(leave.leaveTime);
                $("#place").html(leave.place);
                $("#phone").html(leave.phone);
                $("#reason").html(leave.reason);
                $("#ulname1").html(leave.user.name);
                $("#ulname2").html(leave.user2.name);
                $("#leader1").html(leave.leader1 == 2?"已批准":"未批准");
                $("#leader2").html(leave.leader2 == 2?"已批准":"未批准");
                $("#subTime").html(leave.subTime);
            }
        })
    }
</script>
</body>
</html>
