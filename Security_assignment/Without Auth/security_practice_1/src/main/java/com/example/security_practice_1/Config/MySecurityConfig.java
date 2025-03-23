package com.example.security_practice_1.Config;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.util.Arrays;

@Configuration
public class MySecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        System.out.println("Security Filter Chain");
        return http.csrf(csrf->csrf.disable()).httpBasic(Customizer.withDefaults())
                .addFilterBefore(new MysecurityFilter(), BasicAuthenticationFilter.class)
//                .authorizeHttpRequests(a->a.requestMatchers("/save/user")
//                        .permitAll().requestMatchers(HttpMethod.GET,"/hello").hasRole("ADMIN").requestMatchers(HttpMethod.GET,"/hi").hasRole("USER"))
                .build();
    }
//    @Bean
//    UserDetailsService userDetailsService(){
//        InMemoryUserDetailsManager  userDetailsManager = new InMemoryUserDetailsManager();
//        UserDetails user = User.withUsername("Aryan").password(getEncoder().encode("pp")).authorities(Arrays.asList()).build();
//        userDetailsManager.createUser(user);
//        return userDetailsManager;
//    }

    @Bean
    BCryptPasswordEncoder getEncoder(){
        return new BCryptPasswordEncoder();
    }
}
