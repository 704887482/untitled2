<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: 666
  Date: 2019/8/22
  Time: 18:08
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
<ul class="nav nav-pills container">
    <li role="presentation" class="active"><a href="#">Home</a></li>
    <li role="presentation"><a href="#">Profile</a></li>
    <li role="presentation"><a href="#">Messages</a></li>
    <li role="presentation"><a href="#">Profile</a></li>
    <li role="presentation"><a href="#">Messages</a></li>
    <li role="presentation"><a href="#">Profile</a></li>
    <li role="presentation"><a href="#">Messages</a></li>
    <li role="presentation"><a href="#">Profile</a></li>
    <li role="presentation"><a href="#">Messages</a></li>
</ul>
<form action="userController" method="post" class="form-inline container">
    <div class="form-group">
        <label for="exampleInputName2">用户名</label>
        <input type="text" class="form-control" id="exampleInputName2">
    </div>
    <div class="form-group">
        <label for="exampleInputEmail2">密码</label>
        <input type="text" class="form-control" id="exampleInputEmail2">
    </div>
    <button type="submit" class="btn btn-default">查询</button>
    <a href="addUser.jsp"><input type="button" value="添加用户" class="btn-primary"></a>
    <table class="table table-striped">
        <tr>
            <td><input type="checkbox"></td>
            <td>id</td>
            <td>用户名</td>
            <td>密码</td>
            <td>编辑</td>
        </tr>
        <c:forEach items="${user}" var="user">
            <tr>
                <td><input type="checkbox"></td>
                <td>${user.id}</td>
                <td>${user.userName}</td>
                <td>${user.password}</td>
                <td>
                    <a><input type="button" value="修改" class="btn btn-success"></a>
                    <a><input type="button" value="删除" class="btn btn-danger"></a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li class="disabled">
                <a href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li class="active"><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li>
                <a href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
    <image id="verifycode" src="code" onclick="this.src=this.src+'?'+Math.random()"></image>
</form>
</body>
</html>
