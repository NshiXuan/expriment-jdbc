<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setAttribute("ctx",request.getContextPath()); %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/ep/user/login">
        <div>
            用户名：
            <input name="username"/>
        </div>
        <div>
            密码：
            <input name="password"/>
        </div>
        <button type="submit">登录</button>
    </form>
</body>
</html>
