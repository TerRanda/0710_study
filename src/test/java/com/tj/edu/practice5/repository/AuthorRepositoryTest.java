package com.tj.edu.practice5.repository;

import com.tj.edu.practice5.model.Author;
import com.tj.edu.practice5.model.Book;
import com.tj.edu.practice5.model.Publisher;
import jakarta.transaction.Transactional;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class AuthorRepositoryTest {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    @Test
    @Transactional
    void manyToManyTest() {
        Book book1 = givenBook("아지르로 할 수 있는 100가지");
        Book book2 = givenBook("승리를 위한 원딜 지키는 방법 10선");
        Book book3 = givenBook("원딜로 숟가락이 아닌 밥상 차리는 방법");
        Book book4 = givenBook("SPRING BOOT 마스터");

        Author author1 = givenAuthor("이상혁");
        Author author2 = givenAuthor("류민석");
        Author author3 = givenAuthor("이민형");

        book1.setAuthors(Lists.newArrayList(author1));
        book2.setAuthors(Lists.newArrayList(author2));
        book3.setAuthors(Lists.newArrayList(author3));
        book4.setAuthors(Lists.newArrayList(author1, author2, author3));

        author1.setBooks(Lists.newArrayList(book1, book4));
        author2.setBooks(Lists.newArrayList(book2, book4));
        author3.setBooks(Lists.newArrayList(book3, book4));

        bookRepository.saveAll(Lists.newArrayList(book1, book2, book3, book4));
        authorRepository.saveAll(Lists.newArrayList(author1, author2, author3));

        System.out.println("book 기준 >>> " + bookRepository.findAll().get(2).getAuthors());
        System.out.println("author 기준 >>> " + authorRepository.findAll().get(2).getBooks());

    }
    private Book givenBook(String name) {
        Book book = Book.builder()
                .name(name)
                .build();

        return bookRepository.save(book);
    }
    private Author givenAuthor(String name) {
        Author author = Author.builder()
                .name(name)
                .build();
        return authorRepository.save(author);
    }
}