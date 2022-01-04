package dao;

import org.example.User;
import org.springframework.stereotype.Repository;

/**
 * @Author: YinZhihao
 * @Description: Dao实现类
 * @Date: Created in 22:35 2022/1/4
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("dao add ...");
    }
}
