package org.it.DataSource.Druid;

import org.it.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/5 11:29
 */
public class DruidDemo2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // 获取连接
            conn = JDBCUtils.getConnection();
            // 定义sql
            String sql = "insert into `account`(id,name_id,money) values(4,?,?)";
            pstmt = conn.prepareStatement(sql);
            // 给sql赋值
            pstmt.setString(1, "Hannah");
            pstmt.setInt(2, 10000);
            // 处理结果
            int count = pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }
    }
}
