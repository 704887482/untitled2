<%--
  Created by IntelliJ IDEA.
  User: 666
  Date: 2019/8/23
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<script src="static/js/jquery-3.3.1.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
<body>
<label class="glyphicon-text-color">添加用户</label>
<form action="userController?msg=add" method="post">
    <div class="form-group">
        <label>用户名：</label>
        <input type="text" class="form-control" id="user" placeholder="请输入用户名" name="username">
    </div>
    <div class="form-group">
        <label>密码：</label>
        <input type="password" class="form-control" id="pwd" placeholder="请输入密码" name="password">
    </div>
    <button type="submit" class="btn btn-default">添加</button>
    <button type="reset" class="btn btn-default">重置</button>
    <div id="tis"></div>
</form>
</body>
<script>
    $(function () {
    var flag = false;
    var flag2 = false;
    $("#user").blur(function checkUser() {
        var reg = /^[a-zA-Z]\w{3,15}$/;
        if (reg.test($("#user").val())) {
            $("#tis").text("");
            flag = true;
        } else {
            $("#tis").text("只能由英文字母和数字组成，长度为4～16个字符，并且以英文字母开头");
            flag = false;
        }
    });
    $("#pwd").blur(function checkPassword() {
        var reg = /^\w{6,20}$/;
        if (reg.test($("#pwd").val())) {
            $("#tis").text("");
            flag2 = true;
        } else {
            $("#tis").text("大小写字母和数字6-20个字符");
            flag2 = false;
        }
    });
    $("form").submit(function()
    {
        if (flag==true&&flag2==true) {
            return true;
        }else
        {
            return false;
        }
    });
    })
</script>
</html>
