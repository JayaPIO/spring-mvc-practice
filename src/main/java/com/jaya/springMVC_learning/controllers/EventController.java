package com.jaya.springMVC_learning.controllers;

import com.jaya.springMVC_learning.models.Event;
import com.jaya.springMVC_learning.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/event")
public class EventController {

    @Autowired
    EventService eventService;

    @PostMapping
    public String addEvent(Event event, Model model) {
        return eventService.addNewEvent(event, model);
    }

    @PostMapping("/eventDetail")
    public String getEventById(@RequestParam("id") int id, Model model) {
        return eventService.eventById(id, model);
    }

}
