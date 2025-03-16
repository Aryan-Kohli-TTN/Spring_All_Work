package com.example.JPA_3_ASSIGNMENT.ManyToMany;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository  extends JpaRepository<Author,Long> {
}
