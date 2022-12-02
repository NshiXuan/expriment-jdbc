package com.sx.servlet;

import com.sx.bean.User;
import com.sx.dao.UserDao;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
  private final UserDao dao = new UserDao();

  public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
    User user = new User();
    BeanUtils.populate(user, request.getParameterMap());
    System.out.println("user" + dao.login(user));

    User queryUser = dao.login(user);

    String remember = request.getParameter("remember");

    //若用户名和密码正确，则进行后面操作
    if (queryUser != null) {
      //若勾选记住密码
      System.out.println("登录成功");
      Cookie CookieId = new Cookie("CookieId", queryUser.getId() + "");
      CookieId.setMaxAge(60 * 60 * 24 * 7);
      CookieId.setPath("/");
      response.addCookie(CookieId);

      System.out.println(queryUser.getId()+"id");
      //获取会话对象
      HttpSession session = request.getSession(true);
      session.setAttribute("username", queryUser.getUsername());
      System.out.println("session-name: " + session.getAttribute("username"));
      int toSave = 0;
      if (remember != null) {
        System.out.println("记住密码");
        toSave = 1;
        //判断是否已有用户名或学号的cookie，若有则将toSave设为0
        Cookie[] cookies = request.getCookies();  //获取浏览器里的cookie
        if (cookies != null) {
          for (int i = 0; i < cookies.length; i++) {
            System.out.println("cookie-name-servlet" + cookies[i].getName());
            System.out.println("cookie-length-servlet" + cookies.length);
            Cookie cookie = cookies[i];
            if (cookie.getValue().equals(queryUser.getPassword())) {
              System.out.println("已有cookie");
              toSave = 0;
            }
          }
        }
        //若没有用户名和学号的cookie，则创建Cookie
        if (toSave == 1) {
          System.out.println("创建cookie");
          Cookie CookieName = new Cookie("CookieName", URLEncoder.encode(queryUser.getUsername(), "UTF-8"));//对cookie里存的汉字进行编码
          Cookie CookiePassword = new Cookie("CookiePassword", queryUser.getPassword());

          CookieName.setMaxAge(60 * 60 * 24 * 7);
          CookiePassword.setMaxAge(60 * 60 * 24 * 7);
          CookieName.setPath("/");
          CookiePassword.setPath("/");
          response.addCookie(CookieName);//回写cookie到浏览器
          response.addCookie(CookiePassword);
        }
      }

      response.sendRedirect(request.getContextPath() + "/goods/list");
      // super.doPost(request, response);
    } else {
      System.out.println("用户名或者密码错误");
      response.sendRedirect("/ep/page/LoginFail.jsp");
    }
  }
}
