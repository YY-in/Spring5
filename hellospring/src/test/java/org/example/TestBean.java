package org.example;

import collectiontype.Stu;
import org.example.bean.Emp;
import org.example.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: YinZhihao
 * @Description:
 * @Date: Created in 17:10 2022/1/3
 */
public class TestBean {
    @Test
    public void exteriorBean(){
        //1.加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取配置创建的对象
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }
    @Test
    public void innerBean(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Emp emp = context.getBean("emp", Emp.class);
        emp.add();
    }
    @Test
    public void innerBean1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Emp emp = context.getBean("emp", Emp.class);
        emp.add();
    }
    @Test
    public void collectionTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("collectionContext.xml");
        final Stu stu = context.getBean("stu", Stu.class);
        stu.test();
    }
}
