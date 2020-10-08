package org.it.JDBC;

import java.sql.*;

/**
 *  ResultSet 获取表中数据
 * @Author: Z.HAN
 * @Date: 2020/10/4 13:44
 */
public class JDBCDemo6 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 1 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2 定义sql语句
            String sql = "select * from food";
            // 3 connection对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydb?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "root");
            // 4 statement对象
            stmt = conn.createStatement();
            // 5 执行sql语句
            rs = stmt.executeQuery(sql);
            // 5.1 让游标下移
            rs.next();
            // 5.2 获取数据
            int id = rs.getInt(1);
            String kind = rs.getString(2);
            int price = rs.getInt("foodPrice");
            System.out.println(id + "---" + kind + "---" + price);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
