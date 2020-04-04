package cn.eli.vue.service;

import cn.eli.vue.entity.User;


import java.util.List;

public interface UserService {

    List<User> getAllUser();

    List<User> getUserByName(String username);

    List<User> getUserByNameAndPWD(String username,String password);

    int addUser(User user);
}
