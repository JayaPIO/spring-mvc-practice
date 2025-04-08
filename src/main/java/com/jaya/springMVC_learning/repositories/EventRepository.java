package com.jaya.springMVC_learning.repositories;

import com.jaya.springMVC_learning.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EventRepository extends JpaRepository<Event, Integer> {
    List<Event> findAllByOrderByDateAsc();
}
