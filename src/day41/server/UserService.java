package day41.server;

import day41.pojo.User;

import java.util.List;

public interface UserService {
    User login(String username, String password);
    List<User> findUser();

    int addUser(String username, String password);
}
