package com.tj.edu.practice4.aop.controller;


import com.tj.edu.practice4.aop.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {
    @GetMapping("/user/{id}")
    public String user(@PathVariable String id, @RequestParam String name) {
        return "";
    }

    @PostMapping("/user")
    public User user(User user) {

    }
}
