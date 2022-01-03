package org.example.service;

import org.example.dao.UserDao;
import org.example.dao.UserDaoImpl;

/**
 * @Author: YinZhihao
 * @Description:
 * @Date: Created in 16:33 2022/1/3
 */
public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(){
        System.out.println("service add ......");
        userDao.update();

    }
}
