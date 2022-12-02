package com.sx.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({"/goods/*", "/favors/*"})
public class TestFilter implements Filter {
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
    HttpServletRequest request0 = (HttpServletRequest) request;
    HttpServletResponse response0 = (HttpServletResponse) response;
    HttpSession session = request0.getSession(true);
    request.setCharacterEncoding("Utf-8");
    response.setCharacterEncoding("Utf-8");
    response.setContentType("text/html;charset=Utf-8");
    if (session.getAttribute("username") == null) {
      System.out.println("过滤器拦截");
      response0.sendRedirect("/ep/page/LoginFail.jsp");
    }
    // else if (session.getAttribute("username").equals("农世轩")) {
    else{
      System.out.println("过滤器通过");
      chain.doFilter(request, response);
    }
  }
}
