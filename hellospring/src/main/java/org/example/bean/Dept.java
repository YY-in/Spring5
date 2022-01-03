package org.example.bean;

/**
 * @Author: YinZhihao
 * @Description:部门类
 * @Date: Created in 17:39 2022/1/3
 */
public class Dept {
    private String dname;

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dname='" + dname + '\'' +
                '}';
    }
}
