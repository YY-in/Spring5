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
   </dependencies>
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

    
> #### 2.3.1.IOC操作Bean管理（基于XML）
>1. 创建对象  
  >> ![xml的对象创建](./img/xmlBeanOperation.png)   
  >> 1. 在spring配置文件中,使用bean标签,标签里面添加对应的属性,就可以实现对象的创建
  >> 2. 在bean标签中有很多属性,以下介绍常用的属性
   >>> + class ： 所需要创建对象类的全路径(包类路径)
   >>> + id : 获取对象的唯一标识
   >>> + name ： 可以使用特殊符号的id属性
  >> 3. 创建对象的时候默认执行无参构造
>2. 注入属性    
  >> 1. DI：依赖注入：就是属性
  >>> + 第一种注入方式：使用set方法进行注入     
  >>>> 1. 创建类：定义属性和对应的set方法
  >>>>  2. 在spring配置文件配置对象创建，配置属性注入
```xml
    <!--1.创建对象-->
    <bean id="book" class="org.example.Book">
        <!--2.set方法注入属性-->
        <!--使用property完成属性注入
            name:类里面属性的名称
            value:向属性里面注入的值
            -->
        <property name="bname" value="精神明亮的人"></property>
        <property name="bauthor" value="王开岭"></property>
    </bean>
```
  >>> + 第二种注入方式：使用有参数的构造进行注入   
  >>>>  1. 创建类：定义属性和属性对应的有参构造方法
  >>>>  2. 在spring的配置文件中配置对象创建，配置属性注入,可以通过索引值或者名称完成注入
```xml
    <!--3.利用有参构造注入属性-->
    <bean id="order" class="org.example.Order">
        <constructor-arg index="1" value="南京"/>
        <constructor-arg name="oname" value="书本"/>
    </bean>
```
  >>> + 简化操作--p名称空间注入   
        使用p名称空间注入，可以简化基于xml配置方式
  >>>>  1. 在配置文件中添加名称空间
```xml
<beans xmlns:p="http://www.springframework.org/schema/p">
    ......
</beans>
```   
  >>>> 2. 在bean标签中进行属性注入
```xml
<bean id="book" class="org.example.Book" p:bauthor="卡夫卡" p:bname="变形计"></bean>
```  
> 
  >>2. xml注入其他类型属性
   >>>1. 字面量注入: 设置属性的固定值就是字面量
   >>>> + null值   
```xml
<!--1.创建对象-->
<bean id="book" class="org.example.Book">
    <!--2.set方法注入属性-->
    <!--使用property完成属性注入： name:类里面属性的名称； value:向属性里面注入的值-->
    <property name="bauthor">
        <null/>
    </property>
</bean>
```
   >>>> + 属性值包含特殊符号   
```xml
    <bean>
    <!--属性值包含特殊符号:1. 把特殊符号进行转译2. 把特殊符号内容写入CDATA当中-->
        <property name="bname">
            <value><![CDATA[<<南京>>]]></value>
        </property>
    </bean>
```
> 
   >>>2. 外部bean注入
   >>>>a. 创建两个类Service类和dao类   
   >>>>b. 在service类调用dao里面的方法   
   >>>>c. 在spring的配置文件中进行配置
```xml
<!--创建service和dao对象标签-->
<!--内部bean-->
<bean id="emp" class="org.example.bean.Emp">
    <!--设置两个普通属性-->
    <property name="ename" value="lucy"></property>
    <property name="gender" value="女"></property>
    <!--设置对象类型属性-->
    <property name="dept">
        <!--内部bean-->
        <bean id = "dept" class="org.example.bean.Dept">
            <property name="dname" value="保安部"></property>
        </bean>
    </property>
</bean>
```
> 
   >>>3. 内部bean注入
   >>>>1.一对多关系:部门和员工 (一个部门有多个员工,一个员工属于一个部门)   
   >>>>2.在实体类中表示一对多的关系,员工体现所属部门，使用对象类型属性进行表示   
   >>>>3.在spring配置文件中进行配置
```xml
    <!--内部bean-->
    <bean id="emp" class="org.example.bean.Emp"><!--设置两个普通属性-->
        <property name="ename" value="lucy"></property>
        <property name="gender" value="女"></property>
        <!--设置对象类型属性-->
        <property name="dept">
            <!--内部bean-->
            <bean id = "dept" class="org.example.bean.Dept">
            <property name="dname" value="保安部"></property>
            </bean>
        </property>
    </bean>
```
  >>>4. 级联复制
  >>>>1. 外部bean写法
