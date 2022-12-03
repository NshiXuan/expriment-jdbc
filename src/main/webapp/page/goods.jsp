<%--
  Created by IntelliJ IDEA.
  User: 农世轩
  Date: 2022/11/23
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setAttribute("ctx", request.getContextPath()); %>

<%!
    String user_id;
    String good_id;
%>

<%
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        System.out.println(cookies);
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("CookieId")) {
                user_id = cookies[i].getValue();
                System.out.println(user_id + "id");
            }
        }
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<style>
    body {
        width: 1200px;
        margin: 0 auto;
    }

    .nav-bar {
        padding: 20px;
        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    .nav-bar a {
        text-decoration: none;
        margin-right: 10px;
    }

    .good {
        display: flex;
        flex-wrap: wrap;
        gap: 20px;
    }

    .good-item {
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
        border-radius: 5px;
        display: flex;
        flex-direction: column;
        gap: 10px;
        padding: 10px;
    }

    .good-item .img img {
        width: 150px;
        height: 150px;
    }

    form{
        display: flex;
        justify-content: center;
        margin: 0;
    }

    .btn {
        background: blue;
        width: 100%;
        padding: 10px;
        border: none;
        border-radius: 5px;
        color: #fff;
    }

    .btn:hover {
        cursor: pointer;
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

<div class="good">
    <c:forEach items="${goods}" var="good">
        <div class="good-item">
            <div class="img">
                <img src="${good.goodImg}"/>
            </div>
            <div class="price">￥${good.goodPrice}</div>
            <div class="name"> ${good.goodName}</div>
            <form action="/ep/favors/add">
                <input type="hidden" placeholder="id" name="good_id" value="${good.id}"/>
                <input type="hidden" placeholder="id" name="user_id" value="<%=user_id %>"/>
                <button class="btn">加入购物车</button>
            </form>
        </div>
    </c:forEach>
</div>

</body>
</html>
