package com.example.JPA_3_ASSIGNMENT.OnetoOne;

import com.example.JPA_3_ASSIGNMENT.Address;
import com.example.JPA_3_ASSIGNMENT.OneToMany.Book_2;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Author_3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Embedded
    Address address;
    List<String> subjects;

    // asumming one author can have one book
    @OneToOne(mappedBy = "author")
    Book_3 book;
    public Author_3(){}
    public Author_3(Address address, List<String> subjects, Book_3 books) {
        this.address = address;
        this.subjects = subjects;
        this.book = books;
    }
    @PrePersist
    public void add_subjects(){
        subjects=new ArrayList<>();
        subjects.add("C++");
        subjects.add("JAVA");
        subjects.add("PYTHON");
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public Book_3    getBook() {
        return book;
    }

    public void setBooks(Book_3 book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", address=" + address +
                ", subjects=" + subjects +
                '}';
    }
}
