package day41.server;

import day41.dao.UserDao;
import day41.dao.UserDaoImpl;
import day41.pojo.User;

import java.util.List;

/**
 * @Author hhy
 * @Date 2019/8/23 11:45
 */
public class UserServiceImpl implements UserService {
    UserDao userDao=new UserDaoImpl();
    @Override
    public User login(String username, String password) {
        return userDao.login(username,password);
    }

    @Override
    public List<User> findUser() {
        return userDao.findUser();
    }

    @Override
    public int addUser(String username, String password) {
        return userDao.addUser(username,password);
    }
}
