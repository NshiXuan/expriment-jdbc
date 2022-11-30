package com.sx.dao;

import com.sx.bean.Good;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

public class FavorsDao extends BaseDao {
  public List<Good> list(){
    String sql = "SELECT g.good_name,g.good_price,g.good_img FROM favor JOIN goods g on g.id = favor.good_id";
    return tpl.query(sql, new BeanPropertyRowMapper<>(Good.class));
  }
}
