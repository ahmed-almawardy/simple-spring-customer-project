package com.example.demo.customer;

import com.example.demo.customer.exceptions.ResourceAlreadyExists;
import com.example.demo.customer.exceptions.ResourceNotFound;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

interface ICustomerService {
    Customer getCustomer(int customerId);
    Optional<Customer> getCustomerById(int customerId);
    void saveCustomer(CustomerRegRequest customer);
    List<Customer> getCustomers();
    boolean deleteById(int customerId);
    void updateCustomer(Customer customer);
}

@Service
public class CustomerService implements ICustomerService {
    private final ICustomerDAO customerDAO;

    CustomerService(@Qualifier("jpa") ICustomerDAO customerDAO){
        this.customerDAO = customerDAO;
    }

    @Override
    public Customer getCustomer(int customerId) {
        Optional<Customer> customer = customerDAO.getCustomer(customerId);
        return customer.orElseGet(() -> customer.orElseThrow(() -> new ResourceNotFound("Customer not found")));
    }

    @Override
    public Optional<Customer> getCustomerById(int customerId) {
        return this.customerDAO.getCustomerById(customerId);
    }

    @Override
    public void saveCustomer(CustomerRegRequest customer) {
        boolean customerExisted = this.customerDAO.getCustomerByEmail(customer.email());
        if (customerExisted) {
            throw new ResourceAlreadyExists("Customer already exists");
        }
        this.customerDAO.saveCustomer(new Customer(customer.email(), customer.name()));
    }

    @Override
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    public boolean deleteById(int customerId) {
        return customerDAO.deleteCustomerById(customerId);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDAO.updateCustomer(customer);
    }
}
