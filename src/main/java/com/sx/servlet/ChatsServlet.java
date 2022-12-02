package com.sx.servlet;

import com.sx.bean.Chats;
import com.sx.bean.User;
import com.sx.dao.ChatsDAO;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static java.lang.Integer.parseInt;

@WebServlet("/chats/*")
public class ChatsServlet extends BaseServlet {
    private ChatsDAO dao = new ChatsDAO();

    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Chats> chatList = dao.getAllChatHistory();
//        System.out.println(chatList);
        req.setAttribute("chats",chatList);
        req.getRequestDispatcher("/page/chats.jsp").forward(req,resp);
    }

    public void sendMsg(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
        Chats chat = new Chats();
        try {
            BeanUtils.populate(chat, req.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        dao.addMsg(chat);
        resp.sendRedirect("/ep/chats/list");
    }
}
