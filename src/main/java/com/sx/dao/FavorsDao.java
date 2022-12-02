package com.sx.dao;

import com.sx.bean.Favor;
import com.sx.bean.Good;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.servlet.http.Cookie;
import java.util.List;

public class FavorsDao extends BaseDao {
    public List<Good> list(String user_id) {
        String sql = "SELECT g.good_name,g.good_price,g.good_img FROM favor JOIN goods g on g.id = favor.good_id WHERE user_id= ?";
        return tpl.query(sql, new BeanPropertyRowMapper<>(Good.class),user_id);
    }

    public void addGood(Favor favor) {
        String sql = "insert into favor(good_id,user_id) values(?,?);";
        tpl.update(sql, favor.getGoodId(), favor.getUserId());
    }

    public void deleteGood(Favor favor) {
        String sql = "delete from favor where good_id = ? and user_id = ?;";
        tpl.update(sql, favor.getGoodId(), favor.getUserId());
    }

}
