package mvc_hibernate.controller;

import mvc_hibernate.model.User;
import mvc_hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users"; // Представление, которое будет возвращено
    }

    @GetMapping("users/new")
    public String newUserForm(Model model) {
        model.addAttribute("user", new User());
        return "add-user"; // Форму для создания нового пользователя
    }

    @PostMapping
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users"; // После сохранения редирект на список пользователей
    }

    @GetMapping("users/{id}/edit")
    public String editUserForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit-user"; // Форму для редактирования пользователя
    }

    @PostMapping("users/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute("user") User user) {
        user.setId(id);
        userService.updateUser(user);
        return "redirect:/users"; // После обновления редирект на список пользователей
    }

    @PostMapping("users/{id}/delete")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users"; // После удаления редирект на список пользователей
    }
}
