package com.talk.jpa.controllers;

import com.talk.jpa.dtos.SaveAttendeeDto;
import com.talk.jpa.dtos.UpdateAttendeeDto;
import com.talk.jpa.entities.Attendee;
import com.talk.jpa.services.AttendeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/attendee")
public class AttendeeController {
    private final AttendeeService attendeeService;

    public AttendeeController(AttendeeService attendeeService) {
        this.attendeeService = attendeeService;
    }

    @GetMapping
    public ResponseEntity<List<Attendee>> getAll() {
        return ResponseEntity.ok(attendeeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attendee> get(@PathVariable UUID id) {
        return ResponseEntity.ok(attendeeService.get(id));
    }

    @PostMapping
    public ResponseEntity<Attendee> save(@RequestBody SaveAttendeeDto input) {
        return ResponseEntity.status(HttpStatus.CREATED).body(attendeeService.save(input));
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody UpdateAttendeeDto input) {
        attendeeService.update(input);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        attendeeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
