package com.example.demo.customer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
 public class CustomerController {
    private final CustomerService customerService;

    CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> index() {
        return customerService.getCustomers();
    }

    @GetMapping(value = "/{id}/")
    public Optional<Customer> getCustomer(@PathVariable("id") int id) {
        return  customerService.getCustomerById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody CustomerRegRequest customer) {
        this.customerService.saveCustomer(customer);
    }

    @DeleteMapping(value = "/{id}/")
    public boolean delete(@PathVariable("id") int id) {
        return customerService.deleteById(id);
    }

    @PutMapping(value = "/{id}/")
    public Optional<Customer> update(
            @PathVariable("id") int id,
            @RequestBody CustomerPutRequest customerPutRequest) {
        Optional<Customer> optionalCustomer = customerService.getCustomerById(id);
        Customer customer = optionalCustomer.get();
        customer.setEmail(customerPutRequest.email());
        customer.setName(customerPutRequest.name());
        customerService.updateCustomer(customer);
        return customerService.getCustomerById(id);
    }
}
