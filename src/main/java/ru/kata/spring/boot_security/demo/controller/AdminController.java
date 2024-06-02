package ru.kata.spring.boot_security.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.servise.UserService;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    //главная страница
    @GetMapping
    public String showUsersTable(Model model){
        model.addAttribute("users", userService.getUsersList());
        return "admin/usersPage";
    }
    //новый пользователь
    @GetMapping("/new")
    public String showUserForm(@ModelAttribute("user") User user){
        return "admin/userForm";
    }
    @PostMapping()
    public String processUserForm(@ModelAttribute("user") User user){
        userService.createUser(user);
        return "redirect:admin/";
    }
    //изменение пользователя
    @GetMapping("edit")
    public String showUsersForm(@RequestParam ("id") Long userId, Model model) {
        model.addAttribute("user", userService.getUser(userId));
        return "admin/editForm";
    }
    @PostMapping("/userUpdate")
    public String processEditForm(@ModelAttribute User user){
        userService.updateUser(user);
        return "redirect:admin/";
    }
    //удаление
    @GetMapping("delete")
    public String processDeleteForm(@RequestParam("id") Long userId) {
        userService.deleteUser(userId);
        return "redirect:admin/";
    }
}
