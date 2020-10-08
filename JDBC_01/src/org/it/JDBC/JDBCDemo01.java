package org.it.JDBC;


import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC快速入门
 * @Author: Z.HAN
 * @Date: 2020/10/4 10:26
 */
public class JDBCDemo01 {
    public static void main(String[] args) throws Exception {
        // 1.导入驱动jar包
        // 2.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 3.获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydb?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "root");
        // 4.定义sql语句
        String sql = "update food set foodKind = 'miantiao' where foodId = 1";
        // 5.获取执行sql的对象，Statement
        Statement stmt = conn.createStatement();
        // 6.执行sql，返回值count是影响的行数。
        int count = stmt.executeUpdate(sql);
        // 7.处理结果
        System.out.println(count);
        // 8.释放资源
        conn.close();
        stmt.close();
    }
}
