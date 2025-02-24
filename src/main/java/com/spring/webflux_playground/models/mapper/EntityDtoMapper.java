package com.spring.webflux_playground.models.mapper;

import com.spring.webflux_playground.models.CustomerDto;
import com.spring.webflux_playground.models.entity.Customer;

public class EntityDtoMapper {

    public static Customer toCustomerEntity(CustomerDto dto){
        Customer customer = new Customer();
        customer.setName(dto.name());
        customer.setEmail(dto.email());
        customer.setId(dto.id());
        return customer;
    }

    public static CustomerDto toCustomerDto(Customer customer){
        return new CustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getEmail()
        );
    }
}
