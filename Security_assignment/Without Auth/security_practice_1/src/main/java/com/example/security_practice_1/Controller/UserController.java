package com.example.security_practice_1.Controller;

import com.example.security_practice_1.Entity.User;
import com.example.security_practice_1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableMethodSecurity(securedEnabled = true)
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping("/hello")
    @Secured("ROLE_ADMIN")
    public String hello_msg(){
        return "hello";
    }
    @GetMapping("/hi")
    @Secured("ROLE_USER")
    public String hi_msg(){
        return "hi";
    }
    @PostMapping("/save/user")
    public User SaveUser(@RequestBody User user){
        System.out.println("controller");
        return userService.saveUser(user);
    }
}
