package com.tj.edu.practice4.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/helloworld")
    public String helloWorld() {
        return "hello-world";
    }
}
