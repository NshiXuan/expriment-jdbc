package com.sx.dao;

import com.sx.bean.User;
import org.springframework.beans.BeanUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.rmi.CORBA.Util;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends BaseDao {
  /**
   * 获取用户对象
   */
  public User login(User user) {
    List<Object> args = new ArrayList<>();
    String username = user.getUsername();
    String password = user.getPassword();

    if (username == null || password == null) return null;

    args.add(username);
    args.add(password);
    String sql = "SELECT id,username,password FROM users WHERE username = ? AND password=?";
    List<User> queryUsers = tpl.query(sql, new BeanPropertyRowMapper<>(User.class), args.toArray());

    for (User queryUser : queryUsers) {
      if(queryUser.getUsername().equals(username) && queryUser.getPassword().equals(password)){
        return queryUser;
      }
    }

    return null;
  }

  public List<User> list() {
    String sql = "SELECT username,password FROM users";
    return tpl.query(sql, new BeanPropertyRowMapper<>(User.class));
  }
}
