package com.example.restservice.controller;

import com.example.restservice.entity.Customer;
import com.example.restservice.model.CustomerCreationRequest;
import com.example.restservice.model.Greeting;
import com.example.restservice.service.CustomerService;
import com.example.restservice.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("v1/save")
    public void persist(@RequestBody List<CustomerCreationRequest> customerCreationRequests) {
        customerCreationRequests
                .forEach(it -> customerService.saveCustomerDetails(it.firstName(), it.lastName()));
    }

    @GetMapping("v1/all")
    public List<Customer> getAllCustomers() {
        return customerService.findAllCustomers();
    }

    @GetMapping("v1")
    public Optional<Customer> getCustomer(@RequestParam(value = "id", defaultValue = "") String id,
                                          @RequestParam(value = "lastName", defaultValue = "") String lastName) {
        if (!id.isBlank())
            return customerService.findById(Long.valueOf(id));
        else
            return customerService.findByLastName(lastName);
    }
}
