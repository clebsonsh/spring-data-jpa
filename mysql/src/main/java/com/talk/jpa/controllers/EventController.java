package com.talk.jpa.controllers;

import com.talk.jpa.dtos.SaveEventDto;
import com.talk.jpa.entities.Event;
import com.talk.jpa.services.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAll() {
        return ResponseEntity.ok(eventService.getAll());
    }

    @PostMapping
    public ResponseEntity<Event> save(@RequestBody SaveEventDto input) {
        return ResponseEntity.status(HttpStatus.CREATED).body(eventService.save(input));
    }
}
