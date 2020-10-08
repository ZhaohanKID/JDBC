package org.it.JDBCTemplate;

import org.it.domain.Emp;
import org.it.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/5 12:55
 */
public class JDBCTemplateDemo2 {
    // Junit单元测试，可以让方法独立执行
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /*
         1 修改一条数据
     */
    // 这Test是一个注解
    @Test
    public void test1() {
        // 定义sql语句
        String sql = "update t_jobs set MIN_SALARY = 1000 where JOB_ID = 'MK_MAN'";
        // 调用方法
        int count = template.update(sql);
        System.out.println(count);
    }

    /*
        2 添加一条记录
     */
    @Test
    public void test2() {
        /*
        会出现sql注入
        String sql = "insert into t_jobs(JOB_ID,JOB_TITLE) values('Z.TAO','SUPERSTAR')";
        int count = template.update(sql);*/
        String sql = "insert into t_jobs(JOB_ID,JOB_TITLE) values(?,?)";
        int count = template.update(sql,"Z.YUAN","Programmer");
        System.out.println(count);
    }

    /*
        删除刚才的记录
     */
    @Test
    public void test3() {
        String sql = "delete from t_jobs where JOB_ID = ?";
        int count = template.update(sql,"Z.TAO");
        System.out.println(count);
    }
    /*
        查询一条记录，并将结果封装到Map集合中
        注意：这个方法查询的结果集只能是长度为1.
     */
    @Test
    public void test4() {
        String sql = "select * from t_jobs where JOB_ID = ?";
        Map<String, Object> map = template.queryForMap(sql, "Z.HAN");
        System.out.println(map);
        // {JOB_ID=Z.HAN, JOB_TITLE=Programmer, MIN_SALARY=null, MAX_SALARY=null}
    }
    /*
        查询所有记录，封装为List集合
        将每条记录封装为map集合，最后再将map集合放到list里面
     */
    @Test
    public void test5() {
        String sql = "select * from t_jobs";
        List<Map<String, Object>> list = template.queryForList(sql);
        for (Map<String, Object> map : list) {
            System.out.println(map);
        }
    }
    /*
        查询数据并封装成Emp对象
     */
    @Test
    public void test6() {
        String sql = "select * from t_jobs";
        List<Emp> list = template.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {
                Emp emp = new Emp();

                String JOB_ID = rs.getString("JOB_ID");
                String JOB_TITLE = rs.getString("JOB_TITLE");
                String MIN_SALARY = rs.getString("MIN_SALARY");
                String MAX_SALARY = rs.getString("MAX_SALARY");

                emp.setJOB_ID(JOB_ID);
                emp.setJOB_TITLE(JOB_TITLE);
                emp.setMIN_SALARY(MIN_SALARY);
                emp.setMAX_SALARY(MAX_SALARY);

                return emp;
            }
        });
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    /*
        简化方式
     */
    @Test
    public void test6_2() {
        String sql = "select * from t_jobs";
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    /*
        7 查询总记录数
        queryForObject 一般用来执行聚合函数
     */
    @Test
    public void test7() {
        String sql = "select count(JOB_ID) from t_jobs";
        Long total = template.queryForObject(sql, Long.class);
        System.out.println(total);
    }
}
