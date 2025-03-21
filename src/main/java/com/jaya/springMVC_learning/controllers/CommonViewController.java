package com.jaya.springMVC_learning.controllers;

import com.jaya.springMVC_learning.constants.ViewConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/event")
public class CommonViewController {

    @GetMapping("/findEvent")
    public String getUserId() {
        return ViewConstant.USER_ID_FORM;
    }

    @GetMapping
    public String showEventForm() {
        return ViewConstant.EVENT_FORM;
    }
}
