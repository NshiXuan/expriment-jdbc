package com.sx.dao;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

public class BaseDao {
  protected static JdbcTemplate tpl;

  static {
    // DruidPooledConnection cn = null;

    try (InputStream is = UserDao.class.getClassLoader().getResourceAsStream("druid.properties")) {
      // 读取连接池配置文件
      Properties properties = new Properties();
      properties.load(is);
      // 创建连接池
      DataSource ds = DruidDataSourceFactory.createDataSource(properties);
      // 创建tpl
      // cn = ds.getConnection().unwrap(DruidPooledConnection.class);

      tpl = new JdbcTemplate(ds);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // try {
      //   assert cn != null;
      //   cn.close();
      // } catch (SQLException throwables) {
      //   throwables.printStackTrace();
      // }
    }
  }
}