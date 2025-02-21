package com.spring.webflux_playground.runner.reactive;

import com.spring.webflux_playground.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
@Profile("nft")
public class ReactiveEfficiencyTestRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(ReactiveEfficiencyTestRunner.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(String... args) {
        var atomicInteger = new AtomicInteger(0);
        log.info("ReactiveEfficiencyTestRunner starting");
        this.customerRepository.findAll()
                .doOnNext(c -> {
                    // for every customer, increment
                    // print for every million
                    var count = atomicInteger.incrementAndGet();
                    if (count % 1_000_000 == 0) {
                        log.info("{}", count);
                    }
                })
                .then()
                .block();
        log.info("ReactiveEfficiencyTestRunner done");
    }
}
