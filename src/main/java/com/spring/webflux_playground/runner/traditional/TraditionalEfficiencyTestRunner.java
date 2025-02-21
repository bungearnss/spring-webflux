package com.spring.webflux_playground.runner.traditional;

import com.spring.webflux_playground.models.entity.Customer;
import com.spring.webflux_playground.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("nft")
public class TraditionalEfficiencyTestRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(TraditionalEfficiencyTestRunner.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(String... args) {
        log.info("TraditionalEfficiencyTestRunner starting");
        var list = this.customerRepository.findAll();
        list.count()
                .subscribe(size -> log.info("list size: {}", size));
    }
}
