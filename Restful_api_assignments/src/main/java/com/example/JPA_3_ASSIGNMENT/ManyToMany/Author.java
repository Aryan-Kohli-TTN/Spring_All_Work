package com.example.JPA_3_ASSIGNMENT.ManyToMany;

import com.example.JPA_3_ASSIGNMENT.Address;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Embedded
    Address address;
    List<String> subjects;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Authors_and_books" ,joinColumns = @JoinColumn(name = "author_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "book_id",referencedColumnName = "id"))
    List<Book> books;
    public Author(){}
    public Author(Address address, List<String> subjects, List<Book> books) {
        this.address = address;
        this.subjects = subjects;
        this.books = books;
    }
    @PrePersist
    public void add_subjects(){
        subjects=new ArrayList<>();
        subjects.add("C++");
        subjects.add("JAVA");
        subjects.add("PYTHON");
    }

    public void add_books(Book book){
        if(books==null)
            books=new ArrayList<>();
        books.add(book);
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
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
