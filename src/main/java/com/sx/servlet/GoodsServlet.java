package com.sx.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/goods/*")
public class GoodsServlet extends BaseServlet{

  public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception{
    request.getRequestDispatcher("/page/goods.jsp").forward(request,response);
  }
}
