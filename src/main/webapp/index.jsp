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
<style>
    body{
        margin: 0;
        text-align: center;
        background-image: linear-gradient(to top, #fbc2eb 0%, #a6c1ee 100%);
    }
    input{
        border: 0;
        background: #f1ecec;
        border-radius: 20px;
        line-height: 40px;
        padding: 0 20px;
        font-size: 16px;
        width: 250px;
        margin-top:20px ;
    }
    input:focus{
        outline: 0;
    }
    button{
        margin-top: 30px;
        background: #6495ed;
        border: 0;
        border-radius: 20px;
        line-height: 40px;
        color: white;
        width: 200px;
        font-size: 15px;
        box-shadow: 0px 2px 10px blue;
    }
    button:hover{
        outline: 0;
        background: #64a2ed;
    }
    .box{
        display: flex;
        justify-content: center;
        flex:1;
    }
    .box1{
        width: 250px;
        text-align: left;
    }
    .check{
        width: 20px;
    }
    .box0{
        background: white;
        height: 240px;
        width: 300px;
        margin: 30px auto;
        border-radius: 20px;
    }

</style>
<body>
    <h1>登录系统</h1>
    <hr>
   <div class="box0">
       <form action="/ep/user/login" method="post">
           <div>
               <label>
                   <input type="text" placeholder="用户名" name="username"  value="<%=users %>"/>
               </label>
           </div>
           <div>
               <label>
                   <input type="password" placeholder="密码" name="password"  value="<%=password %>"/><br/>
               </label>
           </div>
           <div class="box">
               <div class="box1">
                   <label>
                       <input class="check" type="checkbox" name="remember"/> 保存密码
                   </label>
               </div>
           </div>
           <div>
               <button>登录</button>
           </div>
       </form>
   </div>
</body>
</html>
