<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.net.*" %>
<%@ page import="java.io.IOException"%>
<%!
    String users;
    String password;
%>
<%
    Cookie[] cookies=request.getCookies();
    if(cookies!=null){
        for(int i=0;i< cookies.length;i++){
            if(cookies[i].getName().equals("CookieName")){
                users=cookies[i].getValue();
                users=URLDecoder.decode(users,"utf-8");
            }else if(cookies[i].getName().equals("CookiePassword")){
                password=cookies[i].getValue();
            }
        }
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/ep/user/login" method="post">
        用户名:<input type="text" name="username"  value="<%=users %>"/><br/>
        密码:<input type="password" name="password"  value="<%=password %>"/><br/>
        <br>
        <input type="submit" value="登录"/>
        <input type="reset" value="重置"/>
        <input type="checkbox" name="remember" />保存密码
    </form>
</body>
</html>
