package org.it.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *  Druid 连接池的工具类
 * @Author: Z.HAN
 * @Date: 2020/10/5 11:16
 */
public class JDBCUtils {
    // 1 定义成员变量 DataSource
    private static DataSource ds;
    // 2 定义静态代码块
    static {
        try {
            // 1 加载配置文件
            Properties prop = new Properties();
            prop.load(new FileReader("D:\\IntelliJ IDEA程序\\JDBC\\JDBC_02\\src\\druid.properties"));
            // 2 获取 DataSource 连接池
            ds = DruidDataSourceFactory.createDataSource(prop);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 获取连接
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    // 释放资源
    public static void close(Statement stmt, Connection conn) {
        /*if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();// 将连接对象归还到池子里面
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
        close(null, stmt, conn);
    }

    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();// 将连接对象归还到池子里面
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 获取连接池的方法
    public static DataSource getDataSource() {
        return ds;
    }
}
