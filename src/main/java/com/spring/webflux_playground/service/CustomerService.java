package com.spring.webflux_playground.service;

import com.spring.webflux_playground.models.CustomerDto;
import com.spring.webflux_playground.models.mapper.EntityDtoMapper;
import com.spring.webflux_playground.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Flux<CustomerDto> getAllCustomers() {
        return this.customerRepository.findAll().map(EntityDtoMapper::toCustomerDto);
    }

    public Flux<CustomerDto> getAllCustomers(Integer page, Integer size) {
        return this.customerRepository.findBy(PageRequest.of(page - 1, size))
                .map(EntityDtoMapper::toCustomerDto);
    }

    public Mono<CustomerDto> getCustomerById(Integer id) {
        return this.customerRepository.findById(id)
                .map(EntityDtoMapper::toCustomerDto);
    }

    public Mono<CustomerDto> saveCustomer(Mono<CustomerDto> mono) {
        return mono.map(EntityDtoMapper::toCustomerEntity)
                .flatMap(this.customerRepository::save)
                .map(EntityDtoMapper::toCustomerDto);
    }

    public Mono<CustomerDto> updateCustomer(Integer id, Mono<CustomerDto> mono) {
        return this.customerRepository.findById(id)
                .flatMap(entity -> mono)
                .map(EntityDtoMapper::toCustomerEntity)
                .doOnNext(c -> c.setId(id))
                .flatMap(this.customerRepository::save)
                .map(EntityDtoMapper::toCustomerDto);
    }

    public Mono<Boolean> deleteCustomerById(Integer id) {
        return this.customerRepository.deleteCustomerById(id);
    }

}
