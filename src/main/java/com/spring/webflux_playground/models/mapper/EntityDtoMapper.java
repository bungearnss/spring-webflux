package com.spring.webflux_playground.models.mapper;

import com.spring.webflux_playground.models.CustomerDto;
import com.spring.webflux_playground.models.ProductDto;
import com.spring.webflux_playground.models.entity.Customer;
import com.spring.webflux_playground.models.entity.Product;

public class EntityDtoMapper {

    public static Customer toCustomerEntity(CustomerDto dto) {
        Customer customer = new Customer();
        customer.setName(dto.name());
        customer.setEmail(dto.email());
        customer.setId(dto.id());
        return customer;
    }

    public static CustomerDto toCustomerDto(Customer customer) {
        return new CustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getEmail()
        );
    }

    public static Product toProductEntity(ProductDto dto) {
        var product = new Product();
        product.setId(dto.id());
        product.setDescription(dto.description());
        product.setPrice(dto.price());
        return product;
    }

    public static ProductDto toProductDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getDescription(),
                product.getPrice()
        );
    }
}
