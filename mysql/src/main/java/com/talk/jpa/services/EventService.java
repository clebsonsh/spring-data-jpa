package com.talk.jpa.services;

import com.talk.jpa.dtos.SaveEventDto;
import com.talk.jpa.entities.Attendee;
import com.talk.jpa.entities.Event;
import com.talk.jpa.entities.Location;
import com.talk.jpa.repositories.EventRepository;
import com.talk.jpa.repositories.AttendeeRepository;
import com.talk.jpa.repositories.LocationRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final AttendeeRepository attendeeRepository;
    private final LocationRepository locationRepository;

    public EventService(
            EventRepository eventRepository,
            AttendeeRepository attendeeRepository,
            LocationRepository locationRepository
    ) {
        this.eventRepository = eventRepository;
        this.attendeeRepository = attendeeRepository;
        this.locationRepository = locationRepository;
    }

    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    @Transactional
    public Event save(SaveEventDto input) {
        var event = new Event();
        Set<Attendee> attendees = new HashSet<>(
                attendeeRepository.findAllById(input.attendees())
        );
        var location = new Location();

        event.setName(input.name());
        event.setDate(input.date());
        event.setAttendees(attendees);

        event = eventRepository.save(event);

        location.setName(input.location().name());
        location.setAddress(input.location().address());
        location.setCapacity(input.location().capacity());
        location.setEvent(event);
        location = locationRepository.save(location);

        event.setLocation(location);

        return event;
    }
}
