package org.example;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestSpring5 {
    @Test
    public void tsetAdd() {
        //1.加载Spring的配置文件.注意需要读取的目录路径
        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/applicatinContext.xml");
        //2.获取配置创建的对象
        User user = context.getBean("user",User.class);
        //3.查创建的对象
        System.out.println(user);
        //4.调用创建对象的方法
        user.add();
    }
}
