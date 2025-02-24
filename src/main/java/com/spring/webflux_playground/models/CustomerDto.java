package com.spring.webflux_playground.models;

public record CustomerDto(Integer id,
                          String name,
                          String email) {
}
