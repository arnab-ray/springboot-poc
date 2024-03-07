package com.example.restservice.controller;

import com.example.restservice.model.Greeting;
import com.example.restservice.service.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private final GreetingService greetingService;
    private final AtomicLong counter = new AtomicLong();

    public GreetingController(@Qualifier("custom") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), greetingService.greet(name));
    }
}
