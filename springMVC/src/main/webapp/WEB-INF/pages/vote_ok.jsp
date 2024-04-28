<%--
  Created by IntelliJ IDEA.
  User: 韩顺平
  Version: 1.0
  Filename: vote05
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" isELIgnored="false" %>
<%--TODO isELIgnored="false" jsp不能解析EL表达式的话 加上这句话--%>
<html>
<head>
    <title>vote_ok </title>
</head>
<body>
<h1>获取的的数据显示页面</h1>
<hr>
取出 request域的数据-通过前面讲解的el表达式来获取即可
<br>
address: ${requestScope.address}<br>
主人名字= ${requestScope.master.name}
主人id= ${requestScope.master.id}
宠物名字= ${requestScope.master.pet.name}
宠物id= ${requestScope.master.pet.id}

<hr>
取出 session域的数据 <br>
address: ${sessionScope.address}<br>
主人名字= ${sessionScope.master.name}
主人信息= ${sessionScope.master}
</body>
</html>