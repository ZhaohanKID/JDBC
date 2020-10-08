package org.it.JDBC;

import org.it.util.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/5 9:41
 */
public class JDBCDemo10 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;

        try {
            // 获取连接
            conn = JDBCUtils.getConnection();
            // 开启事务
            conn.setAutoCommit(false);

            // 定义sql
            String sql1 = "update account set money = money - ? where id = ?";
            String sql2 = "update account set money = money + ? where id = ?";
            // 获取执行sql对象
            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);
            // 给？赋值
            pstmt1.setInt(1, 500);
            pstmt1.setInt(2, 1);
            pstmt2.setInt(1 ,500);
            pstmt2.setInt(2 ,2);
            // 更新数据
            pstmt1.executeUpdate();

            // 手动制造一个异常
            int i = 3 / 0;

            pstmt2.executeUpdate();

            // 以上代码执行都没有问题，提交事务
            conn.commit();

        } catch (Exception e) {
            // 不管在上面出现什么异常，都会到catch里面去
            // 所以在这里回滚事务
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt1, conn);
            JDBCUtils.close(pstmt2, null);
        }
    }
}
