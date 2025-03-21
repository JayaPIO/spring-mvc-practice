package com.jaya.springMVC_learning.services;

import com.jaya.springMVC_learning.models.Event;
import org.springframework.ui.Model;

public interface EventService {

    String addNewEvent(Event event, Model model);

    String eventById(int id, Model model);
}
