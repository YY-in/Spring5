package aop;

import org.example.User;

import java.sql.SQLOutput;

/**
 * @Author: YinZhihao
 * @Description:
 * @Date: Created in 16:58 2022/1/5
 */
public class UserDaoImpl implements UserDao {

    @Override
    public int add(int a, int b) {
        System.out.println("add  function  execute");
        return a+b;
    }

    @Override
    public String update(String id) {
        System.out.println("update function execute");
        return id;
    }
}
