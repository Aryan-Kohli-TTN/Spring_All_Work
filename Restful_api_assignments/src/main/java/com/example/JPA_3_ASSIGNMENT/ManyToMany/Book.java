package com.example.JPA_3_ASSIGNMENT.ManyToMany;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String bookname;

    @ManyToMany(mappedBy = "books")
    List<Author> authorList;
    public Book(){}
    public Book(String bookname) {
        this.bookname = bookname;
    }
    public void add_author(Author author){
        if(authorList==null)
            authorList=new ArrayList<>();
        authorList.add(author);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
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
