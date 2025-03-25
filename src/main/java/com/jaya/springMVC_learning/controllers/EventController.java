package com.jaya.springMVC_learning.controllers;

import com.jaya.springMVC_learning.models.Event;
import com.jaya.springMVC_learning.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping
    public String addEvent(Event event, Model model) {
        return eventService.addNewEvent(event, model);
    }

    @PostMapping("/eventDetail")
    public String getEventById(@RequestParam("id") int id, Model model) {
        return eventService.eventById(id, model);
    }

    @GetMapping("/events")
    public String getEvents(Model model) {
        return eventService.allEventsTable(model);
    }

    @GetMapping("/updateForm")
    public String updateForm(@RequestParam("id") int id, Model model) {
        return eventService.showUpdateForm(id, model);
    }

    @PostMapping("/update")
    public String updateEvent(@ModelAttribute("event") Event theEvent) {
        return eventService.updateEventToDb(theEvent);
    }

}
