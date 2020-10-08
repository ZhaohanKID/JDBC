package org.it.JDBC;

import org.it.util.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/5 19:46
 */
public class JDBCDemo11 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "update `account` set money = 10 where id = 1";
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(stmt, conn);
        }
    }
}
