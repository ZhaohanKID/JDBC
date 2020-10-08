package org.it.JDBC;

import org.it.domain.Emp;

import java.util.List;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/4 14:32
 */
public class JDBCTest1 {
    public static void main(String[] args) {
        JDBCDemo8 jdbc = new JDBCDemo8();
        List<Emp> list = jdbc.findAll();
        System.out.println(list);
        System.out.println(list.size());
        System.out.println("----------------------");
        for (Emp emp : list) {
            System.out.println(emp);
        }

        System.out.println("-----------------------");
        List<Emp> list1 = jdbc.findAll2();
        for (Emp emp : list1) {
            System.out.println(emp);
        }
    }
}
