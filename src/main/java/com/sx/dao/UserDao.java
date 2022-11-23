package com.sx.dao;

import com.sx.bean.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

public class UserDao extends BaseDao {
  /**
   * 获取多个对象
   */
  public boolean login(User user) {
    String username = user.getUsername();
    String password = user.getPassword();

    if (username == null || password == null) return false;

    System.out.println(username + " - " + password);
    // String sql = "SELECT username,password FROM users";
    // return tpl.query(sql, new BeanPropertyRowMapper<>(User.class));
    return true;
  }

  public List<User> list() {
    String sql = "SELECT username,password FROM users";
    return tpl.query(sql, new BeanPropertyRowMapper<>(User.class));
  }
}
