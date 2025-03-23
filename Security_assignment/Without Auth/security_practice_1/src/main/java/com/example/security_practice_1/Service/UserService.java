package com.example.security_practice_1.Service;

import com.example.security_practice_1.Entity.Role;
import com.example.security_practice_1.Entity.User;
import com.example.security_practice_1.Repository.RoleRepository;
import com.example.security_practice_1.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.getRoles().forEach(role -> {
//            Role existingRole = roleRepository.findByRoleName(role.getRole_name())
//                    .orElseThrow(() -> new RuntimeException("Role not found"));
//            role.setId(existingRole.getId());
//        });
        return userRepository.save(user);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole_name()))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }
}
