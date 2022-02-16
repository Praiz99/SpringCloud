package com.zeng.store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class StoreApplicationTests {
    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() {
    }
   /*
   * HikariProxyConnection@782116 wrapping com.mysql.cj.jdbc.ConnectionImpl@68a7b6 數據库连接池
   * */
    @Test
    void dataSourcetest() throws SQLException {
        System.out.println(dataSource.getConnection());
    }
}
