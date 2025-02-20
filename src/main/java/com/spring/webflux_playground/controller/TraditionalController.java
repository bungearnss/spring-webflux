package com.spring.webflux_playground.controller;

import com.spring.webflux_playground.models.ProductRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@RequestMapping("traditional")
public class TraditionalController {

    @Value("${external.service.url}")
    private String externalUrl;

    private static final Logger log = LoggerFactory.getLogger(TraditionalController.class);
    private final RestClient restClient = RestClient.builder()
            .requestFactory(new JdkClientHttpRequestFactory())
            .build();

    @GetMapping("products")
    public List<ProductRecord> getProducts() {
        List<ProductRecord> productRecordList = this.restClient.get()
                .uri(externalUrl + "/demo01/products")
                .retrieve()
                .body(new ParameterizedTypeReference<List<ProductRecord>>() {
                });
        log.info("TRAD received products: {}", productRecordList);
        return productRecordList;
    }

    @GetMapping("products/notorious")
    public List<ProductRecord> getProductsNotorious() {
        List<ProductRecord> productRecordList = this.restClient.get()
                .uri(externalUrl + "/demo01/products/notorious")
                .retrieve()
                .body(new ParameterizedTypeReference<List<ProductRecord>>() {
                });
        log.info("TRAD received products notorious: {}", productRecordList);
        return productRecordList;
    }
}
