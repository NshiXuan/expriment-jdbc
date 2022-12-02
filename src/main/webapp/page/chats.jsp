<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: 农世轩
  Date: 2022/11/23
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setAttribute("ctx", request.getContextPath()); %>

<%!
    String user_id;
%>

<%
    Cookie[] cookies=request.getCookies();
    if(cookies!=null){
        System.out.println(cookies);
        for(int i=0;i< cookies.length;i++){
            if(cookies[i].getName().equals("CookieId")){
                user_id=cookies[i].getValue();
                System.out.println(user_id+"id");
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

    .content {
        height: 70vh;
        border-radius: 5px;
        padding: 20px;
        overflow: hidden;
        opacity: 1;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
        border-radius: 5px;
    }

    .content:hover {
        overflow-y: auto;
    }

    .content::-webkit-scrollbar {
        width: 10px;
        height: 1px;
    }

    .content::-webkit-scrollbar-thumb {
        border-radius: 10px;
        background: #E5E5E5;
    }

    .content::-webkit-scrollbar-track {
        border-radius: 10px;
        background: #fff;
    }

    .content-item {
        margin-top: 10px;
    }

    .content-item .content-username {
        display: flex;
        font-size: 12px;
        color: #666;
    }

    .content-item .content-username .name {
        margin-right: 10px;
    }

    .content-item .info {
        margin-top: 5px;
        margin-left: 10px;
        padding: 10px;
        width: fit-content;
        background-color: #1D82FE;
        color: #fff;
        border-radius: 10px;
    }

    .input {
        margin-top: 20px;
        border-radius: 5px;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
    }

    .input input {
        margin: 10px;
        padding: 10px;
        border: 2px solid #efefef;
        outline-color: #1D82FE;
        border-radius: 5px;
        width: 50%;
    }

    .btn {
        padding: 10px 20px;
        background-color: #1D82FE;
        border-radius: 5px;
        border: none;
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

<div class="content">
    <c:forEach items="${chats}" var="chat">
        <div class="content-item">
            <div class="content-username">
                <div class="name">${chat.username}</div>
                <div class="time">${chat.createAt}</div>
            </div>
            <div class="info">${chat.content}</div>
        </div>
    </c:forEach>
</div>

<div class="input">
    <form action="/ep/chats/sendMsg">
        <input type="hidden" placeholder="id" name="user_id" value="<%=user_id %>"/>
        <input type="text" name="content"/>
        <button class="btn">发送</button>
    </form>
</div>
</body>
</html>
