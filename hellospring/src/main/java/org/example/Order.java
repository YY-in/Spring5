package org.example;

/**
 * @Author: YinZhihao
 * @Description: 利用有参构造注入属性
 * @Date: Created in 22:15 2022/1/2
 */
public class Order {
    //属性
    private String oname;
    private String address;
    //有参构造

    public Order(String oname, String address) {
        this.oname = oname;
        this.address = address;
    }
    public void testDemo(){
        System.out.println(oname+"::"+address);
    }
}
