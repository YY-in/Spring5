package org.example;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

/**
 * @Author: YinZhihao
 * @Description:
 * @Date: Created in 21:43 2022/1/4
 */
public class TestAnnotation {
    @Test
    public void UserService(){
        ApplicationContext context = new ClassPathXmlApplicationContext("annotation.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }
}
