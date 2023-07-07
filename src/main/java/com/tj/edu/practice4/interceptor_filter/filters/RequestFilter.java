package com.tj.edu.practice4.interceptor_filter.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(urlPatterns = { "/api/user/*", "/api/cart" })
public class RequestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter 시작-----------------------");

        chain.doFilter(request, response);

        System.out.println("doFilter 마침-----------------------");
    }
}
