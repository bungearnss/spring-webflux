package com.spring.webflux_playground.models;

public record ProductDto(Integer id,
                         String description,
                         Integer price) {
}
