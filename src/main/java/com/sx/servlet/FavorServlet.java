package com.sx.servlet;

import com.sx.bean.Favor;
import com.sx.bean.Good;
import com.sx.dao.FavorsDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/favors/*")
public class FavorServlet extends BaseServlet {
    private FavorsDao dao = new FavorsDao();
    private String user_id;


    public void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Cookie[] cookies=request.getCookies();
        if(cookies!=null){
            for(int i=0;i< cookies.length;i++){
                if(cookies[i].getName().equals("CookieId")){
                    user_id=cookies[i].getValue();
                }
            }
        }

        List<Good> goods = dao.list(user_id);
        request.setAttribute("favors", goods);
        request.getRequestDispatcher("/page/favors.jsp").forward(request, response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Favor favor = new Favor();
        favor.setGoodId(request.getParameter("good_id"));
        favor.setUserId(request.getParameter("user_id"));

        dao.addGood(favor);
        request.getRequestDispatcher("/page/favors.jsp").forward(request, response);
    }
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Favor favor = new Favor();
        favor.setGoodId(request.getParameter("good_id"));
        favor.setUserId(request.getParameter("user_id"));

        dao.deleteGood(favor);
        request.getRequestDispatcher("/page/favors.jsp").forward(request, response);
    }
}
