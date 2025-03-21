package com.jaya.springMVC_learning.controllers;

import com.jaya.springMVC_learning.models.User;
import com.jaya.springMVC_learning.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @GetMapping("/home")
    public String userPage() {
        return "user";
    }

    @PostMapping
    public String addUser(@ModelAttribute User u, Model model) {
        return userService.addNewUser(u, model);
    }

    @GetMapping
    public String getAllUsers(Model m) {
        return userService.getAllUsers(m);
    }

    @GetMapping("/{id}")
    public String getUser() {
        return "";
    }
}
