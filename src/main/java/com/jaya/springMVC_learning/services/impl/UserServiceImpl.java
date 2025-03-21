package com.jaya.springMVC_learning.services.impl;

import com.jaya.springMVC_learning.models.User;
import com.jaya.springMVC_learning.repositories.UserRepository;
import com.jaya.springMVC_learning.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public String addNewUser(User user, Model model) {
        model.addAttribute("name", user.getUserName());

        userRepository.save(user);
        return "userResult";
    }

    @Override
    public String getAllUsers(Model model) {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            String msg = "no user to display";
            model.addAttribute("emptyList", msg);
            return "displayUsers";
        } else {
            model.addAttribute("getUserResult", users);
            return "displayUsers";
        }
    }
}
