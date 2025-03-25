package com.jaya.springMVC_learning.repositories;

import com.jaya.springMVC_learning.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    List<Event> findAllByOrderByDateAsc();
}
