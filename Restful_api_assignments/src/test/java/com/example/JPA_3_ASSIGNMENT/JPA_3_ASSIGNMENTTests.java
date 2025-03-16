package com.example.JPA_3_ASSIGNMENT;

import com.example.JPA_3_ASSIGNMENT.ManyToMany.Author;
import com.example.JPA_3_ASSIGNMENT.ManyToMany.AuthorRepository;
import com.example.JPA_3_ASSIGNMENT.ManyToMany.Book;
import com.example.JPA_3_ASSIGNMENT.OneToMany.AuthorRepository_2;
import com.example.JPA_3_ASSIGNMENT.OneToMany.Author_2;
import com.example.JPA_3_ASSIGNMENT.OneToMany.Book_2;
import com.example.JPA_3_ASSIGNMENT.OnetoOne.Author_3;
import com.example.JPA_3_ASSIGNMENT.OnetoOne.BookRepository;
import com.example.JPA_3_ASSIGNMENT.OnetoOne.Book_3;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JPA_3_ASSIGNMENTTests {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    AuthorRepository_2 authorRepository2;

    @Autowired
    BookRepository bookRepository;
    @Test
    void add_author_many_to_many(){
        Author author = new Author();
        author.setAddress(new Address("street: 1","delhi","delhi"));

        Book b1 = new Book("book1");
        b1.add_author(author);
        Book b2 = new Book("book2");
        b2.add_author(author);
        Book b3 = new Book("book3");
        b3.add_author(author);

        author.add_books(b1);
        author.add_books(b2);
        author.add_books(b3);

        authorRepository.save(author);
    }

    @Test
    void add_author_one_to_many(){
        Author_2 author2 = new Author_2();
        author2.setAddress(new Address("street: 1","delhi","delhi"));

        Book_2 b1 = new Book_2();
        b1.setAuthor(author2);
        Book_2 b2 = new Book_2();
        b2.setAuthor(author2);

        author2.add_books(b1);
        author2.add_books(b2);

        authorRepository2.save(author2);
    }

    @Test
    public void add_book_one_to_one(){
        Book_3 book3 = new Book_3();
        book3.setBookname("book1");
        Author_3 author3 = new Author_3();
        author3.setAddress(new Address("street: 1","delhi","delhi"));
        book3.setAuthor(author3);
        bookRepository.save(book3);
    }
}
