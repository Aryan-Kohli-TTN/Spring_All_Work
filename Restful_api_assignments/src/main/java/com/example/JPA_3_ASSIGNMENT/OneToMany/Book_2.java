package com.example.JPA_3_ASSIGNMENT.OneToMany;

import com.example.JPA_3_ASSIGNMENT.ManyToMany.Author;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Book_2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String bookname;

    @ManyToOne
    @JoinColumn(name = "author_id")
    Author_2 author;
    public Book_2(){}
    public Book_2(String bookname) {
        this.bookname = bookname;
    }

    public Long getId() {
        return id;
    }

    public Author_2 getAuthor() {
        return author;
    }

    public void setAuthor(Author_2 author) {
        this.author = author;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookname='" + bookname + '\'' +
                '}';
    }
}
