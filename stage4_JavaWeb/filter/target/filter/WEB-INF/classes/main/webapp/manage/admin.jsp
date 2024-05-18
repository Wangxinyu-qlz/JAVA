<%--
  Created by IntelliJ IDEA.
  ajax.entity.User: Qiaolezi
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理</title>
    <base href="<%=request.getContextPath() %>/manage/"/>
</head>
<body>
<h1>后台管理</h1>
<%
    //验证request对象是和前面的filter是一个对象
    System.out.println("admin.jsp:  request=" + request);
%>
<a href="#">用户列表</a>||<a href="#">添加用户</a>||<a href="#">删除用户</a>
<hr/>
<%--浏览器请求图片时，会经过过滤器，后台会输出：ManageFilter ~~~~~~~~doFilter()方法被调用
如果后台没输出=》说明没经过过滤器=》说明浏览器用了缓存的数据--%>
<img src="盛开的杏花-梵高.jpg" height="300"/>
</body>
</html>
