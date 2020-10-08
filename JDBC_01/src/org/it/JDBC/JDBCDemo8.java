package org.it.JDBC;

import org.it.domain.Emp;
import org.it.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/4 14:12
 */
public class JDBCDemo8 {
    /**
     * 查询所有Emp对象
     * @return
     */
    public List<Emp> findAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Emp emp = null;
        List<Emp> list = null;
        try {
            // 1 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2 定义sql语句
            String sql = "select * from t_jobs";
            // 3 连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydb?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "root");
            // 4
            stmt = conn.createStatement();
            // 5 执行sql语句
            rs = stmt.executeQuery(sql);
            list = new ArrayList<Emp>();
            while (rs.next()) {
                String JOB_ID = rs.getString("JOB_ID");
                String JOB_TITLE = rs.getString("JOB_TITLE");
                String MIN_SALARY = rs.getString("MIN_SALARY");
                String MAX_SALARY = rs.getString("MAX_SALARY");

                emp = new Emp();
                emp.setJOB_ID(JOB_ID);
                emp.setJOB_TITLE(JOB_TITLE);
                emp.setMIN_SALARY(MIN_SALARY);
                emp.setMAX_SALARY(MAX_SALARY);

                list.add(emp);
            }
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
        return list;
    }

    public List<Emp> findAll2() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Emp emp = null;
        List<Emp> list = null;
        // 1 注册驱动 建立连接
        try {
            // 1 注册驱动
            //Class.forName("com.mysql.cj.jdbc.Driver");
            // 2 定义sql语句
            String sql = "select * from t_jobs";
            // 3 连接
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydb?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "root");

            conn = JDBCUtils.getConnection();
            // 4
            stmt = conn.createStatement();
            // 5 执行sql语句
            rs = stmt.executeQuery(sql);
            list = new ArrayList<Emp>();
            while (rs.next()) {
                String JOB_ID = rs.getString("JOB_ID");
                String JOB_TITLE = rs.getString("JOB_TITLE");
                String MIN_SALARY = rs.getString("MIN_SALARY");
                String MAX_SALARY = rs.getString("MAX_SALARY");

                emp = new Emp();
                emp.setJOB_ID(JOB_ID);
                emp.setJOB_TITLE(JOB_TITLE);
                emp.setMIN_SALARY(MIN_SALARY);
                emp.setMAX_SALARY(MAX_SALARY);

                list.add(emp);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, stmt, conn);
        }
        return list;
    }
}
