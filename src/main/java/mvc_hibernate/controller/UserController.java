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

    @GetMapping("/new")
    public String newUserForm(Model model) {
        model.addAttribute("user", new User());
        return "add-user"; // Форму для создания нового пользователя
    }

    @PostMapping("/add")
    public String addUser(@RequestParam("name") String name,
                          @RequestParam("lastName") String lastName,
                          @RequestParam("email") String email) {
        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setEmail(email);

        userService.saveUser(user); // Сохранение пользователя через сервис
        return "redirect:/users"; // Перенаправление обратно на список пользователей
    }

    @GetMapping("/{id}/edit")
    public String editUserForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit-user"; // Форму для редактирования пользователя
    }

    @PostMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Long id,
                           @RequestParam("name") String name,
                           @RequestParam("lastName") String lastName,
                           @RequestParam("email") String email) {
        User user = userService.getUserById(id);
        if (user != null) {
            user.setName(name);
            user.setLastName(lastName);
            user.setEmail(email);
            userService.updateUser(user); // Используем отдельный метод для обновления
        }
        return "redirect:/users";
    }

    @PostMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users"; // После удаления редирект на список пользователей
    }
}
