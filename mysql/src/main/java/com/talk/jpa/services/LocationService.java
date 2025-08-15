package com.talk.jpa.services;

import com.talk.jpa.dtos.SaveLocationDto;
import com.talk.jpa.dtos.UpdateLocationDto;
import com.talk.jpa.entities.Location;
import com.talk.jpa.repositories.LocationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationService(final LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getAll() {
        return locationRepository.findAll();
    }

    public Location get(UUID id) {
        return locationRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Location not found"));
    }

    public Location save(SaveLocationDto input) {
        var location = new Location();

        location.setName(input.name());
        location.setAddress(input.address());
        location.setCapacity(input.capacity());

        return locationRepository.save(location);
    }

    public void update(UpdateLocationDto input) {
        var location = locationRepository
                .findById(input.id())
                .orElseThrow(() -> new EntityNotFoundException("Location not found"));

        location.setName(input.name());
        location.setAddress(input.address());
        location.setCapacity(input.capacity());

        locationRepository.save(location);
    }

    public void delete(UUID id) {
        var location = locationRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Location not found"));
        locationRepository.delete(location);
    }
}
