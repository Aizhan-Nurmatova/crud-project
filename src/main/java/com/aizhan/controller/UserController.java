package com.aizhan.controller;

import com.aizhan.model.Role;
import com.aizhan.model.User;
import com.aizhan.service.RoleService;
import com.aizhan.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping
public class UserController {


    private  UserService userService;
    private RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/")
    public String mainController(){
        return "main-page";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/user")
    public String getUser(Principal principal,Model model){
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user",user);
        return "user";
    }

    @GetMapping("/admin")
    public String listUsers(Model model){
        List<User> users = userService.listUsers();
        model.addAttribute("users",users);
        return "users";
    }


    @GetMapping("/users/add-user")
    public String addUser(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("user", new User());
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("allRoles", roles);
        System.out.println(model.addAttribute("allRoles", roles));
        return "add-user";
    }

    @PostMapping("/users/save-user")
    public String saveUser(User user, @RequestParam Map<String,String> form) {
        List<String> roles = roleService.getNamesOfRolesToList();
        Set<String> strings = new HashSet<>(roles);
        user.getRoles().clear();
        for (String key : form.keySet()) {
            if (strings.contains(key)) {
                user.getRoles().add(roleService.getRoleByName(key));
                System.out.println(roles + " " + roleService.getRoleByName(key));
            }
        }
        userService.mergeUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/users/delete")
    public String deleteUser(@RequestParam("id") int id) {
        //delete user by id
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/users/edit")
    public String editUser(@RequestParam("id") int id, Model model) {
            User user = userService.getById(id);
            model.addAttribute("user", user);
            List<Role> roles = roleService.getAllRoles();
            model.addAttribute("allRoles", roles);
            return "update-user";
    }
}
