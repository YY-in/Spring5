package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @Author: YinZhihao
 * @Description:
 * @Date: Created in 17:01 2022/1/5
 */
public class JDKProxy {
    public static void main(String[] args) {
        //接口类
        Class[] interfaces = {UserDao.class};
        //
        UserDaoImpl userDao = new UserDaoImpl();
        //创建接口实现类的代理对象
        UserDao dao = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        System.out.println(dao.add(2, 3));
        System.out.println(dao.update("123"));
    }


}
//创建代理对象代码，增强类
class UserDaoProxy implements InvocationHandler {
    //1.把代理对象指向的实现类传递过来
    //有参数构造传递
    private Object obj;
    public UserDaoProxy(Object  obj){
        this.obj=obj;
    }
    //增强的逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法之前
        System.out.println("在方法之前执行"+method.getName()+":传递的参数..."+ Arrays.toString(args));

        //被增强方法执行
        Object res = method.invoke(obj, args);

        //方法之后
        System.out.println("在方法之后执行..."+obj);

        return res;
    }
}
