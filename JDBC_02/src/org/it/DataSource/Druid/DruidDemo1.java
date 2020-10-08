package org.it.DataSource.Druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.util.Properties;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/5 11:05
 */
public class DruidDemo1 {
    public static void main(String[] args) throws Exception {
        // 1 导入jar包
        // 2 导入配置文件
        // 3 加载配置文件
        Properties prop = new Properties();
        prop.load(new FileReader("D:\\IntelliJ IDEA程序\\JDBC\\JDBC_02\\src\\druid.properties"));
        // 4 获取连接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(prop);
        // 5 获取连接
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
