<%--
  Created by IntelliJ IDEA.
  User: 666
  Date: 2019/8/8
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>欢迎使用Tomcat</title>
  </head>
  <body>
  <form name="form1" action="testServlet" method="post">
    <%
      String msg=(String)request.getAttribute("msg");
      if (msg != null && !msg.equals("")) {%>
    <font color="red">提示信息：<%=msg%></font><br>
    <%}%>
    用户名：<input type="text"  name="username"></div><br>
    密码：<input type="password" name="pwd"><br>
    <input type="submit" value="登录" >
    <select name="name">
      <option>唱</option>
      <option>跳</option>
      <option>篮球</option>
    </select>
    <select name="name">
      <option>唱</option>
      <option>跳</option>
      <option>篮球</option>
    </select>
  </form>
  <form action="userController" method="post">
    <a href="userController?msg=findUser"><input type="button" value="查询所有用户" ></a>
  </form>
  </body>
</html>
