package com.example.JPA_3_ASSIGNMENT.OneToMany;

import com.example.JPA_3_ASSIGNMENT.Address;
import com.example.JPA_3_ASSIGNMENT.ManyToMany.Book;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Author_2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Embedded
    Address address;
    List<String> subjects;

    // asumming one author can have many books
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    List<Book_2> books;
    public Author_2(){}
    public Author_2(Address address, List<String> subjects, List<Book_2> books) {
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

    public void add_books(Book_2 book){
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

    public List<Book_2> getBooks() {
        return books;
    }

    public void setBooks(List<Book_2> books) {
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
