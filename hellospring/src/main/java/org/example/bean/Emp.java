package org.example.bean;

/**
 * @Author: YinZhihao
 * @Description: 员工类
 * @Date: Created in 17:40 2022/1/3
 */
public class Emp {
    private String ename;
    private String gender;
    //员工属于某一个部门，使用对象的方式进行表示
    private Dept dept;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void add(){
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Emp{" +
                "ename='" + ename + '\'' +
                ", gender='" + gender + '\'' +
                ", dept=" + dept +
                '}';
    }
}
