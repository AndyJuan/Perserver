package dao;

import entities.User;


import java.util.List;

public interface IUserDao {

    List<User> findAll();

    User findById(Integer usrId);

    int saveUser(User user);

    int deleteUser(Integer userId);

    List<User> findByName(String username);

    int findTotal();
}