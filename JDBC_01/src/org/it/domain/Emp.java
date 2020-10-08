package org.it.domain;

/**
 * 这个是用来封装的javabean
 *
 * 将表看成一个类，每行数据看成一个对象，封装，放在即合理，打印。
 * @Author: Z.HAN
 * @Date: 2020/10/4 14:07
 */
public class Emp {
    private String JOB_ID;
    private String JOB_TITLE;
    private String MIN_SALARY;
    private String MAX_SALARY;

    public String getJOB_ID() {
        return JOB_ID;
    }

    public void setJOB_ID(String JOB_ID) {
        this.JOB_ID = JOB_ID;
    }

    public String getJOB_TITLE() {
        return JOB_TITLE;
    }

    public void setJOB_TITLE(String JOB_TITLE) {
        this.JOB_TITLE = JOB_TITLE;
    }

    public String getMIN_SALARY() {
        return MIN_SALARY;
    }

    public void setMIN_SALARY(String MIN_SALARY) {
        this.MIN_SALARY = MIN_SALARY;
    }

    public String getMAX_SALARY() {
        return MAX_SALARY;
    }

    public void setMAX_SALARY(String MAX_SALARY) {
        this.MAX_SALARY = MAX_SALARY;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "JOB_ID='" + JOB_ID + '\'' +
                ", JOB_TITLE='" + JOB_TITLE + '\'' +
                ", MIN_SALARY='" + MIN_SALARY + '\'' +
                ", MAX_SALARY='" + MAX_SALARY + '\'' +
                '}';
    }
}
