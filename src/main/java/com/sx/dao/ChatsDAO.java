package com.sx.dao;

import com.sx.bean.Chats;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

public class ChatsDAO extends BaseDao{
    public List<Chats> getAllChatHistory(){
        String sql = "select c.*,u.username from chat c join users u on c.user_id = u.id;";
        List<Chats> list = tpl.query(sql, new BeanPropertyRowMapper<>(Chats.class));
        return list;
    }

    public void addMsg(Chats msg){
        String sql = "insert into chat(content,user_id,createAt) values(?,?,?)";
        tpl.update(sql,msg.getContent(),msg.getUser_id(),msg.getCreateAt());
    }
}
