package com.talk.jpa.repositories;

import com.talk.jpa.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {
    Event findEventByName(String name);

    List<Event> findEventsByDate(LocalDateTime date);
}
