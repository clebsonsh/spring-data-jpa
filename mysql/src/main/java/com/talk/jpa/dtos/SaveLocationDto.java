package com.talk.jpa.dtos;

public record SaveLocationDto(
        String name,
        String address,
        int capacity
) {
}
