package day41.dao;

import day41.pojo.User;

import java.util.List;

public interface UserDao {
    User login(String username,String password);
    List<User> findUser();

    int addUser(String username, String password);
}
