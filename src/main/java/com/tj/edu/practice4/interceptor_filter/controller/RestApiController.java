package com.tj.edu.practice4.interceptor_filter.controller;

import com.tj.edu.practice4.interceptor_filter.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {
    @GetMapping("/user/{id}")
    public String user(@PathVariable String id, @RequestParam(required = false, defaultValue = "김복순") String name) {
        System.out.println("id: " + id);
        System.out.println("name: " + name);
        return id + " " + name;
    }

    @PostMapping("/user")
    public User registUser(User user) {
        System.out.println("id: " + user.getId());
        System.out.println("name: " + user.getName());

        return user;
    }

    @PutMapping("/user")
    public User updateUser(User user) {
        return user;
    }
}
