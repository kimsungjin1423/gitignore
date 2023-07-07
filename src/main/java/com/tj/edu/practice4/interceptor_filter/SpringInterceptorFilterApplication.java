package com.tj.edu.practice4.interceptor_filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SpringInterceptorFilterApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringInterceptorFilterApplication.class, args);
    }
}
