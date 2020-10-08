package org.it.JDBC;

import org.it.util.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/5 8:55
 */
public class JDBCDemo9 {
    public static void main(String[] args) {
        /*
            1 键盘录入 接收用户名和密码
            2 调用方法
            3 输出结果
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = sc.nextLine();
        System.out.println("请输入密码：");
        String pwd = sc.nextLine();

        boolean flag = new JDBCDemo9().login(name, pwd);
        if (flag) {
            System.out.println("登陆成功！");
        } else {
            System.out.println("用户名或密码错误！");
        }
    }

    // 登录的方法
    public boolean login(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from user where name = '"+username+"' and password = '"+password+"'";
            rs = stmt.executeQuery(sql);
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, stmt, conn);
        }
        return false;
    }
    // 使用预编译的方法登录方法
    public boolean login2(String name, String pwd) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        if (name == null || pwd == null) {
            return false;
        }
        // 连接
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from user where name = ? and password = ?";
            // 获取sql对象
            pstmt = conn.prepareStatement(sql);
            // 给?赋值
            pstmt.setString(1, name);
            pstmt.setString(2, pwd);
            rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return false;
    }
}
