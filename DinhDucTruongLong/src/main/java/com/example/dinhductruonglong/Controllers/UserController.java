package com.example.dinhductruonglong.Controllers;


import com.example.dinhductruonglong.Entitys.Role;
import com.example.dinhductruonglong.Entitys.User;
import com.example.dinhductruonglong.RequestEntities.RequestCreateUser;
import com.example.dinhductruonglong.services.RoleService;
import com.example.dinhductruonglong.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/Users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @GetMapping("")
    public String ShowallUser(Model model) {
            List<User> user = userService.getAllUser();
        model.addAttribute("Users", user);
        return "User/Index";
    }

    @GetMapping("/Update/{id}")
    public String ShowStudentForm(@PathVariable String id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("User", user);
        return "User/Update";
    }
    @PostMapping("/saveEdit")
    public String SaveEditUser(User requestUpdateUser){
        userService.updateUser(requestUpdateUser.getId(),requestUpdateUser);
        return "redirect:/users";
    }
    @GetMapping("/Create")
    public String createForm(Model model){
        User user = new User();
        List<Role> listRole = roleService.getAllRole();
        model.addAttribute("listRole",listRole);
        model.addAttribute("User", user);
        return "User/Create";
    }
    @PostMapping("/Create")
    public String SaveCreateUser(RequestCreateUser requestCreateUser){
        userService.CreateUser(requestCreateUser);
        return "redirect:/Users";
    }
    @GetMapping("/details/{id}")
    public String viewUserDetails(@PathVariable String id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("User", user);
        return "User/Details";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
