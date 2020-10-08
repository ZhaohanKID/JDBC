package org.it.util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/4 14:40
 */
public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    // 文件的读取，只需要读取一次就可以拿到这些值，使用静态代码块
    static {

        try {
            // 创建Properties集合类
            Properties prop = new Properties();
            // 动态获取src下的文件路径

            // 乱码！！！有中文名字，用utf-8解码了
            /*ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL res = classLoader.getResource("jdbc");
            String path = res.getPath();
            System.out.println(path);
            // 加载文件
            prop.load(new FileReader(path));*/
            prop.load(new FileReader("D:\\IntelliJ_IDEA_Project\\JDBC\\JDBC_01\\src\\jdbc"));

            // 获取属性
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
            driver = prop.getProperty("driver");
            // 注册驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 注册驱动
    // 建立连接

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // 方法重载
    public static void close(Statement stmt, Connection conn) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
