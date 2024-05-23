<%--
  Created by IntelliJ IDEA.
  User: 韩顺平
  Version: 1.0
  Filename: rest
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>rest </title>
    <%--引入jquery--%>
    <script type="text/javascript" src="webjars/jquery/3.5.1/dist/jquery.min.js"></script>

    <script type="text/javascript">
        $(function () { //当页面加载完成后，就执行
            //给删除超链接绑定一个点击事件
            $("#deleteBook").click(function (){
                // alert("点击。。。。");
                //将超链接的href的值 赋值给 表单的action
                $("#hiddenForm").attr("action", this.href);
                $(":hidden").val("DELETE");//给隐藏域的 _method 赋值 DELETE
                $("#hiddenForm").submit();
                return false; //改变点击超链接的行为, 不在提交
            })
        })
    </script>
</head>
<body>

<h3>Rest风格的crud操作案例</h3>
<br><hr>

<h3>rest风格的url 查询书籍[get]</h3>
<a href="user/book/200">点击查询书籍</a>
<br><hr>

<h3>rest风格的url 添加书籍[post]</h3>
<form action="user/book" method="post">
    name:<input name="bookName" type="text"><br>
    <input type="submit" value="添加书籍">
</form>
<br><hr>

<h3>rest风格的url, 删除一本书</h3>
<%--
1. 默认情况下 <a href="user/book/600">删除指定id的书</a> 是get
2. 怎么样将 get 请求转成 springmvc 可以识别的 delete 就要考虑HiddenHttpMethodFilter机制
   public static final String DEFAULT_METHOD_PARAM = "_method";
   ---------------------------------------------------
   private static final List<String> ALLOWED_METHODS =
			Collections.unmodifiableList(Arrays.asList(HttpMethod.PUT.name(),
					HttpMethod.DELETE.name(), HttpMethod.PATCH.name()));
  ---------------------------------------------------
   if ("POST".equals(request.getMethod()) && request.getAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE) == null) {
			String paramValue = request.getParameter(this.methodParam);
			if (StringUtils.hasLength(paramValue)) {
				String method = paramValue.toUpperCase(Locale.ENGLISH);
				if (ALLOWED_METHODS.contains(method)) {
					requestToUse = new HttpMethodRequestWrapper(request, method);
				}
			}
		}
3. 上面代码可以看到 HiddenHttpMethodFilter 过滤器可以对以Post方式提交的delete,put,patch进行转换,成springmvc
   识别的 RequestMethod.DELETE / RequestMethod.PUT /...
4. 我们需要将 get <a href="user/book/600">删除指定id的书</a> 以post方式提交给后端handler, 这样过滤器才会生效
5. 我们可以用jquery来处理-引入jquery
--%>
<a href="user/book/600" id="deleteBook">删除指定id的书</a>
<form action="" method="post" id="hiddenForm">
    <input type="hidden" name="_method"/>
</form>
<br><hr>

<h3>rest风格的url 修改书籍[put]~</h3>
<form action="user/book/666" method="post">
    <%--TODO 这里的"_method"不能修改，后端的转发器是按照"_method"来获取其value（请求方法）的--%>
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="修改书籍~">
</form>

</body>
</html>