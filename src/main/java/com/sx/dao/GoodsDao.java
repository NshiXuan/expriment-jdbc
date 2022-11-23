package com.sx.dao;

import com.sx.bean.Good;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

public class GoodsDao extends BaseDao {
  public List<Good> list(){
    String sql = "SELECT * FROM goods";
    return tpl.query(sql, new BeanPropertyRowMapper<>(Good.class));
  }
}
