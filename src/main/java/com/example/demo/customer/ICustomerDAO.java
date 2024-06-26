package com.example.demo.customer;

import java.util.List;
import java.util.Optional;

interface ICustomerDAO {
    Optional<Customer> getCustomer(int id);
    Optional<Customer> getCustomerById(int id);
    boolean getCustomerByEmail(String email);
    void saveCustomer(Customer customer);
    List<Customer> getCustomers();
    boolean deleteCustomerById(int id);
    void updateCustomer(Customer customer);
}


