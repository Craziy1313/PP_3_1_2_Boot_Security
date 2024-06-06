package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.servise.RoleServise;
import ru.kata.spring.boot_security.demo.servise.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService, RoleServise roleServise) {
        this.userService = userService;
    }
    //главная страница
    @GetMapping
    public String showUsersTable(Model model, Principal principal){
        model.addAttribute("user", userService.findByUsername(principal.getName()));
        return "users/homePage";
    }

}
