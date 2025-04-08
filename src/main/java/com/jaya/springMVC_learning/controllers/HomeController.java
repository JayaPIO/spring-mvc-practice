package com.jaya.springMVC_learning.controllers;

import com.jaya.springMVC_learning.services.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @PostMapping("/add")
    public String add(HttpServletRequest req) {
        int i = Integer.parseInt(req.getParameter("num1"));
        int j = Integer.parseInt(req.getParameter("num2"));

        int num3 = i + j;
        HttpSession session = req.getSession();
        session.setAttribute("num3", num3);
        return "result";
    }
}
