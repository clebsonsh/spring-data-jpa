package com.talk.jpa.dtos;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public record UpdateEventDto(
        UUID id,
        String name,
        LocalDateTime date,
        Set<UUID> attendees,
        SaveLocationDto location
) {
}
