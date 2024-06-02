package ru.kata.spring.boot_security.demo.servise;



import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getUsersList();
    void createUser(User user);
    void deleteUser(Long id);
    void updateUser(User user);
    User getUser(Long id);
    User findByUsername(String username);
}
