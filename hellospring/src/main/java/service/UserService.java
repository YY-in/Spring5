package service;

import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: YinZhihao
 * @Description:
 * @Date: Created in 21:33 2022/1/4
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public void  add(){
        System.out.println("Service add ...");
        userDao.add();
    }
}
