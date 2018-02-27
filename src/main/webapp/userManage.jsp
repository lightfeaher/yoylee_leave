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

    <title>用户管理</title>
</head>
<body>
<%--编辑用户模态框--%>
<div  class="modal fade"  id="changeUser" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="margin-left: 25%;width:50%">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h5 class="modal-title">编辑用户</h5>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="input_wh">账号:</label>
                        <div class="col-sm-5">
                            <input type="text" name="name_add" id="name_change" class="input_wh2">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="input_wh">院系:</label>
                        <select name = "system_add" id="system_change" style="margin-left: 15px"></select>
                    </div>
                    <div class="form-group">
                        <label class="input_wh">权限:</label>
                        <select name = "post_add" id="post_change" style="margin-left: 15px">
                            <option value="1">教师</option>
                            <option value="2">中层领导</option>
                            <option value="3">高层领导</option>
                            <option value="4">院办主任</option>
                            <option value="5">管理员</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <span style="color: red;margin-left: 100px" id="message_change"></span>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn-wh" id="update_btn">更新</button>
                <button type="button" class="btn-wh" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
<%--新增用户模态框--%>
<div  class="modal fade"  id="addUser" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="margin-left: 25%;width:50%">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h5 class="modal-title">添加用户</h5>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="input_wh">账号:</label>
                        <div class="col-sm-5">
                            <input type="text" name="name_add" id="name_add" class="input_wh2">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="input_wh">院系:</label>
                        <select name = "system_add" id="system_add" style="margin-left: 15px"></select>
                    </div>
                    <div class="form-group">
                        <label class="input_wh">权限:</label>
                        <select name = "post_add" id="post_add" style="margin-left: 15px">
                            <option value="1">教师</option>
                            <option value="2">中层领导</option>
                            <option value="3">高层领导</option>
                            <option value="4">院办主任</option>
                            <option value="5">管理员</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <span style="color: red;margin-left: 100px" id="message_add">添加用户时,请保证用户账号的唯一性!</span>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn-wh" id="add_btn">添加</button>
                <button type="button" class="btn-wh" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>

