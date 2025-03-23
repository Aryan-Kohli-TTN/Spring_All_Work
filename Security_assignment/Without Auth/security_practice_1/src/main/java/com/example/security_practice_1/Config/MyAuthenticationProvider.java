package com.example.security_practice_1.Config;

import com.example.security_practice_1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        System.out.println("here");
        UserDetails user = userService.loadUserByUsername(username);
        System.out.println(user.getAuthorities());
        if(username.equals(user.getUsername()) && passwordEncoder.matches(password,user.getPassword())){
            System.out.println("here in authenticate of MyAuthenticationProvider");
            return new UsernamePasswordAuthenticationToken(username,password,user.getAuthorities());
        }
        else {
            throw new UsernameNotFoundException("USER NHI MILA");
        }
    }
    @Override
    public boolean supports(Class<?> authentication){
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
