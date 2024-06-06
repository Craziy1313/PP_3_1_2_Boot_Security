package ru.kata.spring.boot_security.demo.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.repositories.RoleReprositories;
import ru.kata.spring.boot_security.demo.repositories.UserRepositories;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RoleServiceImp implements RoleServise {

    private final RoleReprositories roleReprositories;

    public RoleServiceImp(RoleReprositories roleReprositories) {
        this.roleReprositories = roleReprositories;
    }

    @Override
    public List<Role> getRoles() {
        return roleReprositories.findAll();
    }

    @Override
    public Role getRoleById(long id) {
        return roleReprositories.getById(id);
    }

    @Override
    public void addRole(Role role) {
        roleReprositories.save(role);

    }
}
