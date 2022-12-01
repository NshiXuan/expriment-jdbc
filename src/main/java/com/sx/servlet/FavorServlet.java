package com.sx.servlet;

import com.sx.bean.Good;
import com.sx.dao.FavorsDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/favors/*")
public class FavorServlet extends BaseServlet {
  private FavorsDao dao=new FavorsDao();

  public void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
    List<Good> goods = dao.list();
    request.setAttribute("favors", goods);
    request.getRequestDispatcher("/page/favors.jsp").forward(request, response);
  }
}
