package com.tj.edu.practice3.spring_exception.controller;

import com.tj.edu.practice3.spring_exception.dto.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@Validated
public class ApiController {

    @GetMapping("/user")
    public User user(
            @Size(min = 2) @RequestParam String name,
            @RequestParam int age
    ) {
        double a = 1 / 0;

        User user = null;
        user.setName(name);
        user.setAge(age);

        return user;
    }

    @PostMapping("/user")
    public ResponseEntity user(@Valid @RequestBody User user) {
        System.out.println(user);
        return ResponseEntity.ok(user);
    }
}
