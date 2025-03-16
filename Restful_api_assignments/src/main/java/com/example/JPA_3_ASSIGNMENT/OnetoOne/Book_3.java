package com.example.JPA_3_ASSIGNMENT.OnetoOne;

import com.example.JPA_3_ASSIGNMENT.OnetoOne.Author_3;
import jakarta.persistence.*;

@Entity
public class Book_3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String bookname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    Author_3 author;
    public Book_3(){}
    public Book_3(String bookname) {
        this.bookname = bookname;
    }

    public Long getId() {
        return id;
    }

    public Author_3 getAuthor() {
        return author;
    }

    public void setAuthor(Author_3 author) {
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
