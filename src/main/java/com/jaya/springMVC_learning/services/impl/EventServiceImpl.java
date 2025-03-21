package com.jaya.springMVC_learning.services.impl;

import com.jaya.springMVC_learning.exception.CustomException;
import com.jaya.springMVC_learning.models.Event;
import com.jaya.springMVC_learning.repositories.EventRepository;
import com.jaya.springMVC_learning.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository eventRepository;

    @Override
    public String addNewEvent(Event event, Model model) {

        model.addAttribute("event", event);
        eventRepository.save(event);
        return "eventTable.html";
    }

    @Override
    public String eventById(int id, Model model) {
        Optional<Event> eventOptional = eventRepository.findById(id);
        if (eventOptional.isPresent()) {
            Event getEvent = eventOptional.get();
            model.addAttribute("event", getEvent);
            return "eventDetails.html";
        } else {
            throw new CustomException(HttpStatus.NOT_FOUND,"Event Not Found With Given"+id);
        }
    }
}
