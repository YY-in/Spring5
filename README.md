# Spring5 框架

> ## 1.Spring框架概述

> ### 1.1.简介

 	1. Spring是轻量级、开源、JavaEE的框架
 	2. Spring可以解决企业应用开发的复杂性
 	3. Spring有两个核心部分：IOC和Aop
 	 + IOC：控制反转，把创建对象的过程交给Spring进行
 	 + Aop：面向切面，不修改源代码的情况下进行功能增强

4. Spring的特点：
   + 方便解耦，简化开发
   + Aop编程支持
   + 方便程序的测试
   + 方便其他框架的整合使用
   + 降低Java EE API开发难度
   + 方便进行事务管理

5. 选择Spring5学习

> ### 1.2.准备工作

1. maven创建普通java项目

2. 编写pom.xml文件，导入Springframework，以及commons-logging依赖

   ```xml
   <dependencies>
       <dependency>
           <groupId>junit</groupId>
           <artifactId>junit</artifactId>
           <version>4.11</version>
           <scope>test</scope>
       </dependency>
       <dependency>
           <groupId>org.springframework</groupId>
           <artifactId>spring-beans</artifactId>
           <version>5.3.5</version>
       </dependency>
       <dependency>
           <groupId>org.springframework</groupId>
           <artifactId>spring-core</artifactId>
           <version>5.3.5</version>
       </dependency>
       <dependency>
           <groupId>org.springframework</groupId>
           <artifactId>spring-context</artifactId>
           <version>5.3.5</version>
       </dependency>
       <!-- https://mvnrepository.com/artifact/commons-logging/commons-logging -->
       <dependency>
           <groupId>commons-logging</groupId>
           <artifactId>commons-logging</artifactId>
           <version>1.1.1</version>
       </dependency>
       <!-- https://mvnrepository.com/artifact/commons-logging/commons-logging -->
       <dependency>
           <groupId>commons-logging</groupId>
           <artifactId>commons-logging</artifactId>
           <version>1.1.1</version>
       </dependency>
   ```

3. 创建一个测试的java类User，包含方法add();

   ```java
   package org.example;
   
   public class User {
   
       public static void add(){
           System.out.println("add");
       }
   }
   ```

4. 在main/resource目录下的创建Spring的xml配置文件，并创建对象

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
       <!--配置User对象创建-->
       <bean id="user" class="org.example.User"></bean>
   </beans>
   ```

5. 进行单元测试

   ```java
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
   
           System.out.println(user);
       }
   }
   ```

   

>## 2.IOC容器

>### 2.1.IOC的底层原理

#### 2.1.1.什么是IOC（控制反转）

1. 控制反转，把对象创建和对象之间的调用过程交给Spring进行管理
2. 使用IOC的目的： 为了降低耦合度
3. 上文的准备内容就是IOC的实现

#### 2.1.2.IOC的底层原理

1. xml解析、工厂模式、反射

![image-20210927110422772](./img/image-20210927110422772.png)

![image-20210927110925959](./img/image-20210927110925959.png)

![image-20210927111730800](./img/image-20210927111730800.png)
1. 解析 xml文件
2. 反射加载字节码文件
3. 反射创建类的对象（强转）
> ### 2.2.IOC接口（BeanFactory）
1. IOC的思想基于IOC容器完成，IOC底层就是对象工厂
2. Spring提供IOC实现的两种方式（两个接口）
   + BeanFactory
     + IOC容器基本实现，是Spring内部使用的接口，不提供开发人员使用。
     + 加载配置文件时候不会创建对象，在获取对象(使用getBean()方法)的时候才会创建对象。
   + ApplicationContext
     + BeanFactory接口的子接口，提供更加强大的功能，一般由开发人员使用。
     + 加载配置文件的时候就会把在配置文件中的对象进行创建
3. Application接口的实现类
      ![接口实现类](./img/ApplicationHierarchyTree.png)
    + FileSystemXmlApplication()添加系统的绝对路径
    + ClassPathXmlApplication() 对应项目src下开始的目录路径

> ### 2.3.Bean管理
1. 什么是Bean管理，它指的是两个操作
    1. Spring创建对象
    2. Spring的属性注入
#### 2.3.1IOC操作Bean管理（基于XML）
1. 创建对象
2. 注入属性
#### 2.3.2IOC操作Bean管理（基于注释）
1. 创建对象
2. 注入属性
> ## 3.Aop

> ## 4.JDBCTemplate

> ## 5.事务管理

> ## 6.Spring5新特性

