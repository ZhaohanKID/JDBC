package org.it.DataSource.C3P0;

import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/5 10:33
 */
public class C3P0Demo1 {
    public static void main(String[] args) throws SQLException {
        // 1 创建数据库连接池对象
        DataSource ds = new ComboPooledDataSource();
        // 2 获取连接对象
        Connection conn = ds.getConnection(); // com.mchange.v2.c3p0.impl.NewProxyConnection@3cc2931c [wrapping: com.mysql.cj.jdbc.ConnectionImpl@20d28811]

        System.out.println(conn);
    }
}
