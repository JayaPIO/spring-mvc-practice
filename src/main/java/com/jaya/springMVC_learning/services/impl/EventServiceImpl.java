package com.jaya.springMVC_learning.services.impl;

import com.jaya.springMVC_learning.constants.ViewConstant;
import com.jaya.springMVC_learning.exception.CustomException;
import com.jaya.springMVC_learning.models.Event;
import com.jaya.springMVC_learning.repositories.EventRepository;
import com.jaya.springMVC_learning.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository eventRepository;

    /**
     * method for adding new event into DB
     *
     * @param event
     * @param model
     * @return String shows added event details in a table
     */
    @Override
    @Secured("ROLE_MANAGER")
    public String addNewEvent(Event event, Model model) {

        model.addAttribute("event", event);
        eventRepository.save(event);
        return ViewConstant.EVENT_DETAILS;
    }

    /**
     * finding an event by id
     *
     * @param id
     * @param model
     * @return
     */
    @Override
    public String eventById(int id, Model model) {
        Optional<Event> eventOptional = eventRepository.findById(id);
        if (eventOptional.isPresent()) {
            Event getEvent = eventOptional.get();
            model.addAttribute("event", getEvent);
            return ViewConstant.EVENT_DETAILS;
        } else {
            throw new CustomException(HttpStatus.NOT_FOUND, "Event Not Found With Given" + id);
        }
    }

    /**
     * Fetch event list from the DB
     *
     * @param model
     * @return HTML page
     */
    @Override
    public String allEventsTable(Model model) {
        List<Event> allEvents = eventRepository.findAllByOrderByDateAsc();
        model.addAttribute("events", allEvents);
        return ViewConstant.EVENT_LIST_PAGE;
    }

    /**
     * pre-populated update form page
     *
     * @param eventId
     * @param model
     * @return String view_page or error
     */
    @Override
    @PreAuthorize("hasRole(T(com.jaya.springMVC_learning.constants.Roles).ADMIN)")
    public String showUpdateForm(int eventId, Model model) {
        // get the event from the db
        Optional<Event> eventOptional = eventRepository.findById(eventId);
        if (eventOptional.isPresent()) {
            Event getEvent = eventOptional.get();
            // set event as a model attribute to prepopulate the form
            model.addAttribute("event", getEvent);
            //send over to our form
            return ViewConstant.EVENT_UPDATE_PAGE;
        } else {
            throw new CustomException(HttpStatus.NOT_FOUND, "Event Not Found With Given" + eventId);
        }
    }

    /**
     * updating the updated into DB
     *
     * @param theEvent
     * @return String view page showing updated event
     */
    @Override
    public String updateEventToDb(Event theEvent) {
        eventRepository.save(theEvent);
        return ViewConstant.EVENT_DETAILS;
    }

    /**
     * method for deleting an event
     *
     * @param id
     * @param model
     * @return redirect to events list
     */
    @Override
    @PreAuthorize("hasRole(T(com.jaya.springMVC_learning.constants.Roles).MANAGER) or hasRole(T(com.jaya.springMVC_learning.constants.Roles).ADMIN)")
    public String deleteEventById(int id, Model model) {
        eventRepository.deleteById(id);
        //redirect to all list
        return ViewConstant.REDIRECT_TO_EVENTS;
    }

}
