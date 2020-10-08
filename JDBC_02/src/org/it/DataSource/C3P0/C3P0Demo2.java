package org.it.DataSource.C3P0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *  连接池参数的验证
 * @Author: Z.HAN
 * @Date: 2020/10/5 10:47
 */
public class C3P0Demo2 {
    public static void main(String[] args) throws SQLException {
        // 获取DataSource
        DataSource ds = new ComboPooledDataSource();
        // 获取连接
        for (int i = 1; i <= 10; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i + ":" + conn);

            if (i == 5) {
                conn.close();// 归还连接到连接池中
                // 结果第5个和第9个一样，说明第五个归还了，再次被第九个使用
            }
        }
    }
}
