<%--
  Created by IntelliJ IDEA.
  User: 农世轩
  Date: 2022/11/23
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setAttribute("ctx",request.getContextPath()); %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    body{
        width: 1200px;
        margin: 0 auto;
    }

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

    .favor{
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

    .good-item  .img img {
        width: 150px;
        height: 150px;
    }

    .btn{
        background: red;
        padding: 10px 0;
        border: none;
        border-radius: 5px;
        color: #fff;
    }

    .btn:hover{
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

<div class="favor">
    <c:forEach items="${favors}" var="favor">
        <div class="good-item">
            <div class="img">
                <img src="${favor.goodImg}"/>
            </div>
            <div class="price">￥${favor.goodPrice}</div>
            <div class="name"> ${favor.goodName}</div>
            <button class="btn">删除</button>
        </div>
    </c:forEach>
</div>
</body>
</html>
