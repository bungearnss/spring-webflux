package com.spring.webflux_playground.service;

import com.spring.webflux_playground.models.ProductDto;
import com.spring.webflux_playground.models.mapper.EntityDtoMapper;
import com.spring.webflux_playground.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private Sinks.Many<ProductDto> sink;

    public Mono<ProductDto> saveProduct(Mono<ProductDto> mono) {
        return mono.map(EntityDtoMapper::toProductEntity)
                .flatMap(this.productRepository::save)
                .map(EntityDtoMapper::toProductDto)
                .doOnNext(this.sink::tryEmitNext);
    }

    public Flux<ProductDto> productStream() {
        return this.sink.asFlux();
    }
}