<div class="container contain_style">
    <div class="panel panel-default">
        <div class="panel-heading"  style="padding: 5px 0 5px 20px">
            <h5>用户列表：<span style="color: red">可进行对用户的/删除/添加/修改/查询操作</span></h5>
                院系:
                <select name = "systemId" id="systemId">
                </select>
                账号:<input type="text" name="nameId" id="nameId">
                <button style="margin-left:20px " class = "btn_select">查询</button>
                <button style="margin-left:100px " class = "btn_add">添加用户</button>
        </div>
        <%--<div class="panel-body">
            <div class="row" style="margin-top: 20px;padding: 0 10px 0 10px">--%>

                <table class="table table-bordered table-hover" id="userTable">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>账号</th>
                        <th>院系</th>
                        <th>权限</th>
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
                $("#systemId").append($("<option></option>").attr("value",0).text("不限"));
                $("#system_add").append($("<option></option>").attr("value",0).text("所有院系"));
                $("#system_change").append($("<option></option>").attr("value",0).text("所有院系"));
                $.each(majors,function (index,item) {
                    $("#system_add").append($("<option></option>").attr("value",item.id).text(item.system));
                    $("#systemId").append($("<option></option>").attr("value",item.id).text(item.system));
                    $("#system_change").append($("<option></option>").attr("value",item.id).text(item.system));
                });
            }
        });


    });
    function to_page(pn){
        $.ajax({
            url:"getAllUser",
            data:{"pn":pn},
            type:"GET",
            success:function(result){
                console.log(result);
                //1、解析并显示数据
                build_user_table(result);
                //2、解析并显示分页信息
                build_page_info(result);
                //3、解析显示分页条数据
                build_page_nav(result);
            }
        });
    }
    function build_user_table(result){
        //清空table表格
        $("#userTable tbody").empty();
        var users = result.jsondata.pageInfo.list;
        $.each(users,function(index,item){
            var id = $("<td></td>").append(item.id);
            var name = $("<td></td>").append(item.name);
            var power = $("<td></td>").append(item.po.post);
            var system = $("<td></td>").append(item.sys.system);
            //添加修改按钮
            var changeBtn = $("<td></td>").append($("<button></button>").addClass("btn-wh change_btn").append("修改"))
                .append($("<button></button>").addClass("btn-wh delete_btn").append("删除"));
            // 为按钮的父元素添加一个自定义的属性，来表示当前请假信息的id
            changeBtn.attr("change-id",item.id);

            //append方法执行完成以后还是返回原来的元素
            $("<tr></tr>").append(id)
                .append(name)
                .append(system)
                .append(power)
                .append(changeBtn)
//                .append(deleteBtn)
                .appendTo("#userTable tbody");
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
        var systemId = $("#systemId").val();
        var nameId = $("#nameId").val();
        $.ajax({
            url:"getUserByLike",
            type:"GET",
            data:{"systemId":systemId,"nameId":nameId,"pn":pn},
            success:function (result) {
                //1、解析并显示数据
                build_user_table(result);
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

    //删除用户
    $(document).on("click",".delete_btn",function(){
        var id = $(this).parent().attr("change-id");
        var thisbtn = $(this);
        if(confirm("确定要删除id为: "+id+" 的用户吗?")){
            $.ajax({
                url:"removeUser",
                type:"POST",
                data:{"id":id},
                success:function (result) {
                    if (result.code === 200) {
                        alert("删除成功!");
                        thisbtn.parent().parent().remove();
                    }else{
                        alert("删除失败!")
                    }
                },
                fail:function () {
                    alert("系统出现错误!请稍后重试!");
                }
            })
        }
    });

    //增加用户模态框
    //点击增加用户弹出增加用户模态框
    $(document).on("click",".btn_add",function(){
        $("#addUser").modal({
            backdrop:"static"
        });
    });
    $("#add_btn").click(function () {
        var name = $("#name_add").val();
        var sys = $("#system_add").val();
        var post = $("#post_add").val();
        if(name.replace(/^ +| +$/g, '') === ""){
            $("#message_add").html("用户名不可以为空!");
        }else
        $.ajax({
            url:"addUser",
            type:"POST",
            data:{"name":name,"system":sys,"post":post},
            success:function (result) {
                if (result.code === 200){
                    $("#message_add").html("添加用户: "+name+" 成功!");
                    $("#name_add").val("");
                }else{
                    $("#message_add").html("添加用户失败!请稍后重试!");
                }
            },
            fail:function () {
                $("#message_add").html("系统出现错误!请稍后重试!");
            }
        })
    })

    //修改用户模态框
    //点击修改弹出修改用户信息模态框
    var changeId;
    $(document).on("click",".change_btn",function(){
        changeId = $(this).parent().attr("change-id");
        //调用方法
        changeUser(changeId);
        //显示模态框
        $("#changeUser").modal({
            backdrop:"static"
        });
    })
    function changeUser(changeId) {
        $.ajax({
            url:"getUserById",
            type:"POST",
            data:{"id":changeId},
            success:function (result) {
                var user = result.jsondata.user;
                $("#name_change").val(user.name);
                $("#post_change").val(user.post);
                $("#system_change").val(user.system);
            }
        })
    }

    //点击更新
    $(document).on("click","#update_btn",function () {
        var name = $("#name_change").val();
        var sys = $("#system_change").val();
        var post = $("#post_change").val();
        $.ajax({
            url:"changeUser",
            type:"POST",
            data:{"id":changeId,"name":name,"system":sys,"post":post},
            success:function (result) {
                if (result.code === 200){
                    $("#changeUser").modal("hide");
                    to_page(currentPage);
                }else
                    alert("更新失败!");
            }
        })
    })
</script>
</body>
</html>
