package aopAnno;

//2.创建增强类(编写增强逻辑)
//(1)在增强类里面,创建方法,让不同方法代表不同通知类型

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/** 3.进行通知配置
 * (1)在spring配置文件中,开启注解扫描器
 * (2)使用注解创建User和UserProxy对象
 * (3)在增强类上面添加注解@Aspect
 * (4)在spring配置文件中打开生成代理对象
 */

/** 4. 配置不同类型的通知
 *  (1)在增强类的里面,在作为通知方法上面添加通知类型注解,使用切入点表达式配置
 */
@Aspect  //生成代理对象
@Component
public class UserProxy {

    //相同切入点抽取
    @Pointcut(value = "execution(* aopAnno.User.add(..))")
    public void pointdemo(){

    }
    @Before(value="pointdemo()")
    public void  before (){
        System.out.println("before.....");
    }
    //后置通知（返回通知）
    @AfterReturning(value = "execution(* aopAnno.User.add(..))")
    public void afterReturning() {
        System.out.println("afterReturning.........");
    }

    //最终通知
    @After(value = "execution(* aopAnno.User.add(..))")
    public void after() {
        System.out.println("after.........");
    }

    //异常通知
    @AfterThrowing(value = "execution(* aopAnno.User.add(..))")
    public void afterThrowing() {
        System.out.println("afterThrowing.........");
    }

    //环绕通知
    @Around(value = "execution(* aopAnno.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前.........");

        //被增强的方法执行
        proceedingJoinPoint.proceed();

        System.out.println("环绕之后.........");
    }
}
