package com.sx.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      // 设置编码
      request.setCharacterEncoding("UTF-8");

      // 利用方法调用方法
      String uri = request.getRequestURI();
      String[] cmps = uri.split("/");
      String methodName = cmps[cmps.length - 1];
      Method method = getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
      method.invoke(this, request, response);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}