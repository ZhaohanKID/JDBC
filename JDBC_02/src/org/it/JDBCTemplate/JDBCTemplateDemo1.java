package org.it.JDBCTemplate;

import org.it.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/5 12:44
 */
public class JDBCTemplateDemo1 {
    public static void main(String[] args) {
        // 1 导入jar包
        // 2 创建 JDBCTemplate 对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        // 3 调用方法
        String sql = "update `account` set money = 15000 where id = ?";
        int count = template.update(sql, 4);
        System.out.println(count);
    }
}
