package org.it.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *  1 添加一条记录
 * @Author: Z.HAN
 * @Date: 2020/10/4 12:29
 */
public class JDBCDemo2 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // 1 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2 定义sql语句
            String sql = "insert into food values(4,'mantou','2')";
            // 3 获取Connection对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydb?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "root");
            // 4 获取Statement对象
            stmt = conn.createStatement();
            // 5 执行sql语句
            int count = stmt.executeUpdate(sql);
            // 6 处理结果
            System.out.println(count);
            if (count > 0) {
                System.out.println("操作成功！");
            } else {
                System.out.println("操作失败！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 7 释放资源
            // 对于stmt，如果获取connection对象那一行出错了，就不会执行到stmt，就是赋值时候的null，会空指针异常，所以
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
