<%--
  Created by IntelliJ IDEA.
  User: 农世轩
  Date: 2022/11/23
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    body{
        width: 1200px;
        margin: 0 auto;
    }

    .good{
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

    }

    .btn:hover{
        cursor: pointer;
    }
</style>

<body>

<div class="good">
    <c:forEach items="${goods}" var="good">
        <div class="good-item">
            <div class="img">
                <img src="${good.goodImg}"/>
            </div>
            <div class="price">￥${good.goodPrice}</div>
            <div class="name"> ${good.goodName}</div>
            <button class="btn">加入购物车</button>
        </div>
    </c:forEach>
</div>

</body>
</html>
