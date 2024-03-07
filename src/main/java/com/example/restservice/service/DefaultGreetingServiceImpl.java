package com.example.restservice.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class DefaultGreetingServiceImpl implements GreetingService {
    private static final String template = "Hello, %s!";

    @Override
    public String greet(String name) {
        return String.format(template, name);
    }
}
