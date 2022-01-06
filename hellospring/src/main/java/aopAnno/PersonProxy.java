package aopAnno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: YinZhihao
 * @Description:
 * @Date: Created in 17:11 2022/1/6
 */
@Aspect
@Component
public class PersonProxy {
    @Before(value = "execution(* aopAnno.User.add(..))")
    public void befordemo(){

    }
}
