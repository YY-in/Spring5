package org.example;

/**
 * @Author: YinZhihao
 * @Description: 演示使用set方法进行属性注入
 * @Date: Created in 21:54 2022/1/2
 */
public class Book {
    //创建属性
    private  String bname;
    private String bauthor;

    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public void testDemo(){
        System.out.println(bname+"::"+bauthor);
    }
}
