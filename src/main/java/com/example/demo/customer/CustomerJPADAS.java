package com.example.demo.customer;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jpa")
public class CustomerJPADAS implements ICustomerDAO{
    private final CustomerRepo customerRepo;

    public CustomerJPADAS(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }
    @Override
    public Optional<Customer> getCustomer(int id) {
        return customerRepo.findById(id);
    }

    @Override
    public Optional<Customer> getCustomerById(int id) {
        return customerRepo.findById(id);
    }

    @Override
    public boolean getCustomerByEmail(String email) {
        return customerRepo.existsByEmail(email);
    }

    @Override
    public void saveCustomer(Customer customer) {
        this.customerRepo.save(customer);
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public boolean deleteCustomerById(int id) {
        customerRepo.deleteById(id);
        return !this.customerRepo.existsById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        this.customerRepo.save(customer);
    }

}
