package ru.kata.spring.boot_security.demo.servise;

import ru.kata.spring.boot_security.demo.models.Role;

import java.util.List;

public interface RoleServise {
    List<Role> getRoles();
    Role getRoleById(long id);
    void addRole( Role role);
}
