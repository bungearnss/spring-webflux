package com.spring.webflux_playground.controller;

import com.spring.webflux_playground.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("reactive")
public class ReactiveController {

    @Value("${external.service.url}")
    private String externalUrl;

    private static final Logger log = LoggerFactory.getLogger(ReactiveController.class);
    private final WebClient webClient = WebClient.builder().build();

    @GetMapping("products")
    public Flux<Product> getProducts() {
        return this.webClient.get()
                .uri(externalUrl + "/demo01/products")
                .retrieve()
                .bodyToFlux(Product.class)
                .doOnNext(p -> log.info("FLUX received products: {}", p));
    }

    @GetMapping("products/notorious")
    public Flux<Product> getProductsNotorious() {
        return this.webClient.get()
                .uri(externalUrl + "/demo01/products/notorious")
                .retrieve()
                .bodyToFlux(Product.class)
                .onErrorComplete()
                .doOnNext(p -> log.info("FLUX received products notorious: {}", p));
    }

    @GetMapping(value = "products/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Product> getProductsStream() {
        return this.webClient.get()
                .uri(externalUrl + "/demo01/products")
                .retrieve()
                .bodyToFlux(Product.class)
                .doOnNext(p -> log.info("received products stream: {}", p));
    }
}
