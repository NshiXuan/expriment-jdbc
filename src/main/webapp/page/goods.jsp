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
<body>
    <c:forEach items="${goods}" var="good">
        <div>${good.goodName}</div>
        <div>${good.goodPrice}</div>
        <div>
            <img src="${good.goodImg}"/>
        </div>
    </c:forEach>
</body>
</html>
