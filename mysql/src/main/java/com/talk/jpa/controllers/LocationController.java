package com.talk.jpa.controllers;

import com.talk.jpa.dtos.SaveLocationDto;
import com.talk.jpa.dtos.UpdateLocationDto;
import com.talk.jpa.entities.Location;
import com.talk.jpa.services.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/location")
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public ResponseEntity<List<Location>> getAll() {
        return ResponseEntity.ok(locationService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> get(@PathVariable UUID id) {
        return ResponseEntity.ok(locationService.get(id));
    }

    @PostMapping
    public ResponseEntity<Location> saveLocation(@RequestBody SaveLocationDto input) {
        return ResponseEntity.status(HttpStatus.CREATED).body(locationService.save(input));
    }

    @PutMapping
    public ResponseEntity<Void> updateLocation(@RequestBody UpdateLocationDto input) {
        locationService.update(input);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable UUID id) {
        locationService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
