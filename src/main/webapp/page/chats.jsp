<%--
  Created by IntelliJ IDEA.
  User: 农世轩
  Date: 2022/11/23
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setAttribute("ctx",request.getContextPath()); %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    .nav-bar{
        padding: 20px;
        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    .nav-bar a{
        text-decoration: none;
        margin-right: 10px;
    }
</style>

<body>
<div class="nav-bar">
    <div>
        <a href="${ctx}/goods/list">商品</a>
        <a href="${ctx}/favors/list">购物车</a>
        <a href="${ctx}/chats/list">聊天记录</a>
    </div>
    <div>
        <a href="${ctx}/user/logout">退出登录</a>
    </div>
</div>

</body>
</html>
