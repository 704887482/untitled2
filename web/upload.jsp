<%--
  Created by IntelliJ IDEA.
  User: 666
  Date: 2019/8/21
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传实例 - 菜鸟教程</title>
</head>
<body>
<h1>文件上传实例 - 菜鸟教程</h1>
<form method="post" action="/UploadServlet" enctype="multipart/form-data">
    选择一个文件：
    <input type="file" name="uploadFile">
    <br><br>
    <input type="submit" value="上传">
</form>
</body>
</html>
