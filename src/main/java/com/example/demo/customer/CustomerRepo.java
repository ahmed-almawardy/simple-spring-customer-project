package com.example.demo.customer;

import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepo extends JpaRepository<Customer, Integer> {
        boolean existsByEmail(String email);
}
