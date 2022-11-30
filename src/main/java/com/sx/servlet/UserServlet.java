package com.sx.servlet;

import com.sx.bean.User;
import com.sx.dao.UserDao;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
  private final UserDao dao = new UserDao();

  public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
    User user = new User();
    BeanUtils.populate(user, request.getParameterMap());
    System.out.println(dao.login(user));
    response.sendRedirect(request.getContextPath() + "/goods/list");
    // request.getRequestDispatcher("/page/goods.jsp").forward(request, response);
  }
}
