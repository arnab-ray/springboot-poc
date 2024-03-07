package com.example.restservice.service;

import org.springframework.stereotype.Component;

@Component("custom")
public class CustomGreetingServiceImpl implements GreetingService {
    private static final String template = "I am unable to greet, %s!";

    @Override
    public String greet(String name) {
        return String.format(template, name);
    }
}