```xml
<beans>
  <!--级联赋值-->
    <bean id="emp" class="org.example.bean.Emp">
        <!--设置两个普通属性-->
        <property name="ename" value="yyin"></property>
        <property name="gender" value="男"></property>
        <!--级联赋值-->
        <property name="dept" ref="dept"></property>
    </bean>

    <bean id="dept" class="org.example.bean.Dept">
        <property name="dname" value="开发部"></property>
    </bean>
</beans>
``` 
  >>>>2.get方法的写法，注意要写对应对象的个方法
```xml
<beans>
    <!--级联赋值-->
    <bean id="emp" class="org.example.bean.Emp">
        <!--设置两个普通属性-->
        <property name="ename" value="yyin"></property>
        <property name="gender" value="男"></property>
        <!--级联赋值-->
        <property name="dept" ref="dept"></property>
        <property name="dept.dname" value="财务部"></property>
    </bean>
    <bean id="dept" class="org.example.bean.Dept">
        <property name="dname" value="开发部"></property>
    </bean>
</beans>
```  
>>>5. xml注入集合属性
>>>>a. 注入数组类型属性   
>>>>b. 注入List集合类型属性   
>>>>c. 注入Map集合     
>
>>>(1) 创建类,定义数组、list、map、set类型属性,生成对应set方法  
>>>(2) 在spring配置文件中,注入集合属性
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <!--集合类型属性注入-->
    <bean id="stu" class="collectiontype.Stu">
        <!--array类型属性注入-->
        <property name="courses">
            <array>
                <value>java课程</value>
                <value>数据库课程</value>
            </array>
        </property>
        <!--list类型属性注入-->
        <property name="list">
            <list>
                <value>yyin</value>
                <value>yiin</value>
            </list>
        </property>
        <!--map类型属性注入-->
        <property name="maps">
            <map>
                <entry key="JAVA" value="java"></entry>
                <entry key="DATABASE" value="database"></entry>
            </map>
        </property>
        <!--set型属性注入-->
        <property name="sets">
            <set>
                <value>MYSQL</value>
                <value>Redis</value>
            </set>
        </property>
    </bean>
</beans>
```
>>>6. 在集合里面设置对象类型值
```xml
    <bean>
        <property name="courseList">
            <list>
                <ref bean="course1"></ref>
                <ref bean="course2"></ref>
            </list>
        </property>
    </bean>

    <!--创建多个course对象 -->
    <bean id="course1" class="collectiontype.Course">
        <property value="Spring5框架" name="cname"></property>
    </bean>
    <!--创建多个course对象 -->
    <bean id="course2" class="collectiontype.Course">
        <property value="MyBatis框架" name="cname"></property>
    </bean>
```
>>>7. 提取集合注入内容
>>>>(1)在spring配置文件中引入名称空间util
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:utils="http://www.springframework.org/schema/utils"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
                            http://www.springframework.org/schema/beans/spring-beans.xsd 
                            http://www.springframework.org/schema/context 
                            https://www.springframework.org/schema/utils/spring-utils.xsd">
```
>>>>(2)使用util标签完成list集合注入提取
```xml
<!--1 提取list集合类型属性注入-->
<utils:list id="bookList">
    <value>liunx</value>
    <value>mac</value>
    <value>windows</value>
</utils:list>>
<!--2 提取list集合类型属性注入-->
<bean id="book" class="...">
    <property name="list" ref="bookList"></property>
</bean>
```
>>>8. FactoryBean
>>>>Spring有两种bean，一种普通bean，另一种工厂bean()
>>>>> 普通bean：定义的bean类型就是返回类型  
>>>>> 工厂bean：在配置文件定义bean类型可以和返回类型不相同   
>>>> (1)创建类，让这个类作为工厂bean,实现接口FactoryBean   
>>>> (2)实现接口里面的方法，在实现的方法中定义返回的bean类型
>>>9. bean的作用域     
>>>>在Spring里面，设置创建的bean实例可以是一个单实例（对象的地址相同），还可以是一个多实例  
    在Spring里面，默认情况下，bean是一个单示例对象  
    那么如何设置对象是单实例还是多实例？    
(1)在spring配置文件中可以通过scope属性进行设置   
(2)scope属性值：   
a. 默认值 singleton 表示单示例对象 (预加载创建单独对象)
b. prototype 表示是多实例对象 (使用getBean()方法时,创建一个新的对象) 
c. request 请求 session 对话
```xml
<bean id="book" class="..." scope="prototype">
    <property name="list" ref="booklist"></property>
</bean>
```
> 
>>>10. bean的生命周期
>    
> #### 2.3.2.IOC操作Bean管理（基于注释）
1. 创建对象
2. 注入属性
> ## 3.Aop

> ## 4.JDBCTemplate

> ## 5.事务管理

> ## 6.Spring5新特性

