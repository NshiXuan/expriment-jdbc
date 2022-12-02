package com.sx.dao;

import com.sx.bean.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.ArrayList;
import java.util.List;

public class UserDao extends BaseDao {
  /**
   * 获取多个对象
   */
  public User login(User user) {
    List<Object> args = new ArrayList<>();
    String username = user.getUsername();
    String password = user.getPassword();

    // if (username == null || password == null) return;
    args.add(username);
    args.add(password);
    String sql = "SELECT username,password FROM users WHERE username = ? AND password=?";
    System.out.println("query" + tpl.query(sql, new BeanPropertyRowMapper<>(User.class), args.toArray()));
    // User use1 = tpl.query(sql, new BeanPropertyRowMapper<>(User.class), args.toArray());
    System.out.println();


    // System.out.println(username + " - " + password);
    // String sql = "SELECT username,password FROM users";
    // return tpl.query(sql, new BeanPropertyRowMapper<>(User.class));
    // return (User) tpl.query(sql, new BeanPropertyRowMapper<>(User.class), args.toArray());
    return user;
  }

  public List<User> list() {
    String sql = "SELECT username,password FROM users";
    return tpl.query(sql, new BeanPropertyRowMapper<>(User.class));
  }
}
