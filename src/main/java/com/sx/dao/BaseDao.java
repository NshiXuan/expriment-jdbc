package com.sx.dao;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class BaseDao {
  protected static JdbcTemplate tpl;

  static {
    try (InputStream is = UserDao.class.getClassLoader().getResourceAsStream("druid.properties")) {
      // 读取连接池配置文件
      Properties properties = new Properties();
      properties.load(is);
      // 创建连接池
      DataSource ds = DruidDataSourceFactory.createDataSource(properties);
      // 创建tpl
      tpl = new JdbcTemplate(ds);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}