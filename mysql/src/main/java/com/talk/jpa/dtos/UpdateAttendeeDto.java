package com.talk.jpa.dtos;

import java.util.UUID;

public record UpdateAttendeeDto(
        UUID id,
        String name,
        String email
) {
}
