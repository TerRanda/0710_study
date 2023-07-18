package com.tj.edu.practice5.repository;



import com.tj.edu.practice5.model.*;
import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

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

    @Test
    void jpqlTest1() {
        List<Book> bookList = bookRepository.findByMyBooks("플옵에서 결승까지");
        bookList.forEach(System.out::println);


        List<Book> bookList2 = bookRepository.findByNameAndMyId("LCK에서 월즈까지", 3L);
        bookList2.forEach(System.out::println);

        List<Map<String, Object>> bookListMap1 = bookRepository.findIdAndNameByBooks("플옵에서 결승까지");
        bookListMap1.forEach(x -> System.out.println(x.entrySet()));
//        bookListMap1.forEach(x -> System.out.println(x.values()));

        List<Map<String, Object>> bookListMap2 = bookRepository.findByNamedNameByMyBooks("플옵에서 결승까지");
        bookListMap2.forEach(x -> System.out.println(x.entrySet()));
//        bookListMap1.forEach(x -> System.out.println(x.values()));
//
        List<Book> bookListMap3 = bookRepository.findByNameAndMyId2("플옵에서 결승까지", 2L);
        bookListMap3.forEach(System.out::println);

        List<Book> bookListMap4 = bookRepository.findByNameAndMyId3("까지", 3L);
        bookListMap4.forEach(System.out::println);

//
//        List<Book> bookList5 = bookRepository.findByNameAndMyId("아이언에서 챌린저까지", 1L);
//        bookList5.forEach(System.out::println);
    }

    @Test
    void nativeSqlTest() {
        List<Book> bookListByNative = bookRepository.findByNativeByMyBooks("아이언에서 챌린저까지");
        bookListByNative.forEach(System.out::println);

        System.out.println("-----------------------------------------------------------------------------");

        List<Book> bookListByNative2 = bookRepository.findByNativeNameByMyBooks("아이언에서 챌린저까지");
        bookListByNative2.forEach(System.out::println);System.out.println("-----------------------------------------------------------------------------");

        List<Book> bookListByNative3 = bookRepository.findByNativeNameByMyBooks2("아이언에서 챌린저까지");
        bookListByNative3.forEach(System.out::println);


    }

    @Test
    void bookAndIdTest() {
//        List<BookAndId> bookAndIdList = bookRepository.findBookAndIdByBooks("플옵에서 결승까지");
//        bookAndIdList.forEach(s -> System.out.println(s.getAbc() + " : " + s.getName2()));

        List<BookAndId> bookAndIdList = bookRepository.findBookAndIdByBooks2("플옵에서 결승까지");
        bookAndIdList.forEach(s -> System.out.println(s.getNum() + " : " + s.getBookName()));
//
//        List<Tuple> bookAndIdList2 = bookRepository.findTupleByBooks("플옵에서 결승까지");
//        bookAndIdList2.forEach(tuple -> System.out.println(tuple.get(0) + " : " + tuple.get(1)));

//        List<Tuple> bookAndIdList3 = bookRepository.findTupleByBooks("LCK에서 월즈까지");
//        bookAndIdList3.forEach(tuple -> System.out.println(tuple.get(0) + " : " + tuple.get(1)));

    }

    @Test
    void updateJpaTest1() {
//        int isUpdate = bookRepository.updateSpecificName(2L);
//        System.out.println("2번 id를 가진 book의 이름 " + (isUpdate > 0 ? "바뀜"  : "바뀌지 않음"));

//        int isDelete = bookRepository.deleteSpecificName(2L);
//        System.out.println("2번 id를 가진 book의 이름 " + (isDelete > 0 ? "삭제"  : "삭제 안됨"));

        int isInsert = bookRepository.insertSpecificName(7L);
        System.out.println("이모!!! 여기!!!!  " + (isInsert > 0 ? "고기추가요!!!!!"  : "고기추가 안됨"));

    }
}