<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024/4/24
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h3>登录页面</h3>
<%--TODO action="login"表示的是 http://localhost:8080/springmvc/login
         不加 / 地址会自动解析成 http://localhost:8080/springmvc/
        action="/login"表示的是 http://localhost:8080/login
        加 / 地址会解析成 http://localhost:8080/--%>
<form action="login">
    用户名:<input name="username" type="text"> <br>
    密码:<input name="password" type="password"> <br>
    <input type="submit" value="登录">
</form>

</body>
</html>
