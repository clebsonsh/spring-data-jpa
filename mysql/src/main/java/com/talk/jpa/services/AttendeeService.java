package com.talk.jpa.services;

import com.talk.jpa.dtos.SaveAttendeeDto;
import com.talk.jpa.dtos.UpdateAttendeeDto;
import com.talk.jpa.entities.Attendee;
import com.talk.jpa.repositories.AttendeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AttendeeService {
    private final AttendeeRepository attendeeRepository;

    public AttendeeService(AttendeeRepository attendeeRepository) {
        this.attendeeRepository = attendeeRepository;
    }

    public Attendee save(SaveAttendeeDto input) {
        var attendee = new Attendee();

        attendee.setName(input.name());
        attendee.setEmail(input.email());

        return attendeeRepository.save(attendee);
    }

    public void update(UpdateAttendeeDto input) {
        var attendee = attendeeRepository
                .findById(input.id())
                .orElseThrow(() -> new EntityNotFoundException("Attendee not found"));

        attendee.setName(input.name());
        attendee.setEmail(input.email());

        attendeeRepository.save(attendee);
    }

    public void delete(UUID id) {
        var attendee = attendeeRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Attendee not found"));

        attendeeRepository.delete(attendee);
    }

    public Attendee get(UUID id) {
        return attendeeRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Attendee not found"));
    }

    public List<Attendee> getAll() {
        return attendeeRepository.findAll();
    }
}
