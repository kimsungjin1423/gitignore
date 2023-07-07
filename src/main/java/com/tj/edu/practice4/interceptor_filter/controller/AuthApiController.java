package com.tj.edu.practice4.interceptor_filter.controller;


import com.tj.edu.practice4.interceptor_filter.annotations.AuthUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authapi")
@AuthUser
public class AuthApiController {
    @GetMapping("/get")
    public String get(){
        return "authapi/get호출";
    }
}
