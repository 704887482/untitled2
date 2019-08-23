<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>文件下载页面列表</title>
</head>
<body>
<h3>超链接的下载</h3>
<a href="download/file.txt">文本文件</a><br>
<a href="download/file.jpg">图片文件</a><br>
<a href="download/file.zip">压缩文件</a><br>
<a href="download/美女.jpg">美女</a>
<h3>手动编码的下载方式</h3>
<a href="demo?filename=file.txt">文件文件</a>
<a href="demo?filename=file.jpg">图片文件</a>
<a href="demo?filename=file.zip">压缩文件</a>
<a href="demo?filename=美女.jpg">美女</a>
<hr>
<form action="/demo" method="post" enctype="multipart/form-data">
    File:<input type="file" name="bb">
    <input type="submit" name="Submit">
</form>
</body>
</html>