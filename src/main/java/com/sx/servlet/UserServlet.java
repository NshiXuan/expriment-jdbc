package com.sx.servlet;

import com.sx.bean.User;
import com.sx.dao.UserDao;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
  private final UserDao dao = new UserDao();

  public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
    User user = new User();
    BeanUtils.populate(user, request.getParameterMap());
    System.out.println("user"+ dao.login(user));

    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String remember = request.getParameter("remember");


    PrintWriter out = response.getWriter();
    String []name= new String [] {"农世轩","谢士钰","施贵洋"};
    String []stuID=new String [] {"202021091223","202021093016","202021091221"};

    //若用户名和密码正确，则进行后面操作
    if(username.equals(name[0])&&password.equals(stuID[0])||username.equals(name[1])&&password.equals(stuID[1])||username.equals(name[2])&&password.equals(stuID[2])||username.equals("123")){
      //若勾选记住密码
      System.out.println("登录成功");
      //获取会话对象
      HttpSession session=request.getSession(true);
      session.setAttribute("username", username);
      System.out.println("session-name: "+session.getAttribute("username"));
      int toSave=0;
      if(remember!=null){
        out.println("记住密码");
        toSave = 1;
        //判断是否已有用户名或学号的cookie，若有则将toSave设为0
        Cookie[] cookies = request.getCookies();  //获取浏览器里的cookie
        if(cookies!=null){
          for(int i=0;i<cookies.length;i++){
            System.out.println("cookie-name-servlet"+cookies[i].getName());
            System.out.println("cookie-length-servlet"+cookies.length);
            Cookie cookie = cookies[i];
            if(cookie.getValue().equals(password)){
              out.println("已有cookie");
              toSave = 0;
            }
          }
        }
        //若没有用户名和学号的cookie，则创建Cookie
        if(toSave==1){
          out.println("创建cookie");
          Cookie CookieName = new Cookie("CookieName", URLEncoder.encode(username,"UTF-8"));//对cookie里存的汉字进行编码
          Cookie CookiePassword = new Cookie("CookiePassword",password);
          CookieName.setMaxAge(60*60*24*30);
          CookiePassword.setMaxAge(60*60*24*30);
          CookieName.setPath("/");
          CookiePassword.setPath("/");
          response.addCookie(CookieName);//回写cookie到浏览器
          response.addCookie(CookiePassword);
        }
      }

      response.sendRedirect(request.getContextPath() + "/goods/list");
      // super.doPost(request, response);
    }else{
      response.sendRedirect("/ep/page/LoginFail.jsp");
    }
  }
}
