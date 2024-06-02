package ru.kata.spring.boot_security.demo.servise;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repositories.UserRepositories;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService{

    private final UserRepositories userRepositories;

    public UserServiceImp(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }
    public User findByUsername(String username) {
        return userRepositories.findByUsername(username);
    }

    public List<User> getUsersList() {
        return userRepositories.findAll();
    }
    @Transactional
    public void createUser(User user) {
        userRepositories.save(user);
    }
    @Transactional
    public void updateUser(User user) {
        userRepositories.save(user);
    }
    @Transactional
    public void deleteUser(Long id) {
        userRepositories.deleteById(id);
    }
    public User getUser(Long id) {
        return userRepositories.findById(id).orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByUsername(username);
    }
}

