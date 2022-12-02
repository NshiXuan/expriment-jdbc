package com.sx.servlet;

import com.sx.bean.Chats;
import com.sx.dao.ChatsDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/chats/*")
public class ChatsServlet extends BaseServlet {
    private ChatsDAO dao = new ChatsDAO();

    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Chats> chatList = dao.getAllChatHistory();
//        System.out.println(chatList);
        req.setAttribute("chats",chatList);
        req.getRequestDispatcher("/page/chats.jsp").forward(req,resp);
    }

    public void sendMsg(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        Chats msg = new Chats();
        msg.setContent(req.getParameter("content"));
        msg.setUser_id(Integer.parseInt(req.getParameter("user_id")));
        dao.addMsg(msg);
        resp.sendRedirect("/page/chats.jsp");
    }
}
