package org.example;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import aopAnno.User;

/**
 * @Author: YinZhihao
 * @Description:
 * @Date: Created in 23:04 2022/1/5
 */
public class Aop {
    @Test
    public void testAopAnno(){
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        User user = context.getBean("user",User.class);
        user.add();
    }
}
