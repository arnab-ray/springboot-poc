package com.example.restservice.service;

import com.example.restservice.entity.Customer;
import com.example.restservice.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Component
public class CustomerService {
    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void saveCustomerDetails(String firstName, String lastName) {
        if (!(firstName.isBlank() && lastName.isBlank()))
            customerRepository.save(new Customer(firstName, lastName));
    }

    public List<Customer> findAllCustomers() {
        log.info("Customers found with findAll():");
        log.info("-------------------------------");
        List<Customer> result = new LinkedList<>();
        customerRepository.findAll().forEach(customer -> {
            log.info(customer.toString());
            result.add(customer);
        });
        return result;
    }

    public Optional<Customer> findById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        log.info("Customer found with findById(" + id + "):");
        log.info("--------------------------------");
        log.info(customer.toString());
        log.info("");

        return customer;
    }

    public Optional<Customer> findByLastName(String lastName) {
        log.info("Customer found with findByLastName" + "('" + lastName + "'):");
        log.info("--------------------------------------------");
        return customerRepository.findByLastName(lastName).stream().findFirst();
    }
}
