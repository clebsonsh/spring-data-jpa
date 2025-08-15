package com.talk.jpa.dtos;

import java.util.UUID;

public record UpdateLocationDto(
        UUID id,
        String name,
        String address,
        int capacity
) {
}
