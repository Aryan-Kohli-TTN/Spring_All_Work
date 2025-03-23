package com.example.security_practice_1.Repository;

import com.example.security_practice_1.Entity.Role;
import com.example.security_practice_1.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
