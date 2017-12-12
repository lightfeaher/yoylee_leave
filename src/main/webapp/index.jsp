<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
<script type="text/javascript">
    $(function(){
        //alert("testjs");
        //测试js调用  使用restful
        $("#putid").click(function(){
            $.ajax(
                {
                    url:"abc",
                    type:"put",
                    success:function(data){
                        alert(data)
                    }
                }
            )
        });
        $("#getid").click(function(){
            $.ajax(
                {
                    url:"abc",
                    type:"get",
                    success:function(data){
                        alert(data)
                    }
                }
            )
        })
    })
</script>
<form action="abc" method="post">
    <label for="aa"> 点击我!!!!: <input type="text" name="name" placeholder="srg"></label>
    <input type="submit">
</form>

<form action="abc" method="post">
    <input type="hidden" name="_method" value="delete">
    <label for="aa"> 点击我!!!!:<input type="text" name="name" id="aa"></label>
    <input type="submit">
</form>

<form action="abc" method="post">
    <input type="hidden" name="_method" value="put">
    <input type="text" name="name" >
    <input type="submit">
</form>

<button name="调用put" id="putid"></button><br>
<button name="调用delete" id="deleteid"></button><br>
<button name="调用get" id="getid"></button>

</body>
</html>