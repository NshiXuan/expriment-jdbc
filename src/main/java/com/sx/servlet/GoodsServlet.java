package com.sx.servlet;

import com.sx.bean.Good;
import com.sx.dao.GoodsDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/goods/*")
public class GoodsServlet extends BaseServlet {
  private GoodsDao dao = new GoodsDao();

  public void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
    List<Good> goods = dao.list();
    System.out.println(goods);
    request.setAttribute("goods", goods);
    request.getRequestDispatcher("/page/goods.jsp").forward(request, response);
  }
}
