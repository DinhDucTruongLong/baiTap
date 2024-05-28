package com.example.dinhductruonglong.Controllers;
import com.example.dinhductruonglong.Entitys.Role;
import com.example.dinhductruonglong.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("")
    public String showAllRoles(Model model) {
        List<Role> roles = roleService.getAllRole();
        model.addAttribute("Roles", roles);
        return "Role/Index";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        Role role = new Role();
        model.addAttribute("Role", role);
        return "Role/Create";
    }

    @PostMapping("/create")
    public String saveCreateRole(@ModelAttribute Role role) {
        roleService.createRole(role);
        return "redirect:/roles";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable String id, Model model) {
        Role role = roleService.getRoleById(id);
        model.addAttribute("Role", role);
        return "Role/Update";
    }

    @PostMapping("/update")
    public String saveUpdateRole(@ModelAttribute Role role) {
        roleService.updateRole(role.getRole_id(), role);
        return "redirect:/roles";
    }

    @GetMapping("/delete/{id}")
    public String deleteRole(@PathVariable String id) {
        roleService.deleteRole(id);
        return "redirect:/roles";
    }
}
