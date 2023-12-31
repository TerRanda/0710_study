package com.tj.edu.practice5.repository;

import com.tj.edu.practice5.model.Book;
import com.tj.edu.practice5.model.BookReviewInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BookReviewInfoRepositoryTest {
    @Autowired
    private BookReviewInfoRepository bookReviewInfoRepository;
    @Autowired
    private BookRepository bookRepository;

    //    @BeforeAll
    @BeforeEach
    void setUp() {
    }

    @Test
    void crudTest1() {

    }
    @Test
    void crudTest2() {
        Book book = getGivenBook();
        BookReviewInfo bookReviewInfo = getGivenBookReviewInfo(book);

        List<BookReviewInfo> bookReviewInfoList = bookReviewInfoRepository.findAll();
        bookReviewInfoList.forEach(System.out::println);

//        Book book2 = bookRepository.findById(bookReviewInfoList.get(0).getBookId()).orElseThrow(RuntimeException::new);
//        System.out.println(">>> book2: " + book2);
    }

    @Test
    void oneToOneTest1() {
        Book book = getGivenBook();
        BookReviewInfo bookReviewInfo = getGivenBookReviewInfo(book);

//        bookReviewInfoRepository.findAll();
        bookReviewInfoRepository.findById(1L);
    }
    @Test
    void oneToOneTest2() {
        Book book = getGivenBook();
        BookReviewInfo bookReviewInfo = getGivenBookReviewInfo(book);

//        bookReviewInfoRepository.findAll();
        bookRepository.findById(1L);
    }
    private Book getGivenBook() {
        Book book = Book.builder()
                .name("아주 쉬운 스프링 부트3.1")
//                .author("저자1")
                .build();
        return bookRepository.save(book);
    }
    private BookReviewInfo getGivenBookReviewInfo(Book book) {
//        Book book = getGivenBook();
        BookReviewInfo bookReviewInfo = BookReviewInfo.builder()
                .book(book)
                .avgReviewScore(2.3f)
                .reviewCount(8)
                .build();

        return bookReviewInfoRepository.save(bookReviewInfo);
    }
    @AfterEach
    void tearDown() {
    }
//    @AfterAll
}