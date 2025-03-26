package com.jaya.springMVC_learning.controllers;

import com.jaya.springMVC_learning.constants.ViewConstant;
import com.jaya.springMVC_learning.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class EventManagementController {
    @Autowired
    private EventService eventService;

    @GetMapping
    public String home() {
        return ViewConstant.HOME_PAGE;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return ViewConstant.LOGIN_PAGE;
    }

    @GetMapping("/manager")
    public String managerView(Model model) {
        return eventService.allEventsTable(model);
    }

    @GetMapping("/admin")
    public String adminView() {
        return ViewConstant.ADMIN_VIEW_PAGE;
    }

    @GetMapping("/access-denied")
    public String accessDeniedViewPage() {
        return ViewConstant.ACCESS_DENIED_PAGE;
    }

}
