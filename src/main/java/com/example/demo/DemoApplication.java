package com.example.demo;

import com.example.demo.customer.Customer;
import com.example.demo.customer.CustomerRepo;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


@ComponentScan(basePackages = "com.example")
@EnableAutoConfiguration
@Configuration
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepo customerRepo) {

        return args -> {
            Faker faker = new Faker();
            List<Customer> customers = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                customers.add(new Customer(
                        faker.name().firstName(),
                        faker.name().lastName())
                );
            }
            customerRepo.saveAll(customers);
        };
    }

}

