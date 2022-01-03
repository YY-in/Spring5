package org.example.dao;

/**
 * @Author: YinZhihao
 * @Description:
 * @Date: Created in 16:36 2022/1/3
 */
public class UserDaoImpl implements UserDao{
    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void update() {
        System.out.println("dao update..."+username);
    }
}
