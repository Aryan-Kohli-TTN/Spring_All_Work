package com.example.security_practice_1.Config;

import jakarta.servlet.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.AuthenticationFilter;

import java.io.IOException;

@Configuration
public class MysecurityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException{
        System.out.println("Before Operation in filter chain");
        filterChain.doFilter(request,response);
        System.out.println("After Operation in filter chain");
    }

}
