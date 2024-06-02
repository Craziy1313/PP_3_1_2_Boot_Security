package ru.kata.spring.boot_security.demo.DAO;


import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserDao {
    List<User> getUsersList();
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
    User getUser(Long id);
}
