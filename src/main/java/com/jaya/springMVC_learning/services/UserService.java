package com.jaya.springMVC_learning.services;

import com.jaya.springMVC_learning.models.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

public interface UserService {
    String addNewUser(@ModelAttribute User user, Model model);

    String getAllUsers(Model model);
}
