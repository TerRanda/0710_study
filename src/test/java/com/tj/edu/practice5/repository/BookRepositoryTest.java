package com.tj.edu.practice5.repository;



import com.tj.edu.practice5.model.*;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookReviewInfoRepository bookReviewInfoRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Test
    void bookTest(){
        Book book = givenBook();
        bookRepository.findAll();
    }

    @Test
    @Transactional
    void relationTest1() {
        givenBookAndReview();

        Member member = memberRepository.findByEmail("faker13@t1esports.com");
        System.out.println(">>> member: " + member);

        Book book = member.getReviews().get(0).getBook();
        System.out.println(">>> book: " + book);

        Publisher publisher = book.getPublisher();
        System.out.println(">>> book: " + member.getReviews().get(0).getBook().getPublisher());
    }

    private Book givenBook(Publisher publisher) {
        Book book = Book.builder()
                .name("와아")
                .publisher(publisher)
                .build();

        return bookRepository.save(book);
    }
    private Book givenBook() {
        Book book = Book.builder()
                .name("야아아아")
                .build();

        return bookRepository.save(book);
    }

    private Publisher givenPublisher() {
        Publisher publisher = Publisher.builder()
                .name("T1이스포츠")
                .build();
        return publisherRepository.save(publisher);
    }
    private void givenBookAndReview() {
        givenReview(givenMember(), givenBook());
    }
    private Review givenReview(Member member, Book book) {
        Review review = Review.builder()
                .title("재밌는 SPRIGN BOOT")
                .member(member)
                .book(book)
                .build();
        return reviewRepository.save(review);
    }

    private Author givenAuthor() {
        Author author = Author.builder()
                .name("오오")
                .build();
        return authorRepository.save(author);
    }
    private Member givenMember() {
        return memberRepository.findByEmail("faker13@t1esports.com");
    }


//    @Test
//    void crudTest1(){
//        Book book = Book.builder()
//                .author("라이트닝커피")
//                .name("아인슈페너")
//                .build();
//
//        bookRepository.save(book);
//
//
//    }
}